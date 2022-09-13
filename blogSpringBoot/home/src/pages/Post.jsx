import React from 'react'
import "../assets/css/post.css"
import AppNav from '../components/AppNav'
import Footers from '../components/Footers'
import { useEffect, useState, PostApi } from 'react'
import { UserContext } from "../context/UserContext";
import { useContext } from "react";
import blogApi from '../api/blog'
import { useNavigate } from 'react-router-dom'

const Post = ({ open, setOpen }) => {
    const [post, setPost] = useState({  
        title : "",
      description : "",
      image : ""});
    const handleClose = () => {
        setOpen(false);
    };

    const PostApi = (event) => {
        event.preventDefault();
        blogApi
            .post("/post", post)
            .then(
                (response) => {
                    let data = response.data;
                    if (data.data) {
                        console.log(data.data)
                    } else if (data.error) {
                        console.log(data.error.message);
                    }
                },
                (error) => {
                    console.log(`Axios -> ${error.message}`);
                }
            )
            .catch((error) => {
                console.log("Something went wrong");
            });
    };
    return (
        <div>
            <AppNav />
            <div className="container px-4 py-5 mx-auto">
                <div className="row d-flex justify-content-center">
                    <div className="card1">
                        <div className="row px-3">
                            <img className="profile-pic mr-3" src="https://i.imgur.com/6tPhTUn.jpg" />
                            <div className="flex-column">
                                <h3 className="mb-0 font-weight-normal">Narmatha</h3>
                                <select name="privacy" className="privacy">
                                    <option>Public post</option>
                                    <option>Private post</option>
                                </select>
                            </div>
                        </div>
                        <div className="row px-3 form-group">
                            <p>Id</p>
                            <textarea className="text-muted bg-light mt-4 mb-3" placeholder="Hi, what's on your mind today?" value={post.id}
                                onChange={(event) => {
                                    console.log(event.target.value);
                                    setPost({ id: event.target.value });
                                }}></textarea>
                        </div>
                        <div className="row px-3 form-group">
                            <p>Name</p>
                            <textarea className="text-muted bg-light mt-4 mb-3" placeholder="Hi, what's on your mind today?" value={post.title}
                                onChange={(event) => {
                                    console.log(event.target.value);
                                    setPost({ title: event.target.value });
                                }}></textarea>
                        </div>

                        <div className="row px-3 form-group">
                            <p>Desc</p>
                            <textarea className="text-muted bg-light mt-4 mb-3" placeholder="Hi, what's on your mind today?" value={post.description}
                                onChange={(event) => {
                                    console.log(event.target.value);
                                    setPost({ description: event.target.value });
                                }}></textarea>
                        </div>

                        <div className="row px-3">
                            <img className="options" src="https://img.icons8.com/material/24/000000/more--v2.png" width="30px" height="28px" />
                            <div className="btn btn-success ml-auto"onClick={(event) => {
                                PostApi(event);
                            }}
                            > Post
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footers />
        </div>
    )
}

export default Post