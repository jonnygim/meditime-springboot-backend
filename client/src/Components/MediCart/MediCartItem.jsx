import React from 'react'
import Button from '../../Commons/Button'
import classes from './MediCartItem.module.css'

const MediCartItem = (props) => {
    

    return (
        <li className={classes.cartitem}>
            <img src={props.itemImage} alt="약 이미지" />
            <h2>{props.name}</h2>
            <Button onClick={props.onRemoveInCart}>삭제</Button>


        </li>
    )
}

export default MediCartItem