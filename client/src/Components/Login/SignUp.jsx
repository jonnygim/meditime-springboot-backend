import React from 'react';
import {withRouter} from 'react-router-dom';

class SignUp extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      email: '',
      password: '',
      passwordCheck: '',
      name: '',
      validEmail: '',
      validPassword: '',
      validPasswordCheck: '',
      validName: '',
    };
  }
  handleSignUpValue = (key) => (e) => {
    if (key === 'email') {
      var emailreg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      var email = e.target.value;
      this.setState({ [key]: email });
      if (email.length > 0 && false === emailreg.test(email)) {
        this.setState({ validEmail: '올바른 이메일 형식이 아닙니다.' });
      } else {
        fetch({
          method: 'post',
          url: '????????????',
          data: {
            email: e.target.value,
          },
        })
          .then((res) => res.json())
          .then((res) => {
            if (res.data !== null) {
              this.setState({ validEmail: '이미 존재하는 이메일입니다. '});
            } else {
              this.setState({ validEmail: ''});
              this.setState({ [key]: email });
            }
          })
          .catch((err) => {
            console.error(err);
          });
        }
    }
    
    if (key === 'password') {
      var reg = /^(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
      var password = e.target.value;
      if (password.length > 0 && false === reg.test(password)) {
        this.setState({
          validPassword: '비밀번호 8자리 이상, 숫자/소문자 모두 포함.'
    });
    } else {
      this.setState({ validPassword: ''});
      this.setState({ [key]: e.target.value });
    }
  } 
  if (key === 'passwordCheck') {
    var passwordCheck = e.target.value;
    if (passwordCheck.length > 0 && this.state.password !== passwordCheck) {
      this.setState({ validPasswordCheck: '비밀번호가 일치하지 않습니다.'
  });
    } else {
      this.setState({ validPasswordCheck: ''});
      this.setState({ [key]: e.target.value });
    }
  }
  
  if (key === 'name') {
    this.setState({ [key]: e.target.value });
  }

  if (key === 'name'){
    var reg = /^(?=.*?[a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣~!@#$%^&*()_+|<>?:{}]).{2,10}$/;
    var name = e.target.value;
      if (name.length > 0 && false === reg.test(name)) {
        this.setState({
          validName: '닉네임 2글자 이상 10글자 이하'
    });
  } else {
    this.setState({ validName: ''});
    this.setState({ [key]: e.target.value });
  }
}

  };
  handleSignUpButton = () => {
    fetch({
      method: 'post',
      url: '???????',
      data: {
        useremail: this.state.email,
        password: this.state.password,
        name: this.state.name,
      },
    })
    .then((res) => res.json())
    .then((res) => {
      console.log('회원가입 완료');
    })
    .catch((err) => {
      console.error(err);
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
          <button
            onClick={(e) => {
              e.preventDefault();
              {
                this.handleSignUpButton();
              }
            }}
          >
            Submit
          </button>
        </div>
      </div>
    );
    }
  

}


export default SignUp;