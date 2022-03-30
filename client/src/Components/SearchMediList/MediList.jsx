import React, { useState } from 'react';
import Search from '../../Commons/Search';
import classes from './MediList.module.css';
import OneMedi from './OneMedi';

const MediList = (props) => {
  
const [keyword, setkeyword] = useState("")

const getKeyword = (keyword) => {
  setkeyword(keyword);
}
 
 const BASE_URL = `http://localhost:8090/api/v1/medisons/`;
  
  //미친자식.  
  
const [medisons, setMedisons] = useState([]);
  

// 요청
  const searchResultHandler = (result) => {
    
    console.log(result);
    console.log(`${BASE_URL}${result}`);
    
    const fetchMedisons = async () => {
      const response = await fetch(`${BASE_URL}${result}`);
      console.log(response.ok);
      
      const responseData = await response.json();
      console.log(responseData);
      
      const medisonsData = [];
      for (const key in responseData) {
        medisonsData.push({
          id: key,
          itemName: responseData[key].item_name,
          entpItem: responseData[key].entp_name,
          efcItem: responseData[key].efc_item,
          methItem: responseData[key].meth_item,
          warnItem: responseData[key].item_image,
          atpnItem: responseData[key].item_image,
          intrItem: responseData[key].item_image,
          seItem: responseData[key].item_image,
          depoItem: responseData[key].item_image,
          itemImage: responseData[key].item_image,

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
      image={medison.image}
      name={medison.name}
      />
  )




// 그냥 
// const medisonsList = await axios.get(BASE_URL);
  // console.log(medisonsList);
  // setMedisons({medisons : medisonsList})




  return (

    
    <div className={classes.medititle}>
      <h2>처방약의 이름을 정확히 입력해주세요!</h2>
      <Search onSearch={searchResultHandler} getKeyword={getKeyword}/>
      <li className={classes.medilist}>
        <ul>{mediList}</ul>
      </li>
    </div>
  )
}

export default MediList