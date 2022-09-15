import React from 'react'
import { useEffect } from 'react';
import { useContext } from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";
import { UserContext } from '../context/UserContext';

const AppNav = () => {

  const { loggedInUser } = useContext(UserContext);

  useEffect(() => {
    console.log(loggedInUser);
  }, [])

  return (
    <div><Navbar collapseOnSelect expand="lg" bg="rgb(238, 130, 238)" variant="dark">
      <Container>

        {loggedInUser.role === "ADMIN" ? <Navbar.Brand as={Link} to="/admin">
          Blog
        </Navbar.Brand> : <Navbar.Brand as={Link} to="/">Blog
        </Navbar.Brand>}
        <Nav>
          <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="me-auto">
              {loggedInUser.role === "ADMIN" ? <Nav.Link as={Link} to="/admin">
                Home
              </Nav.Link> : <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>}

              {/* <Nav.Link as={Link} to="/Blogs" >
                Blog
              </Nav.Link> */}
              {loggedInUser.isLoggedIn ? <Nav.Link as={Link} to="/login">
                Logout
              </Nav.Link> :
                <>
                  <Nav.Link as={Link} to="/login">
                    Login
                  </Nav.Link>
                  <Nav.Link as={Link} to="/Register">
                    Register
                  </Nav.Link>
                </>}
            </Nav>
          </Navbar.Collapse>
        </Nav>

      </Container>
    </Navbar>

    </div>
  )
}

export default AppNav