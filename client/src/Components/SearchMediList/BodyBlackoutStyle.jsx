import React from 'react'

// BodyBlackoutStyle
const BodyBlackoutStyle = ({ onSetIsVisible }) => {
    return (
      <div
        className="body-blackout-style"
        onClick={() => onSetIsVisible(false)}
      ></div>
    );
  };

export default BodyBlackoutStyle