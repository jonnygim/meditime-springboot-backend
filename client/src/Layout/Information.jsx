import React from 'react';
import Search from '../Commons/Search';
import MediList from '../Components/SearchMediList/MediList';
import classes from './Information.module.css';

const Information = () => {
  return (
    <div className={classes.information}>
      <Search onSearch={}/>
      <MediList/>
    </div>
  )
}

export default Information