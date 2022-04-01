import React, { useState } from "react";
import "./BoardSearch.module.css";

const BoardSearch = (props) => {
  const medi = props.searchMedicine;
  const [searchValue, setSearchValue] = useState("");
  const handleInputChange = (event) => {
    setSearchValue(event.target.value);
  };
  const shouldDisplayButton = searchValue.length > 0;
  const handleInputClear = () => {
    setSearchValue("");
  };

  const filteredMedi = medi.filter((medicine) => {
    return medicine.includes(searchValue);
  });

  return (
    <div className="searchBar">
      <input
        type="text"
        value={searchValue}
        placeholder="search value"
        onChange={handleInputChange}
      />
      {shouldDisplayButton && <button onClick={handleInputClear}>clear</button>}
      <ul>
        {filteredMedi.map((medicine) => {
          return <li key={medicine}>{medicine}</li>;
        })}
      </ul>
    </div>
  );
};
export default BoardSearch;
