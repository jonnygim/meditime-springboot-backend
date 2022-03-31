import React from 'react'
import classes from './MediInfoButton.module.css'
import MediInfoModal from './MediInfoModal'

const MediInfoButton = (props) => {
  return (
    <MediInfoModal>
        <button className={classes.button} onClick={props.onOpen}>
        추가
        </button>
     </MediInfoModal>
  )
}

export default MediInfoButton