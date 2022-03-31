import React, { useState } from 'react';
import Search from '../../Commons/Search';
import classes from './MediList.module.css';
import OneMedi from './OneMedi';

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
          entpName: responseData[key].entpName,
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

  // const addMediToContextHandler = () => {
    // modal에 출력하고 싶은 정보(property)들을 context객체에 등록
    // createContext.방금 만든 메서드 이름(담고싶은 정보를 객체로/)
    // modal 오픈 토글 활성화
  // };

  // const mediCartContext = useContext(MediCartContext);

  // const addOneMediToMediInfoHandler = () => {
  //   mediCartContext.addOneMedi({
  //     id:props.id,
  //     itemName: props.itemName,
  //     entpItem: props.entpItem,
  //     efcItem: props.efcItem,
  //     methItem: props.methItem,
  //     warnItem: props.warnItem,
  //     atpnItem: props.atpnItem,
  //     intrItem: props.intrItem,
  //     seItem: props.seItem,
  //     depoItem: props.depoItem,
  //     itemImage: props.itemImage,
  //   });
  //   props.onOpen();

  // }

  // medison.
  const mediList = medisons.map((medison) =>
    <OneMedi
      key={medison.id}
      id={medison.id}
      image={medison.itemImage}
      name={medison.itemName}
      entpName ={medison.entpName}
      efcItem = {medison.efcItem}
      methItem = {medison.methItem}
      warnItem = {medison.warnItem}
      atpnItem = {medison.atpnItem}
      intrItem = {medison.intrItem}
      seItem = {medison.seItem}
      depoItem = {props.depoItem}
      itemImage = {props.itemImage}
      // onOpen={()=> setModalIsOpen(true)}

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



  
  return (

    <>
       {/* {cartIsShown && <OneMedi onClose={closeCartHandler}/>} */}
      <div className={classes.medititle}>
        <h2>처방약의 이름을 정확히 입력해주세요!</h2>
        <Search onSearch={searchResultHandler} getKeyword={getKeyword}/>
        <li className={classes.medilist}>
          <ul>{mediList}</ul>
        </li>
      </div>
    </>
    
  )

  }
  
  {/* <Modal className={classes.modal} isOpen={modalIsOpen}>
{mediInformation}
<button onClick={()=> setModalIsOpen(false)}>Modal Close</button>
</Modal> */}
export default MediList