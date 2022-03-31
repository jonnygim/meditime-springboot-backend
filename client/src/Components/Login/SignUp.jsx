import React from 'react';

class SignUp extends React.Component {

  isAuthorized = sessionStorage.getItem("isAuthorized");
  
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
      bornYear:'',
      validBornYear:'',
      gender:'',
    };
  }
  
  /** 유효성 검사 */
  // 아이디 유효성 검사
  handleIdValue = (key) => (e) => {
    if (key === 'userId'){
      var reg = /^(?=.*?[a-zA-Z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣~!@#$%^&*()_+|<>?:{}]).{2,10}$/;
      var blank_pattern = /\s/g;
      
      var userId = e.target.value;

      if (userId.length > 0 && false === reg.test(userId)) {
        
        this.setState({ validUserId: '아이디 2글자 이상 10글자 이하' });

      } else {

        const response = fetch('http://127.0.0.1:8090/user/validate', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            userId: userId,
          })
        })
        .then((res) => res.json())
        .then((data) => {
          console.log("아이디 중복확인 데이터 : " + data);
        
          if (data) {
            console.log('response(success) : 존재하는 아이디');
            this.setState({ validUserId: '이미 존재하는 닉네임입니다. '});
          } else {
            this.setState({ validUserId: ''});
            this.setState({ [key]: userId });
          }
        })
        .catch((err) => {
           console.error(err);
         });
        
    }


    // } else if (key === 'email') {
    //   var emailreg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    //   var email = e.target.value;
    //   this.setState({ [key]: email });

    //   if (email.length > 0 && false === emailreg.test(email)) {

    //     this.setState({ validEmail: '올바른 이메일 형식이 아닙니다.' });

    //   } else {

    //     const response = fetch('http://127.0.0.1:8090/user/validate', {
    //       method: 'POST',
    //       headers: {
    //         'Content-Type': 'application/json'
    //       },
    //       body: JSON.stringify({
    //         userEmail: e.target.value,
    //       })
    //     })
    //     .then((res) => res.json())
    //     .then((data) => {
    //       console.log("이메일 중복확인 데이터 : " + data);
          
    //       if (data) {
    //         console.log('response : 존재하는 이메일');
    //         this.setState({ validEmail: '이미 존재하는 이메일입니다. '});
    //       } else {
    //         this.setState({ validEmail: ''});
    //         this.setState({ [key]: email });
    //       }
    //     })
    //     .catch((err) => {
    //        console.error(err);
    //      });
    //   }
    }
    
  };

  // 유효성 검사
  handleSignUpValue = (key) => (e) => {
    
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

    // 이메일 확인
    if (key === 'email') {
      var emailreg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      var email = e.target.value;
      this.setState({ [key]: email });

      if (email.length > 0 && false === emailreg.test(email)) {

        this.setState({ validEmail: '올바른 이메일 형식이 아닙니다.' });

      } else {
        this.setState({ validEmail: ''});
        this.setState({ [key]: email });
      }
    }


    
    //출생년도 확인
    if (key === 'bornYear') {
      var reg = /^(19[0-9][0-9]|20\d{2})$/;
      var bornYear = e.target.value;

      if (bornYear.length > 0 && false === reg.test(bornYear)) {
        this.setState({
          validBornYear: '출생년도 4자리 입력, 숫자 외 입력금지'
        });
      } else {
        this.setState({ validBornYear: ''});
        this.setState({ [key]: e.target.value });
      }
    }

    //성별 확인
    if (key === 'gender') {
      this.setState({ [key]: e.target.value });
    }
  
  };
  
  getToday = () => {
    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + "-" + month + "-" + day;
}

  // 회원가입 버튼 클릭 이벤트
  handleSignUpButton = () => {

    console.log(this.state.userId);
    console.log(this.state.password);
    console.log(this.state.email);
    console.log(this.state.bornYear);
    console.log(this.state.gender);
    console.log(year + "-" + month + "-" + day);

    var date = new Date();
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);


    if(!this.state.userId || !this.state.password || !this.state.email || !this.state.bornYear || !this.state.gender) {
      alert('항목을 모두 입력해주세요!');
    }
    fetch('http://127.0.0.1:8090/user/signup',
    {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        userId: this.state.userId,
        userPw: this.state.password,
        userEmail: this.state.email,
        userBorn: this.state.bornYear,
        userGender: this.state.gender,
        regDate: year + "-" + month + "-" + day, 
      }),
    })
    // .then((res) => res.json())
    .then((res) => {
      if(res.ok) {
        console.log('회원가입 완료');

      }
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
            <label htmlFor="UserId" onChange={this.handleSignUpValue('userId')}>
              <div>아이디</div>
              <input type="userId" onBlur={this.handleIdValue('userId')}></input>
              <div>{this.state.validUserId}</div>
            </label>
          </li>
          <li>
          <label htmlFor="email">
              <div>email</div>
              <input id="email" type="email" onChange={this.handleSignUpValue('email')}></input>
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
            <label htmlFor="BornYear" onChange={this.handleSignUpValue('bornYear')}>
              <div>출생년도</div>
              <input type="bornYear"></input>
              <div>{this.state.validBornYear}</div>
            </label>
          </li>
          <li>
            <label htmlFor="Gender" onChange={this.handleSignUpValue('gender')}>
              <div>성별</div>
              남자<input type="radio" name="gender" value="M"></input>
              여자<input type="radio" name="gender" value="W"></input>
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