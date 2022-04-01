import React, { useRef, useState } from "react";
import Button from "../../Commons/Button";
import classes from "./AddMediInfo.module.css";
import _uniqueId from "lodash/uniqueId";

const AddMediInfo = (props) => {
  let isAuthorized = sessionStorage.getItem("isAuthorized");

  const addMediToCart = async () => {
    console.log(isAuthorized + props.itemName);
    await fetch(`http://localhost:8090/mediBox`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        userName: isAuthorized,
        itemName: props.itemName,
      }),
    });
  };

  return (
    <form className={classes.info}>
      <Button onClick={props.onOpen}>추가</Button>
    </form>
  );
};

export default AddMediInfo;
