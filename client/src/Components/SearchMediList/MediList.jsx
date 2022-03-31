import React, { useState } from 'react';
import Search from '../../Commons/Search';
import classes from './MediList.module.css';
import OneMedi from './OneMedi';
import MediCartProvider from './../Store/MediCartProvider'
import Modal from 'react-modal/lib/components/Modal';
import Medison from '../MediInfo/Medison';

const MediList = (props) => {
  
const [keyword, setkeyword] = useState("")

const getKeyword = (keyword) => {
  setkeyword(keyword);
}
 
 const BASE_URL = `http://localhost:8090/medicines?keyword=`;
  
  
const [medisons, setMedisons] = useState([]);
  

// 요청
  const searchResultHandler = (result) => {
    
    console.log(result);
    console.log(BASE_URL+result.keyword);
    
    const fetchMedisons = async () => {
      const response = await fetch(BASE_URL+result.keyword);
      console.log(response.ok);
      
      const responseData = await response.json();
      console.log(responseData);
      
      const medisonsData = [];
      for (const key in responseData) {
        medisonsData.push({
          id: key,
          itemName: responseData[key].itemName,
          entpItem: responseData[key].entpItem,
          efcItem: responseData[key].efcItem,
          methItem: responseData[key].methItem,
          warnItem: responseData[key].warnItem,
          atpnItem: responseData[key].atpnItem,
          intrItem: responseData[key].intrItem,
          seItem: responseData[key].seItem,
          depoItem: responseData[key].depoItem,
          itemImage: responseData[key].itemImage,

        });
      }
      setMedisons(medisonsData);
    }
    fetchMedisons().catch(error => console.log(error));
  }


  // medison.
  const mediList = medisons.map((medison) =>
    <OneMedi
      key={medison.id}
      id={medison.id}
      image={medison.itemImage}
      name={medison.itemName}
      efcItem = {medison.efcItem}
      onOpen={()=>setModalIsOpen(true)}

      />
  )

  const [modalIsOpen, setModalIsOpen] = useState(false);
  // <div className={classes.medipeople}>

  // <button onClick={()=> setModalIsOpen(true)}>Modal Open</button>
  //   <Modal className={classes.modal} isOpen={modalIsOpen}>
  //     This is Modal content
  //     <button onClick={()=> setModalIsOpen(false)}>Modal Close</button>
  //   </Modal>
  // </div>
  const mediInformation = medisons.map((medison)=>
    <Medison
      image={medison.itemImage}
      name={medison.itemName}
      entpItem={medison.entpItem}

      onOpen={()=>setModalIsOpen(true)}

      />
  )
  return (

    <>
       {/* {cartIsShown && <OneMedi onClose={closeCartHandler}/>} */}
      <div className={classes.medititle}>
        <h2>처방약의 이름을 정확히 입력해주세요!</h2>
        <Search onSearch={searchResultHandler} getKeyword={getKeyword}/>
        <li className={classes.medilist}>
          <ul>{mediList}</ul>

          <Modal className={classes.modal} isOpen={modalIsOpen}>
       {mediInformation}
      <button onClick={()=> setModalIsOpen(false)}>Modal Close</button>
   </Modal>
        </li>
      </div>
    </>
    
  )
}

export default MediList