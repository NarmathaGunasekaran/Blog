import React from 'react'
import Card from 'react-bootstrap/Card';
import Button from "react-bootstrap/Button";
import { Link } from "react-router-dom";
import { useEffect, useState } from 'react'
import { UserContext } from "../context/UserContext";
import { useContext } from "react";
import blogApi from '../api/blog'
import { useNavigate } from 'react-router-dom'

const BlogItem = ({ image, name, desc, id }) => {
  const navigate = useNavigate();
  const { loggedInUser, userBlog, setLoggedInUser } = useContext(UserContext);
  const [blogs,] = useState([]);
  return (
    <Card>
      {/* <Card.Img src={image} /> */}
      <Card.Body>
        <Card.Title>{name}</Card.Title>
        <Card.Text>{desc}
        </Card.Text>
        <Button onClick={(e) => {
          navigate(`/blog/${id}`)
        }}>Read More</Button>

      </Card.Body>
    </Card>
  );
};

export default BlogItem