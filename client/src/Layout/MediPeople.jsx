import React, { useState } from 'react'
import classes from './MediPeople.module.css';
import Modal from 'react-modal';
const MediPeople = () => {

  const [modalIsOpen, setModalIsOpen] = useState(false);

  return (
    <div className={classes.medipeople}>

    <button onClick={()=> setModalIsOpen(true)}>Modal Open</button>
      <Modal className={classes.modal} isOpen={modalIsOpen}>
        This is Modal content
        <button onClick={()=> setModalIsOpen(false)}>Modal Close</button>
      </Modal>
    </div>

  )
}

export default MediPeople