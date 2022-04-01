import React, { useState } from 'react'
import { Link, useNavigate } from "react-router-dom";
import "./Login.css"
import * as auth from "../modules/auth";
import Home from "../../Layout/Home"

function Login() {
    const [userId, setUserId] = useState("");
    const [password, setPassword] = useState(""); 

    const navigate = useNavigate();
    
    const onUserIdHandler = (event) => {
      setUserId(event.currentTarget.value);
    }
  
    const onPasswordHandler = (event) => {
      setPassword(event.currentTarget.value)
  }
  
    const onSubmit = (event) => {
      event.preventDefault();
      console.log("로그인 시작");
      auth.login(userId, password).then((res) => {
        console.log(res);
        if (res.resultcode === 1) {
          //console.log("code : 1");
          navigate('/', { replace: true});
          alert("로그인 성공");
        } else {
          alert("아이디와 비밀번호를 확인하세요!")
        }
      });
    }
  
    return (
        <div class="login">
          <form>
          <div>로그인</div>
              <div><input name="id" type="id" placeholder="아이디" value={userId} onChange={onUserIdHandler} class="login__input"/></div>
              <div><input name="password" type="password" placeholder="비밀번호" value={password} onChange={onPasswordHandler} class="login__input"/></div>
              <div><button type="submit" onClick={onSubmit} class="login__button">로그인</button></div>
              <Link to="/signuppage"><button type="submit" onChange={onSubmit} class="login__button2">회원가입</button></Link>
          </form>
         
        </div>
      );
    }
  
  export default Login;