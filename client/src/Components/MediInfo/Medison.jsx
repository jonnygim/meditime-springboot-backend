import React, { useContext } from 'react'
import classes from './Medison.module.css'
import MediCartContext from '../Store/MediCartContext';
import AddMediInfo from './AddMediInfo';

const Medison = (props) => {
  const cartContext = useContext(MediCartContext);

  const addItemToMediCartHandler = amount => {
    console.log(amount);
    cartContext.addItem({
      id: props.id,
      name: props.name,
      entpItem: props.entpItem,
      efcItem: props.efcItem ,
      methItem: props.methItem,
      warnItem: props.warnItem,
      atpnItem: props.atpnItem,
      intrItem: props.intrItem,
      seItem: props.seItem,
      depoItem: props.depoItem,
      itemImage: props.itemImage
      
    })
  }

  
  return (
    <li className={classes.book}>
      <div className={classes.book__info}>
        <img src={props.image} alt="Medison" />
        <h3>{props.name} <span className={classes.entpItem}>{props.entpItem}</span></h3> 
        <div className={classes.efcItem}>{props.efcItem}</div>
        <div className={classes.methItem}>{props.methItem}</div>
        <div className={classes.warnItem}>{props.warnItem}</div>
        <div className={classes.atpnItem}>{props.atpnItem}</div>
        <div className={classes.intrItem}>{props.intrItem}</div>
        <div className={classes.seItem}>{props.seItem}</div>
        <div className={classes.depoItem}>{props.depoItem}</div>



      </div>
        {/* <AddMediInfo onAddToCart={addItemToMediCartHandler}></AddMediInfo> */}
        
    </li>

  )
}

export default Medison