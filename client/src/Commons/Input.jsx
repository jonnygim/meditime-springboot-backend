import React from 'react';
import classes from './Input.module.css';

// forwardRef 적용
const Input = React.forwardRef((props, ref) => {
  return <div >
      <input className={classes.input} ref={ref} {...props.input} />
  </div>;
});

export default Input;
