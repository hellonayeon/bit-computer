import React, { useState } from "react";

function FavoriteFruit() {
  
    const fruitOptions = [
      {key: 1, value: "사과 🍎"},
      {key: 2, value: "포도 🍇"},
      {key: 3, value: "딸기 🍓"}
    ]
  
    const [fruit, setFruit] = useState();
    const selectFruit = (event) => {
      setFruit(event.target.value);
    }
  
    return (
      <>
        <div>
          <h3>좋아하는 과일: {fruit}</h3>
          <select name="fruits" onChange={selectFruit}>
            <option>좋아하는 과일 선택</option>
              { 
                fruitOptions.map((item, idx) => (
                    <option key={item.key} value={item.value}>{ item.value }</option>  
                )) 
              }
          </select>
        </div>
        <br/><br/>
      </>
    );
  }

  export default FavoriteFruit;