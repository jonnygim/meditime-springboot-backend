import React, { useState } from "react";
import classes from "./Card.module.css";
import { Link } from "react-router-dom";

export default function Card({ data }) {
  const styleArr = [{ color: "#000" }, { color: "#f00" }];
  const [like, setLike] = useState(0);
  const [checkState, setCheckState] = useState("");
  const likeCheck = (e) => {
    setLike(() => (like === 0 ? 1 : 0));
    setCheckState(e.target.checked);
  };

  return (
    <li className={classes.li}>
      <div className={classes.writers}>
        작성자:{data.writer}({data.medicine})
      </div>
      <div className={classes.img_set} style={{ backgroundColor: data.url }}>
        {" "}
        {data.imgAlt}
      </div>
      <div>
        <div className={classes.contents}>{data.content}</div>

        <div className={classes.btns}>
          <input
            class="blind"
            type="checkbox"
            id={data.id}
            name={data.id}
            onChange={likeCheck}
            data-checked={checkState}
            value="좋아요체크"
          />

          <label className={classes.label} htmlFor={data.id}>
            <input className={classes.like_button} type="button"></input>
            <span style={styleArr[like]}>LIKE ❤</span>
          </label>
          <Link to={`/more/&{data.id}`} className={classes.more}>
            <span>상세보기</span>
          </Link>
        </div>
      </div>
    </li>
  );
}
