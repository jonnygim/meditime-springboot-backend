import React, { useRef, useState } from 'react'
import Button from '../../Commons/Button';
import classes from './AddMediInfo.module.css'
import _uniqueId from 'lodash/uniqueId'

const AddMediInfo = (props) => {
  
  const [id] = useState(_uniqueId('prefix-'));


  const inputRef = useRef();

  let isAuthorized = sessionStorage.getItem("isAuthorized");
  const BASE_URL_FOR_ADD = '';
  const addMediToCart = async() => {
    await fetch(BASE_URL_FOR_ADD,
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userName : isAuthorized,
          itemName: props.itemName
        })
      })

  }
  
  
    return (
    <form className={classes.info}>
        <Button type="submit" onClick={addMediToCart}>
           추가
        </Button>
    </form>
  )
}

export default AddMediInfo