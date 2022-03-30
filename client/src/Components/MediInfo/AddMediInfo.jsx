import React, { useRef, useState } from 'react'
import Button from '../../Commons/Button';
import classes from './AddMediInfo.module.css'

const AddMediInfo = (props) => {
  
  // const [id] = useState(_uniqueId('prefix-'))

  // const inputRef = useRef();

  const submitHandler = (event) => {
      event.preventDefault();
      const CountValue =1 ;
      const CountValueToNumber = +CountValue;
      props.onAddToCart(CountValueToNumber);
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