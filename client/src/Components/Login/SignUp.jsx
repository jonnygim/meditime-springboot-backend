import React from 'react';

class SignUp extends React.Component {
  
  constructor(props) {
    super(props);
    this.state = {
      userId: '',
      validUserId: '',
      password: '',
      passwordCheck: '',
      validPassword: '',
      validPasswordCheck: '',
      email: '',
      validEmail: '',
    };
  }

  // 유효성 검사
  handleSignUpValue = (key) => (e) => {
    
    // if (key === 'email') {
    //   var email = e.target.value;
    //   this.setState({ [key]: email });
    // } else if (key === 'password') {
    //   var password = e.target.value;
    //   this.setState({ [key]: password });
    // } else if (key === 'paaaswordCheck') {
    //   var passwordCheck = e.target.value;
    //   this.setState({ [key]: passwordCheck });
    // } else if (key === 'userId') {
    //   var name = e.target.value;
    //   this.setState({ [key]: userId });
    // } else if (key === 'validUserId') {
    //   var validUserId = e.target.value;
    //   this.setState({ [key]: validUserId });
    // }

    // 아이디 
    if (key === 'userId') {
      this.setState({ [key]: e.target.value });
    }

    // 아이디 중복확인
    if (key === 'userId'){
      var reg = /^(?=.*?[a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣~!@#$%^&*()_+|<>?:{}]).{2,10}$/;
      var name = e.target.value;
      if (name.length > 0 && false === reg.test(name)) {
        this.setState({ validName: '닉네임 2글자 이상 10글자 이하' });
      } else {
        this.setState({ validName: ''});
        this.setState({ [key]: e.target.value });
      }
    }

    // 비밀번호 중복 검사
    if (key === 'password') {
      var reg = /^(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
      var password = e.target.value;

      if (password.length > 0 && false === reg.test(password)) {
        this.setState({ validPassword: '비밀번호 8자리 이상, 숫자/소문자 모두 포함.' });
      } else {
        this.setState({ validPassword: ''});
        this.setState({ [key]: e.target.value });
      }
    } 

    // 비밀번호 확인
    if (key === 'passwordCheck') {
      var passwordCheck = e.target.value;

      if (passwordCheck.length > 0 && this.state.password !== passwordCheck) {
        this.setState({ validPasswordCheck: '비밀번호가 일치하지 않습니다.'});
      } else {
        this.setState({ validPasswordCheck: ''});
        this.setState({ [key]: e.target.value });
      }
    }

    // 이메일 중복 검사
    if (key === 'email') {
      var emailreg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      var email = e.target.value;
      this.setState({ [key]: email });

      if (email.length > 0 && false === emailreg.test(email)) {

        this.setState({ validEmail: '올바른 이메일 형식이 아닙니다.' });

      } else {

        const response = fetch('http://127.0.0.1:8090/sign/validate', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: {
            email: e.target.value,
          },
        })
        // .then((res) => res.json())
        .then((res) => {
          console.log(res);
          console.log( res.json());
          if (res === "true") {
            console.log('response :' + res.json());
            this.setState({ validEmail: '이미 존재하는 이메일입니다. '});
          } else {
            this.setState({ validEmail: ''});
            this.setState({ [key]: email });
          }
        })
        .catch((err) => {
           console.error(err);
         });

         const result =  response.json;
         console.log(result);
      }
    }
  
  };
  


  // 회원가입 버튼 클릭 이벤트
  handleSignUpButton = () => {

    // console.log(this.state.name);
    // console.log(this.state.password);
    // console.log(this.state.email);

    fetch('http://127.0.0.1:8090/sign/signup',
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        userId: this.state.name,
        userPw: this.state.password,
        userEmail: this.state.email,
        userBorn: "1995",
        userGender: "M",
        regDate: new Date().getDate(), 
      }),
    })
    // .then((res) => res.json())
    .then((res) => {
      console.log('회원가입 완료');
    })
    .catch((err) => {
      console.error(err);
      console.log("에러다");
    });
    
  };

  render() {
    const { history } = this.props;
    return (
      <div class="card">
        <ul>
          <li>
          <label htmlFor="email">
              <div>email</div>
              <input id="email" type="email" onChange={this.handleSignUpValue('email')}  ></input>
              <div>{this.state.validEmail}</div>
            </label>
          </li>
          <li>
            <label htmlFor="password">
              <div>비밀번호</div>
              <input type="password" onChange={this.handleSignUpValue('password')}></input>
              <div>{this.state.validPassword}</div>
            </label>
          </li>
          <li>
            <label htmlFor="password check" onChange={this.handleSignUpValue('passwordCheck')}>
              <div>비밀번호 확인</div>
              <input type="password"></input>
              <div>{this.state.validPasswordCheck}</div>
            </label>
          </li>
          <li>
            <label htmlFor="Name" onChange={this.handleSignUpValue('name')}>
              <div>닉네임</div>
              <input type="name"></input>
              <div>{this.state.validName}</div>
            </label>
          </li>
        </ul>
        <div>
          <button onClick={(e) => {
              // e.preventDefault();
              {this.handleSignUpButton();}
            }}>
            Submit
          </button>
        </div>
      </div>
    );
    }
  

}


export default SignUp;