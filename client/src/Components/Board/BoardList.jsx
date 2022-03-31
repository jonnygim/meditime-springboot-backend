import React, { useState, useEffect } from 'react'
import classes from './BoardList.module.css'
import { Link } from 'react-router-dom';
import Card from '../../Commons/Card';
import axios from 'axios';

export default function BoardList(){
  // const boardListData = ;
  const [boardListData, setBoardListData] = useState([])
  const dataUrl = './data/boardListData.json'

  useEffect( () => {
    axios.get(dataUrl)//그러면 위의 주소를 여기에 넣으면 된다. 
    .then(res =>  setBoardListData(res.data)) 
    .catch( console.log)
     }, [])


  return (
    <div className={classes.card_area}> 
      <h3 className={classes.h3}>게시판 목록</h3>
      <Link to="/" ><span className={classes.new}>글쓰기</span></Link>
         <ul className={classes.card_wrap}>
         {
           boardListData.map((card) => <Card data={card} key={card.id}/>)
          
         } 
         </ul>
    </div>
  )}