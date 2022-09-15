import React, { createContext, useState } from "react";
import blogApi from "../api/blog";

const UserContext = createContext();

const UserProvider = ({ children }) => {
    const [loggedInUser, setLoggedInUser] = useState({
        userId: 0,
        userName: "",
        isLoggedIn: false,
    });

    const [blog, setBlogs] = useState([]);

    const searchblog = (userName) => {
        return blogApi.reduce((acc, curr) => {
            if (curr.name === userName) {
                acc = curr;
            }
            return acc;
        }, {});
    };
    return (
        <UserContext.Provider
            value={{
                loggedInUser,
                setLoggedInUser,
                searchblog,
                setBlogs,
                blog,
            }}
        >
            {children}
        </UserContext.Provider>
    );
};

export { UserContext, UserProvider };