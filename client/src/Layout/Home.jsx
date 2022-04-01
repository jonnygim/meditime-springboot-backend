import React from "react";
import classes from "./Home.module.css";

const Home = () => {
  return (
    <div className={classes.total}>
      <h1 className={classes.ment}>
        복약방은
        <br /> 안전한 약 복용을 위한
        <br />
        약정보 조회, 소통 플랫폼입니다.
      </h1>
      <h5 className={classes.story}>
        복약방은 막연했던 처방약에 대한 정보를 제공하고 이를 이용하여 <br />{" "}
        자유롭게 소통할 수 있는 공간을 제공합니다. <br />
        약에 대해 이해하기 어려운 증상이나 경험들을 자유롭게 이야기할 수
        있습니다.{" "}
      </h5>
      <img
        className={classes.main}
        src="https://user-images.githubusercontent.com/97663140/160862458-ef5335dc-f15b-4f17-87cb-49709bee249a.jpg"
        alt=""
      />
    </div>
  );
};

export default Home;
