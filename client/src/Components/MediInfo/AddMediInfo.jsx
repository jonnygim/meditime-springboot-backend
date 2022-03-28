import React, { useRef, useState } from 'react'
import Button from '../../Commons/Button';
import classes from './AddMediInfo.module.css'

const AddMediInfo = (props) => {
  
  // const [id] = useState(_uniqueId('prefix-'))

  // const inputRef = useRef();

  const submitHandler = (event) => {
      event.preventDefault();
      const headCountValue =1 ;
      const headCountValueToNumber = +headCountValue;
      props.onAddToCart(headCountValueToNumber);
  }
  
  
    return (
    <form className={classes.info}>
        <Button type="submit" onClick={submitHandler}>
           약상자에 추가
        </Button>
    </form>
  )
}

export default AddMediInfo