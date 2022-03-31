import React from 'react'
import { Navigate, Link } from 'react-router-dom'
import classes from './MyBox.module.css';
import MediCart from '../Components/MediCart/MediCart'
import Login from '../Components/Login/Login';


const Mybox = () => {
  let isAuthorized = sessionStorage.getItem("isAuthorized");

  if(!isAuthorized) {
      return <Navigate to="/login" element={<Login />} />
  }



  return (
    <div className={classes.mybox}>
      <h1>My Box</h1>
    <div>
      <h2>회원 이름 : {isAuthorized}</h2>
      <Link to='/signuppage'>정보수정</Link>
    </div>
    <br /><br />
    <MediCart/>
    </div>

  )
}

export default Mybox