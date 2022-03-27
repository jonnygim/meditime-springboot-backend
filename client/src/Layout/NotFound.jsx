import React from 'react';
import { Link } from 'react-router-dom';
import classes from './NotFound.module.css'



const NotFound = () => {
    return (
    <div className={classes.notfound}>  
        <img className={classes.img} src="https://user-images.githubusercontent.com/97663140/160247292-2631e75a-0e48-4b4e-883f-fa10089526fa.jpg" alt="" />
        <br />
        어이, 
        잠깐. 
        <br />
        굳이 이세계로의 진입 시도를 하는 『저의』가 뭐지?
        <br />
        곤란해.
        <br /> 
        돌아가 줘. 
        <br />
        <Link className={classes.link} to="/"><a>여기를 눌러 원래 있던 곳으로 돌아가.</a></Link>
    </div>
    );
};
export default NotFound;

