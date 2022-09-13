import React from 'react'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";





const AppNav = () => {
 
  return (
    <div><Navbar collapseOnSelect expand="lg" bg="rgb(238, 130, 238)" variant="dark">
      <Container>

        <Navbar.Brand as={Link} to="/">
          Blog
        </Navbar.Brand>
        <Nav>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>
                <Nav.Link as={Link} to="/Blogs" >
                  Blog
                </Nav.Link>
            

              <Nav.Link as={Link} to="/login">
                Login
              </Nav.Link>
              <Nav.Link as={Link} to="/Register">
                Register
              </Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Nav>

      </Container>
    </Navbar>

    </div>
  )
}

export default AppNav