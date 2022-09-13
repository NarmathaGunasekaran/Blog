import Carcousels from '../components/Carcousels'
import Col from "react-bootstrap/Col";
import AppBody from '../components/AppBody'
import Row from "react-bootstrap/Row";
// import { blogs } from "../data/dummy";
import Title from "../components/Title";
import BlogItem from '../components/BlogItem';
import Footers from '../components/Footers';
import blogApi from '../api/blog'
import React, { useEffect, useState } from 'react'
import { UserContext } from "../context/UserContext";
import { useContext } from "react";
import { useNavigate } from 'react-router-dom'
import AppNav from '../components/AppNav';
// import { blogs } from '../data/dummy';


const HomeLogin = () => {
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
    .catch((err)=> console.log(err));
  },[]);
  return (
    <div>
      <AppNav />
      <AppBody />
      <Carcousels />

      <Row>
        <Col>
          <Title title="Blog" />

          <Row xl={2} md={4} className="g-4">
            {blogs.map((blog, index) => {
              return (
                <Col key={index} md={5}>
                  {/* {Blogs.map((blog) => { */}
                    <BlogItem
                      name={blog.title}
                      desc={blog.description}
                      image={blog.image}
                    />
                  {/* })} */}
                </Col>
              );
            })}
          </Row>

        </Col>
      </Row>

      <Footers />
    </div>

  )
}

export default HomeLogin