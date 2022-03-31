import React from 'react'
import classes from "./Home.module.css"

const Home = () => {
  return (
  
    <div className={classes.total}>
      <h1 className={classes.ment}>복약방은<br/> 안전한 약 복용을 위한<br/>
 약정보 조회, 소통 플랫폼입니다. 

    </h1>
      <img className={classes.main}  src="https://user-images.githubusercontent.com/97663140/160862458-ef5335dc-f15b-4f17-87cb-49709bee249a.jpg" alt="" />
      
    </div>
  )
}

export default Home