import React, { useEffect } from 'react'
import AppNav from '../components/AppNav'
import "../assets/css/blog.css"
import Footers from '../components/Footers'
import { useNavigate } from 'react-router-dom'
import { UserContext } from '../context/UserContext'
import { useContext } from "react";
import blogApi from '../api/blog'
import { useState } from "react";
import BlogData from '../components/BlogData'



const Blogs = () => {
    const navigate = useNavigate();
    const { loggedInUser, userBlog, setLoggedInUser } = useContext(UserContext);
    const [blogs, setBlogs] = useState([]);
    useEffect(() => {
        blogApi
            .get(`post/all`)

            .then((res) => {
                let data = res.data;
                if (data.data) {
                    console.log(data.data)
                    setBlogs(data.data);
                } else if (res.data.error) {
                    console.log(res.data.error.message);
                } else {
                    console.log("Something went wrong");
                }
            })
            .catch((err) => console.log(err));
    }, []);
    return (
        <div>
            <AppNav />

            {blogs.map((blog) => {
                return (
                    <BlogData
                        name={blog.title}
                        desc={blog.description}
                        image={blog.image}
                    />
                );
            })}

            <Footers />
        </div>
    )
}

export default Blogs