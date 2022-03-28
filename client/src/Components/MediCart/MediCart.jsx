import React, {useContext} from 'react'
import classes from './MediCart.module.css'
import MediCartContext from './../Store/MediCartContext'
import MediCartItem from './MediCartItem';

const Cart = (props) => {

  const cartContext = useContext(MediCartContext);

  const cartTitle = (
    <ul className={classes.carttitle}>
      약상자
      <hr />
    </ul>
  )

  const cartItems = (
    <ul className={classes['cartItems']}>
      {cartContext.items.map((medison) => (
        <CartItem
          onClick = {() => cartContext.removeItem(medison.id)}
          key={medison.id}
          name={medison.name}
          // dydir={joblec.headcount}
        />
      ))}
    </ul>
  )

   


  return (
    <>
    
    
    </>
  )
}

export default Cart