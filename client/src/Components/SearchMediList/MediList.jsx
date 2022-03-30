import React, { useState } from 'react';
import Search from '../../Commons/Search';
import classes from './MediList.module.css';
import OneMedi from './OneMedi';
const MediList = () => {
  const [keyword, setKeyword] = useState("");
  const getKeyword = (keyword) => {
    setKeyword(keyword);
  }
  // 문제는 여기서 key값이 안들어간다는 것임 진짜 미친놈인가 ? 좀 아라서 알아들으면 안되?
  // 진짜 눈물남 아니 외않되는데 ㅠ ㅠ ㅠ ㅠㅠㅠ되던것도 안돼 ㅠㅠㅠㅠㅠㅠㅠㅠ진짜 울고싶닥
  // 현실: 눈이 뻑뻑해서 눈물도 안남
  const BASE_URL = `http://localhost:8090/medicines/${keyword}`;
  const [medisons, setMedisons] = useState([]);
  // medison.~ 는 데이터에 맞춰서 수정해야 할거임
  const mediList = medisons.map((medison) =>
    <OneMedi
      key={medison.id}
      id={medison.id}
      image={medison.image}
      name={medison.name}
    />
  )
  // 요청
  const searchResultHandler = () => {
    const fetchMedisons = async () => {
      const response = await fetch(BASE_URL);
      console.log(responseData);
      const responseData = await response.json();
      console.log(responseData);
      const medisonsData = [];
      for (const key in responseData) {
        medisonsData.push({
          id: key,
          image: responseData[key].image,
          name: responseData[key].name,
        });
      }
      setMedisons(medisonsData);
    }
    fetchMedisons().catch(error => console.log(error));
  }
// 이것은 우리의 브레인스토밍흔적
  // const medisonsList = await axios.get(BASE_URL);
  // console.log(medisonsList);
  // setMedisons({medisons : medisonsList})
  return (
    <li className={classes.medilist}>
      <Search onSearch={searchResultHandler} getKeyword={getKeyword} />
      {mediList}
    </li>
  )
}
export default MediList