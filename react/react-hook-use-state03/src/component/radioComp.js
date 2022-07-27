import React, { useState } from "react";

function FavoriteColor() {

    const colorOptions = [
      {key: 1, value: "빨간색 ❤️"},
      {key: 2, value: "노란색 💛"},
      {key: 3, value: "보라색 💜"}
    ]
  
    const [color, setColor] = useState();
    const checkColor = (event) => {
      setColor(event.target.value);
    }
  
    return (
      <>
        <div>
          <h3>좋아하는 색깔: {color}</h3>
  
          {
            colorOptions.map((item, idx) => (
              <div key={item.key}>
                <label>{item.value}</label>
                <input type="radio" name="color" value={item.value} onChange={checkColor}></input>
              </div>
            ))
          }
        </div>
      </>
    );
  }

  export default FavoriteColor;