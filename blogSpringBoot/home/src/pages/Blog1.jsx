import React from 'react'
import "../assets/css/blog1.css"
import AppNav from '../components/AppNav'
import Footers from '../components/Footers'
import b1 from "../assets/images/b1.jpg";
import blogApi from '../api/blog';
import  { useEffect, useState } from 'react'
import { Link, useParams } from "react-router-dom";
const Blog1 = () => {

        let params = useParams();

        const [blog, setBlogs] = useState({});

        useEffect(() => {

            if (params.id !== undefined) {

                blogApi

                    .get(`/post/${params.id}`)

                    .then((res) => {

                        if (res.data.data) {

                            setBlogs(res.data.data);

                        } else if (res.data.error) {

                            console.log(res.data.error.message);

                        } else {

                            console.log("Something went wrong");

                        }

                    })

                    .catch((error) => {

                        console.log(`Error -> ${error}`);

                    });

            }

        }, []);
        return (
            <div>
                <AppNav />
                <p>{blog.title}</p>
                      <p>{blog.description}</p>
                      <p>{blog.image}</p>
    
                            <div className='comment'>
                                <div className="h-80 px-7 w-[700px] rounded-[12px] bg-white p-4">
                                    <p className="text-xxl font-semibold text-blue-900 cursor-pointer transition-all hover:text-black center">Add Comment/Questions</p>
                                    <textarea className="h-40 px-3 text-sm py-3 mt-5 outline-none border-pink-300 w-full resize-none border rounded-lg placeholder:text-sm" placeholder="Add your comments here"></textarea>

                                    <div className="flex justify-between mt-2"> <button className=" btn h-12 w-[150px] bg-blue-400 text-sm text-black rounded-lg transition-all cursor-pointer hover:bg-blue-600 ">Submit comment</button>
                                        <p className="text-sm text-blue-900 ">Enter atleast 15 characters</p>
                                    </div>
                                </div>
                            </div>
                       

                <Footers />
            </div>
        )
    }


    export default Blog1