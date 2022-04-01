import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Card from "../../Commons/Card";
import Search from "../../Commons/Search";
import classes from "./BoardList.module.css";

export default function BoardList() {

  const [boardListData, setBoardListData] = useState([]);
  const dataUrl = "./data/boardListData.json";

  useEffect(() => {
    axios
      .get(dataUrl) //그러면 위의 주소를 여기에 넣으면 된다.
      .then((res) => setBoardListData(res.data))
      .catch(console.log);
  }, []);

  return (
    <div className={classes.card_area}>
      <h3 className={classes.h3}>게시판 목록</h3>
      <Link to={"/create"}>
        <span className={classes.new}>글쓰기</span>
      </Link>
      <div className={classes.search}>
        <Search />
      </div>

      <ul className={classes.card_wrap}>
        {boardListData.map((card) => (
          <Card data={card} key={card.id} />
        ))}
      </ul>
    </div>
  );
}
