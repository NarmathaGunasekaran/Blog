import React, { useState, useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { UserContext } from "../../context/UserContext";
import blogApi from '../../api/blog';
import "../../assets/css/login.css"

const LoginComponents = () => {
    const navigate = useNavigate();
    const { setLoggedInUser } = useContext(UserContext);
    const [login, setLogin] = useState({ userName: "", password: "" });
    const [loginError, setLoginError] = useState({ userName: "", password: "" });


    const loginAPI = (event) => {
        event.preventDefault();

        blogApi
            .post(`/auth/login`, {
                userName: login.userName,
                password: login.password,
            })
            .then((res) => {
                if (res.data.data) {
                    let loggedInUser = res.data.data;
                    loggedInUser.isLoggedIn = true;
                    setLoggedInUser(loggedInUser);
                    if (loggedInUser.role === "ADMIN") {
                        navigate("/admin")
                    } else
                        navigate("/");
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

    return (
        <div>
            <form>
                <div className="container px-4 py-5 mx-auto">
                    <div className="card card0 h-50">
                        <div className="d-flex flex-lg-row flex-column-reverse">
                            <div className="card card1">
                                <div className="row justify-content-center my-auto">
                                    <div className="col-md-8 col-10 my-5">
                                        <div className="row justify-content-center px-3 mb-3">
                                            <img id="logo" src="https://i.imgur.com/PSXxjNY.png" />
                                        </div>
                                        <h3 className="mb-5 text-center heading">BLOG</h3>

                                        <h6 className="msg-info">Please login to your account</h6>

                                        <div className="form-group">
                                            <label className="form-control-label text-muted">Username</label>
                                            <input
                                                type="text"
                                                className="form-control"
                                                placeholder="Username"
                                                value={login.userName}
                                                onChange={(event) => {
                                                    let userName = event.target.value;
                                                    if (userName.length > 2) {
                                                        setLoginError({ ...loginError, userName: "" });
                                                    } else {
                                                        setLoginError({ ...loginError, userName: "Enter a vaild name " });
                                                    }
                                                    setLogin({ ...login, userName: userName });
                                                }}
                                            />
                                            <label className="form-text text-danger">
                                                {loginError.userName}
                                            </label>
                                        </div>

                                        <div className="form-group ">
                                            <label className="form-control-label text-muted">Password</label>
                                            <input
                                                type="password"
                                                className="form-control"
                                                placeholder="Password"
                                                value={login.password}
                                                onChange={(event) => {
                                                    let password = event.target.value;
                                                    if (password.length > 2) {
                                                        setLoginError({ ...loginError, password: "" });
                                                    } else {
                                                        setLoginError({ ...loginError, password: "Enter a vaild name " });
                                                    }
                                                    setLogin({ ...login, password: password });
                                                }}
                                            />
                                            <label className="form-text text-danger">
                                                {loginError.password}
                                            </label>
                                        </div>
                                        <div className="row justify-content-center my-3 px-3">
                                            <button className="btn-block btn-color" type="submit"
                                                onClick={(event) => loginAPI(event)}
                                            >
                                                Login
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <div className="bottom text-center mb-5">
                                    <p href="#" className="sm-text mx-auto mb-3">Don't have an account?
                                        <Link to="/register">
                                            <button className="btn btn-white ml-2">Register</button></Link></p>
                                </div>
                            </div>
                            <div className="card card2 w-50">
                                <div className="my-auto mx-md-5 px-md-5 right">
                                    <h3 className="text-white">We are more than just a company</h3>
                                    <small className="text-white">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </form>
        </div>


    )
}

export default LoginComponents