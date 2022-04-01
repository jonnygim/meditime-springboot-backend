export function login(id, password) {
    // return new Promise((res, rej) => {

    //   return setTimeout(() => {
    //       console.log("setTiem" + id + password);
    //       fetch('http://127.0.0.1:8090/user/login', 
    //       {
    //         method: 'POST',
    //         headers: {
    //           'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify({
    //           userId: id,
    //           userPw: password,
    //         }),
    //       }
    //       .then((response) => {
    //           console.log(response);
    //           sessionStorage.setItem("isAuthorized", id);
    //           return res({ resultcode: 1 });

    //         })
    //       )}, 300);
    // });

    console.log("setTiem" + id + password);
    return new Promise( async (res, rej) => {
        const response = await fetch('http://127.0.0.1:8090/user/login', 
          {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
              userId: id,
              userPw: password,
            })
          })
          .then(response => response.json())
          .then((data) => {
              console.log("data : " + data);
              if(data) {
                  console.log("response : success");
                  sessionStorage.setItem("isAuthorized", id);
                  return res({ resultcode: 1 });
              } else {
                  return res({ resultcode: 0 });
              }
              

            })
    });
  }