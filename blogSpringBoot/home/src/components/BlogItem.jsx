import React from 'react'
import Card from 'react-bootstrap/Card';
import Button from "react-bootstrap/Button";
import { Link } from "react-router-dom";
import { useEffect, useState } from 'react'
import { UserContext } from "../context/UserContext";
import { useContext } from "react";
import blogApi from '../api/blog'
import { useNavigate } from 'react-router-dom'

const BlogItem = ({ image, name, desc }) => {
  const navigate = useNavigate();
  const { loggedInUser, userBlog, setLoggedInUser } = useContext(UserContext);
  const [blogs, ] = useState([]);
  
  // useEffect(() => {
  //   blogApi
  //     .get(`post/id`)

  //     .then((res) => {
  //       let data = res.data;
  //       if (data.data) {
  //         console.log(data.data)
  //         setBlogs(data.data);
  //       } else if (res.data.error) {
  //         console.log(res.data.error.message);
  //       } else {
  //         console.log("Something went wrong");
  //       }
  //     })
  //     .catch((err) => console.log(err));
  // }, []);
  return (
    <Card>
      <Card.Img src={image} />
      <Card.Body>
        <Card.Title>{name}</Card.Title>
        <Card.Text>{desc}
        </Card.Text>
        <Button href='/Blog1'>Read More</Button>
        
      </Card.Body>
    </Card>
  );
};

export default BlogItem