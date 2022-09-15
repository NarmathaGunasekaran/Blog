import React from 'react'
import "../../assets/css/admin.css"
import { useEffect, useState } from 'react'
import { useContext } from "react";
import { useNavigate } from 'react-router-dom'
import { Link } from "react-router-dom";
import Post from './Post';
import blogApi from '../../api/blog';
import { UserContext } from '../../context/UserContext';

const AdminCom = () => {
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

  const deleteApi = (event, id) => {
    event.preventDefault();
    blogApi
      .delete(`/post/${id}`)
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
  };
  const EditApi = (event) => {
    event.preventDefault();
    blogApi
      .put("/post", Post).then(
        (response) => {
          console.log(response);
          let data = response.data;
          if (data.data) {
            console.log(data.data);
            setBlogs(data.data);
            // setBlog(INITIAL_VALUE);
          } else {
            console.log(data.error.message);
          }
        },
        (err) => {
          console.log(err);
        }
      );
  };

  return (
    <div>
      <div>
        <div className="px-0 bg-light">
          <div className="d-flex">
            <div className="d-flex align-items-center " id="navbar"> <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-items" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation"> <span className="fas fa-bars"></span> </button> <a className="text-decoration-none fs14 ps-2" href="#">Blog<span className="fs13 pe-2">.com</span></a> </div>
            <div id="navbar2" className="d-flex justify-content-end pe-4"> <span className="far fa-user-circle "></span> </div>
          </div>
          <div className="d-md-flex">
            <ul id="navbar-items" className="p-0">
              <Link to="/admin">
                <li> <span className="ps-3 name">Dashboard</span></li></Link>
              {/* <Link to="/">
                <li> <span className="ps-3 name">Home</span></li></Link> */}
              <Link to="/Post">
                <li> <span className="ps-3 name">Post Add</span></li></Link>
              <Link to="/login">
                <li> <span className="ps-3 name">Logout</span></li></Link>
            </ul>

            <div id="topnavbar">

              <div className="table-responsive px-2">
                <table className="table table-borderless">
                  <thead>
                    <tr>
                      <th scope="col">BLOG<span>ID</span></th>
                      <th scope="col">BLOG<span className="ps-1">TITLE</span></th>
                      <th className="" scope="col ps-5">DESCRIPTION</th>
                      {/* <th className="" scope="col ps-5">IMAGE</th> */}
                      <th className="text-center" scope="col">ACTION</th>
                    </tr>
                  </thead>

                  {blogs.map((blog, index) => {
                    return (
                      <tbody >
                        <tr>
                          <td><span className="bg-blight">{blog.id}</span></td>
                          <td><span className="bg-blight">{blog.title}</span></td>
                          <td><span className="bg-blight">{blog.description}</span></td>
                          {/* <td><span className="bg-blight">{blog.image}</span></td> */}
                          <td className="text-center"><span className="fas fa-check"></span>
                            {/* <button
                              className="btn btn-primary btn-sm me-2" href='/post'
                              onClick={(event) => EditApi(event)}
                            >
                              Edit
                            </button> */}
                            <button
                              className="btn btn-secondary"
                              onClick={(event) => deleteApi(event, blog.id)}
                            >
                              Delete
                            </button></td>
                        </tr>
                      </tbody>
                    );

                  })}
                </table>

                {/* <div className="d-flex align-items-center justify-content-between px-3 mt-3">
                  <div className="bg-bdark fs13"> <span>Page</span> <input className="input-10 text-center" type="text" value="1" /> <span><span className="px-1">of</span>1</span> </div>
                </div> */}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  )
}


export default AdminCom