import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Routes, Route, Link } from "react-router-dom";
import Blogs from './pages/Blogs';
import Admin from './pages/Admin';
import Blog1 from './pages/Blog1';
import Post from './pages/Post';
import LoginComponents from './components/LoginComponents';
import RegisterComponents from './components/RegisterComponents';

import ProtectedRoutes from "./utils/ProtectedRoutes";
import { UserContext, UserProvider } from "./context/UserContext";
import { useContext } from "react";
import HomeLogin from './components/HomeLogin';

function App() {
  const { loggedInUser } = useContext(UserContext);
  console.log(loggedInUser);
  return (
    <>
        <Routes>
          <Route exact path="/" element={<HomeLogin />} />
          <Route path="/login" element={<LoginComponents />} />
          <Route path="/register" element={<RegisterComponents />} />

          <Route element={<ProtectedRoutes auth={loggedInUser.isLoggedIn} />}></Route>
          <Route path="/Blogs" element={<Blogs />} />
          <Route path="/admin" element={<Admin />} />
          <Route path="/Blog1" element={<Blog1 />} />
          <Route path="/Post" element={<Post />} />

        </Routes>
    </>
  );
}

export default App;
