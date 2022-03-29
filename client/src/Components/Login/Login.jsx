import React, {useState} from 'react'
import "./Login.css"
import { Link } from "react-router-dom";

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState(""); 
    
    const onEmailHandler = (event) => {
      setEmail(event.currentTarget.value);
    }
  
    const onPasswordHandler = (event) => {
      setPassword(event.currentTarget.value)
  }
  
    const onSubmit = (event) => {
      event.preventDefault();
    }
  
    return (
        <div class="login">
          <form>
          <div>로그인</div>
              <div><input name="email" type="email" placeholder="이메일" value={email} onChange={onEmailHandler} class="login__input"/></div>
              <div><input name="password" type="password" placeholder="비밀번호" value={password} onChange={onPasswordHandler} class="login__input"/></div>
              <div><button type="submit" onSubmit={onSubmit} class="login__button">로그인</button></div>
              <Link to="/signup"><button type="submit" onSubmit={onSubmit} class="login__button2">회원가입</button></Link>
          </form>
         
        </div>
      );
    }
  
  export default Login;