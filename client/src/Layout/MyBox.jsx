import React from 'react'
import classes from './MyBox.module.css';
import MediCart from '../Components/MediCart/MediCart'


const Mybox = ({ user }) => {

  const { userId, userPw } = user || {};

  return (
    <div className={classes.mybox}>Mybox
      <h1>회원 이름 : {userId}</h1>
      <MediCart/>
    </div>

  )
}

export default Mybox