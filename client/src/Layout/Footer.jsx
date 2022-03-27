import React from 'react'
import classes from './Footer.module.css'

const Footer = () => {
  return (

    <div className={classes.footer}>
      <div className={classes.footer__text}>
        <div className={classes.stie__name}>농담2조</div>
        <div className={classes.footer__text__info}>
          <p><span><strong>· 백엔드 개발 &nbsp;&nbsp;</strong>김영애</span></p>  
          <p><span><strong>· 백엔드 개발 &nbsp;&nbsp;</strong>김종원</span></p>  
          <p><span><strong>· 프론트엔드 개발 &nbsp;&nbsp;</strong>양지현</span></p>  
          <p><span><strong>· 프론트엔드 개발 &nbsp;&nbsp;</strong>이동빈</span></p>  
          <p><span><strong>· 이메일 &nbsp;&nbsp;</strong>meditime@example.com&nbsp;</span></p>  
          <p><span><strong>· 고객지원 &nbsp;&nbsp;</strong>오전 10시 ~ 오후 5시 (주말 및 공휴일 제외)</span></p>  
        </div> 
        <div className={classes.copyright}>
        Copyright ⓒ 2022 농담2조 All rights reserved.
        </div>
      </div>
      <div className={classes.footer__menu}>
        <ul className={classes.footer__all_nav}>
          <li><a href=""><span>뭐적냐</span></a></li>
          <li><a href=""><span>뭐적어</span></a></li>
          <li><a href=""><span>뭐적지</span></a></li>
          <li><a href=""><span>뭐넉냐능@@</span></a></li>
        </ul>
      </div>
      <div className={classes.footer__policy}>
        <ul>
          <li><a href="">이용약관</a></li>
          <li><a href="">개인정보처리방침</a></li>
        </ul>
      </div>
    </div>

  )
}

export default Footer