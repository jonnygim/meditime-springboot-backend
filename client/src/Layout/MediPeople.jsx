import React from "react";
import { Navigate } from "react-router-dom";
import classes from "./MediPeople.module.css";
import BoardList from "../Components/Board/BoardList";
import Login from "../Components/Login/Login";

const MediPeople = () => {
  let isAuthorized = sessionStorage.getItem("isAuthorized");

  if (!isAuthorized) {
    return <Navigate to="/login" element={<Login />} />;
  }

  return (
    <div className={classes.medipeople}>
      <BoardList />
    </div>
  );
};
export default MediPeople;
