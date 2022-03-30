import React, { useRef } from 'react';
import classes from './Search.module.css'
import Input from './../Commons/Input'
import Button from './Button'

const Search = (props) => {

  const searchInputRef = useRef();

    const handleKeyPress = e => {
        if(e.key === 'Enter') {
            searchHandler();
        }
    }

  

    const searchHandler = event => {
      event.preventDefault();

      const enteredWord = searchInputRef.current.value;
      // getKeyword(enteredWord);


      props.onSearch({
        keyword : enteredWord
      });

     
      

    }

  return (
    <div className={classes.search}>
    <Input className={classes.input} ref={searchInputRef} input = {{type: "text", id: "keyword"}} placeholder="검색어를 입력해주세요." onKeyPress={handleKeyPress} />
    <Button type="submit" className={classes.button} onClick={searchHandler}>검색</Button>

    </div>

    
  )
}

export default Search