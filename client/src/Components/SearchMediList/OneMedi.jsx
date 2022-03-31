import React from 'react';
import MediInfo from '../MediInfo/MediInfo';
import classes from './OneMedi.module.css';

const OneMedi = (props) => {

  console.log(props.image);
  
  return (
  
    <div className={classes.onemedi}>
      <img className={classes.img} src={props.image} alt="Medison Image" />
      <h3>{props.name}</h3>
      <button className={classes.button} onClick={props.onOpen}>상세 보기</button>
      <hr />
      
      
      {/* <MediInfo  /> */}
    </div>

  )
}

export default OneMedi