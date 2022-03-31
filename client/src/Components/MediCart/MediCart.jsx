import React, {useContext} from 'react'
import classes from './MediCart.module.css'
import MediCartContext from '../../Store/MediCartContext'
import MediCartItem from './MediCartItem';

const BASE_URL = 'http://localhost:8090/api/v1/medibox';

const Cart = (props) => {

  const cartContext = useContext(MediCartContext);

  const cartTitle = (
    <ul className={classes.carttitle}>
      약상자
      <hr />
    </ul>
  )

  const totalAmount = `${cartContext.totalAmount.toFixed(0)}`;

  const cartItems = (
    
    <ul className={classes["cartItems"]}>
      {cartContext.items.map((medison) => (
        <MediCartItem
        key={medison.id}
        id={medison.id}
        name={medison.name}
        image={medison.image}
        onRemoveInCart = {() => cartContext.removeItem(medison.names)}
        />
      ))}
    </ul>
  )

  const cartItemsTotal = (
    <div className={classes.total}>
      <span>총 복약 수</span>
      <span>{totalAmount}</span>
    </div>
  );

 

 
   


  return (
    <>
    {cartTitle}
    {cartItems}
    {cartItemsTotal}
    </>
  )
}

export default Cart
