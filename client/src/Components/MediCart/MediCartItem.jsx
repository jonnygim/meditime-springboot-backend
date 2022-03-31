import React from 'react'
import Button from '../../Commons/Button'
import classes from './MediCartItem.module.css'

const MediCartItem = (props) => {


    return (
        <li className={classes.cartitem}>
            <h2>{props.name}</h2>
            <div className={classes.summary}>
                {/* <span>{props.효능}</span> */}
            <Button onClick={props.onRemoveInCart}>삭제</Button>

            </div>

        </li>
    )
}

export default MediCartItem