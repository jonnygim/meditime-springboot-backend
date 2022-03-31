import React, { useContext, useState } from 'react';
import MediCartContext from './../../Store/MediCartContext';
import classes from './OneMedi.module.css';
import AddMediInfo from './../MediInfo/AddMediInfo'
import Button from '../../Commons/Button';

const OneMedi = (props) => {

  

  const mediCartContext = useContext(MediCartContext);

  const addOneMediToMediInfoHandler = () => {
    mediCartContext.addOneMedi({
      id: props.id,
      itemName: props.itemName,
      entpItem: props.entpItem,
      efcItem: props.efcItem,
      methItem: props.methItem,
      warnItem: props.warnItem,
      atpnItem: props.atpnItem,
      intrItem: props.intrItem,
      seItem: props.seItem,
      depoItem: props.depoItem,
      itemImage: props.itemImage,
    });
    props.onOpen();

  }

  

  const addItemToMediCartHandler = () => {
    console.log(props.id);
    console.log(props.name);
    console.log(props.image);

    mediCartContext.addItem({

      id: props.id,
      itemName: props.name,
      itemImage: props.image,

    })
  }

// 약과 사용자 관계의 데이터베이스에 담기를 요청하는 메서드
  const BASE_URL = `http://localhost:8090/medicines?keyword=`;

  const addOneMediToMediCartHandler = async (userData) => {
    console.log(JSON.stringify({
      // userName : userData.,
      itemName : MediCartContext.items[MediCartContext.items.length-1].itemName,
    }));

    await fetch(BASE_URL,
      {
        method: 'POST',
        headers: {
          'Content-Type' : 'application/json'
        },
        body: JSON.stringify({
          // userName: 
          itemName : MediCartContext.items[MediCartContext.items.length-1].itemName,
        })
      }
      )

  }

  const [detailStatus, setdetailStatus] = useState(false);

  const onClickToggle = (e) => {
    setdetailStatus(prevStatus => prevStatus ? false : true);
  }

  // const MediDetail = () => {
  //   <div id="mediDetail" className={classes.medi__detail}>
  //   <li>효능: {props.efcItem}</li>
  //   <br />
  //   <li>사용법 : <br />{props.methItem}</li>
  //   <br />
  //   <li>주의사항경고: {props.warnItem}</li>
  //   <li>주의사항: {props.atpnItem}</li>
  //   <li>상호작용: {props.intrItem}</li>
  //   <li>부작용: {props.seItem}</li>
  //   </div>
  // }



  return (



    <div className={classes.onemedi}>
      <img className={classes.img} src={props.image} alt="Medison Image" />
      <h3>{props.name}</h3>
      <AddMediInfo onAddToCart={addItemToMediCartHandler}/>
      <Button onClick={onClickToggle}>상세보기</Button>
      {/* {detailStatus ? <MediDetail/> : null} */}
      <div id="mediDetail" className={detailStatus? classes.medi__detail__on : classes.medi__detail__off}>
        <li>효능: {props.efcItem}</li>
        <br />
        <li>사용법 : <br />{props.methItem}</li>
        <br />
        <li>주의사항: {props.atpnItem}</li>
        <li>상호작용: {props.intrItem}</li>
        <li>부작용: {props.seItem}</li>
      </div>
      <hr />


    </div>

  )
}

export default OneMedi