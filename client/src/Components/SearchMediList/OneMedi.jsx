import React, { useContext, useState } from "react";
import MediCartContext from "./../../Store/MediCartContext";
import classes from "./OneMedi.module.css";
import AddMediInfo from "./../MediInfo/AddMediInfo";
import Button from "../../Commons/Button";

const OneMedi = (props) => {
  console.log(props.name);

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
  };

  const addItemToMediCartHandler = () => {
    console.log(props.id);
    console.log(props.name);
    console.log(props.image);

    mediCartContext.addItem({
      id: props.id,
      itemName: props.name,
      itemImage: props.image,
    });
  };

  // 약과 사용자 관계의 데이터베이스에 담기를 요청하는 메서드
  const BASE_URL = `http://localhost:8090/medibox`;

  let isAuthorized = sessionStorage.getItem("isAuthorized");
  const mediName = props.name;
  console.log("밖" + mediName);

  // Submit 결과 메시지 확인용 Toggle
  const [didSubmit, setDidSubmit] = useState(false);

  const addOneMediToMediCartHandler = async (props) => {
    console.log(props.itemName);
    console.log(isAuthorized);
    console.log("handler" + mediName);
    await fetch(BASE_URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userId: isAuthorized,
        itemName: mediName,
      }),
    });
  };

  const [detailStatus, setdetailStatus] = useState(false);

  const onClickToggle = (e) => {
    setdetailStatus((prevStatus) => (prevStatus ? false : true));
  };

  return (
    <>
      <div>
        <div className={classes.onemedi}>
          <img className={classes.img} src={props.image} alt="Medison Image" />
          <h3 className={classes.h3}>{props.name}</h3>
          <div className={classes.buttons}>
            <Button onClick={onClickToggle}>상세보기</Button>
            <AddMediInfo onOpen={addOneMediToMediCartHandler} />
          </div>
        </div>
        {/* {detailStatus ? <MediDetail/> : null} */}
        <div
          id="mediDetail"
          className={
            detailStatus ? classes.medi__detail__on : classes.medi__detail__off
          }
        >
          <h4>효능</h4>
          <li>{props.efcItem}</li>
          <h4>사용법</h4>
          <li>{props.methItem}</li>
          <h4>주의사항</h4>
          <li>{props.atpnItem}</li>
          <h4>상호작용</h4>
          <li>{props.intrItem}</li>
          <h4>부작용</h4>
          <li>{props.seItem}</li>
        </div>
      </div>
      <hr className={classes.hr} />
    </>
  );
};

export default OneMedi;
