import React, { useState } from 'react'
import { Navigate } from 'react-router-dom'
import classes from './MediPeople.module.css';
import Modal from 'react-modal';
import Login from '../Components/Login/Login';


const MediPeople = () => {
  let isAuthorized = sessionStorage.getItem("isAuthorized");

  if(!isAuthorized) {
      return <Navigate to="/login" element={<Login />} />
    }


  //const [modalIsOpen, setModalIsOpen] = useState(false);

  return (
    <div className={classes.medipeople}>

{/* onClick={()=> setModalIsOpen(true)} */}
    <button >Modal Open</button>
      {/* <Modal className={classes.modal} isOpen={modalIsOpen}>
        This is Modal content
        <button onClick={()=> setModalIsOpen(false)}>Modal Close</button>
      </Modal> */}
    </div>

  )
}

export default MediPeople