import {React, useState} from 'react'
import { useNavigate } from 'react-router-dom'

import classes from "./Header.module.css"

const useConfirm = (message = null, onConfirm, onCancel) => {
  if (!onConfirm || typeof onConfirm !== "function") {
    return;
  }
  if (onCancel && typeof onCancel !== "function") {
    return;
  }

  const confirmAction = () => {
    if (window.confirm(message)) {
      onConfirm();
    } else {
      onCancel();
    }
  };

  return confirmAction;
}

const Header = () => {
  const navigate = useNavigate();
  // const [isLogin, setIsLogin] = useState();

  let isAuthorized = sessionStorage.getItem("isAuthorized");

  const logoutConfirm = () => {
    sessionStorage.removeItem("isAuthorized");
    navigate('/', { replace: true});
    alert("로그아웃 되었습니다.");
  }
  const cancelConfirm = () => console.log("취소되었습니다.");
  const logoutHandler = useConfirm(
    "로그아웃 하시겠습니까?",
    logoutConfirm,
    cancelConfirm
  );

  const loginButton = isAuthorized ? <button className={classes.login} onClick={logoutHandler}>로그아웃</button> : <a className={classes.login} href="/login">로그인</a> 


  return (
      <>
    <header className={classes.header}>
        <img className={classes.logo} src="https://user-images.githubusercontent.com/97663140/160233148-9b13feed-24f7-4f8d-9cea-3cced55da4ee.png" alt="복약방" />
        <div className={classes.header__main__menu}>
        {/* <Link className={classes.link} to="/"><a>HOME</a></Link>
        <Link className={classes.link} to="/information"><a>정보조회</a></Link>
        <Link className={classes.link} to="/medipeople"><a>약과사람</a></Link>
        <Link className={classes.link} to="/mybox"><a>약상자</a></Link> */}

        <a  className={classes.link} href="/">HOME</a>
        <a className={classes.link} href="/information">정보조회</a>
        <a className={classes.link} href="/medipeople">약과사람</a>
        <a className={classes.link} href="/mybox">약상자</a>
        </div>

        {loginButton}
         
     </header>
      </>
  )
}


export default Header