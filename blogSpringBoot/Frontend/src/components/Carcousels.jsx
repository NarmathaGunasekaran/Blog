import React from 'react'
import Carousel from "react-bootstrap/Carousel";

import corouselOne from "../assets/images/d.jpg";
import corouselTwo from "../assets/images/e.jpeg";
import corouselThree from "../assets/images/c.jpg";
const Carcousels = () => {
  return (
    <div>

      <Carousel>
        <Carousel.Item className="carousel">
          <img width={2000} height={500} src={corouselOne} />
          <Carousel.Caption>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item className="carousel">
          <img width={2000} height={500} src={corouselTwo} />

          <Carousel.Caption>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item className="carousel">
          <img width={2000} height={500} src={corouselThree} />
          <Carousel.Caption>
            <p>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    </div>
  )
}

export default Carcousels