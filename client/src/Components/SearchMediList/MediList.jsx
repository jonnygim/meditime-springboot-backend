import React, { useEffect, axios, useState } from 'react'
import Search from '../../Commons/Search';
import classes from './MediList.module.css'
import OneMedi from './OneMedi';

const MediList = (props) => {


// const keyword = 

const BASE_URL = `http://localhost:8090/api/v1/medisons/${props.id}`;

  const[medisons, setMedisons] = useState([]);

  // medison.~ 는 데이터에 맞춰서 수정해야 할거임
  const mediList = medisons.map((medison)=>
    <OneMedi
        key={medison.id}
        id={medison.id}
        image={medison.image}
        name={medison.name}
    />
    )

// 요청필요한데 어케하는지 몰름
useEffect(()=>{
  console.log('호출');
  const fetchMedisons = async() => {
    const response = await fetch(BASE_URL);
    console.log(responseData);

    const responseData = await response.json();
    console.log(responseData);

    const medisonsData = [];
    for (const key in responseData){
      medisonsData.push({
        id: key,
        image : responseData[key].image,
        name : responseData[key].name,
      });
    }
    setMedisons(medisonsData);
  }
  fetchMedisons().catch(error => console.log(error));
  
}, []);





  // const medisonsList = await axios.get(BASE_URL);
  // console.log(medisonsList);

  // setMedisons({medisons : medisonsList})
  
  



  

  return (
    


    <li className={classes.medilist}>
        
        {mediList}
    </li>
  )
}

export default MediList