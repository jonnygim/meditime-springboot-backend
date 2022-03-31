import React from 'react'
import classes from './MediPeople.module.css';
import BoardList from '../Components/Board/BoardList';
const MediPeople = () => {
  return (
    <div className={classes.medipeople}><BoardList/></div>
  )
}
export default MediPeople