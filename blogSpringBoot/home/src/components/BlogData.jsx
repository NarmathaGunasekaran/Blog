import React from 'react'
import Card from 'react-bootstrap/Card';
import Button from "react-bootstrap/Button";
import "../assets/css/blog.css"



const BlogData = ({image, name, desc }) => {
    return (
        <Card className='mt-3'>
      <Card.Img src={image} />
      <Card.Body>
        <Card.Title>{name}</Card.Title>
        <Card.Text>{desc}
        </Card.Text>        
      </Card.Body>
    </Card>
        
    )
}

export default BlogData