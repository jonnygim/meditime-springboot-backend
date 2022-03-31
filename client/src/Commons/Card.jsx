import React, { useState } from "react"
import classes from './Card.module.css'




export default function Card({data}){

   
    // const [number, setNumber] = useState(0);
    //  const likePlus = ()=>{ setNumber(number + 1) };
    //  const likeMinus = ()=>{ setNumber(number <= 0 ? 0 : number -1 )};
    const colorArr = [
        {color: '#ddd', fontSize:'1.5rem'},
        {color: '#f33', fontSize:'1.5rem'},
  
    ];
    const [like, setLike] = useState(0);
    const fnCheck = ()=>{ setLike(()=> like === 0 ? 1 : 0 ) };

   
    return(
        <li className={classes.li}>
            <div    className={classes.img_set}
                    style={{backgroundColor:data.imgUrl}}> {data.imgAlt}
            </div>
            <dl>
                <dt>{data.title}</dt>
                <dd>{data.content}</dd>
            </dl>
            <div className={classes.btns}>
                
            {/* <button type='button' onClick={likePlus} className='button'>+1</button>
            <button type='button' onClick={likeMinus} className='button'>-1</button> */}
            <button type='button' onClick={fnCheck} className={classes.button}> <span style={colorArr[like]}>❤</span></button>
            {/* <span>{number}</span> */}
            
                
                <a className={classes.view} href={data.detailLink}>상세보기</a>
            </div>
        </li>
    )
}  

