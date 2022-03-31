import React from 'react'
import classes from './MyBox.module.css';
import MediCart from '../Components/MediCart/MediCart'


const Mybox = () => {
  return (
    <div className={classes.mybox}>Mybox
    
    <MediCart/>
    </div>

  )
}

export default Mybox