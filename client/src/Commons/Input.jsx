import React from 'react';

// forwareRef 적용 전.
// const Input = (props) => {
//   return <div className={classes.input}>
//       <label htmlFor={props.input.id}>{props.label}</label>
//       <input {...props.input} />
//   </div>;
// };

// forwardRef 적용 후.
const Input = React.forwardRef((props, ref) => {
  return <div >
      <input ref={ref} {...props.input} />
  </div>;
});

export default Input;
