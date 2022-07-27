import React, { useState } from "react";
import "./style.css";

  // select: 좋아하는 과일
  // radio : 좋아하는 과자
  

const FavoriteFruit = () => {
  
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

const FavoriteColor = () => {

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
 
function App() {

  return (
    <div className="App">
        <FavoriteFruit/>
        <FavoriteColor/>
    </div>
  );
}

export default App;
