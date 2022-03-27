import React from 'react'
import { Link } from 'react-router-dom';

import classes from "./Header.module.css"

const Header = () => {
  return (
      <>
    <header className={classes.header}>
        <img className={classes.logo} src="https://user-images.githubusercontent.com/97663140/160233148-9b13feed-24f7-4f8d-9cea-3cced55da4ee.png" alt="복약방" />
        <div className={classes.header__main__menu}>
        <Link className={classes.link} to="/"><a>HOME</a></Link>
        <Link className={classes.link} to="/information"><a>정보조회</a></Link>
        <Link className={classes.link} to="/medipeople"><a>약과사람</a></Link>
        <Link className={classes.link} to="/mybox"><a>약상자</a></Link>
        </div>


        <Link className={classes.login} to="/login"><a>로그인</a></Link>


    </header>
      </>
  )
}

export default Header