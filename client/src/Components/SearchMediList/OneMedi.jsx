import React from 'react';
import MediInfo from '../MediInfo/MediInfo';
import classes from './OneMedi.module.css';

const OneMedi = (props) => {
  

  
  
  
  return (
    <div className={classes.onemedi}>
      <img className={classes.img} src={props.image} alt="Medison Image" />
      <h3>{props.name}</h3>
      <MediInfo />
    </div>

  )
}

export default OneMedi