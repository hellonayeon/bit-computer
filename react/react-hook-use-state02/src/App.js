
import React, { useState } from "react";
import "./style.css";


const INITIAL_COUNT = 0;
const INITIAL_NAME = "JavaScript";

const SampleComponent = () => {
  const [count, setCount] = useState(INITIAL_COUNT);
  const [name, setName] = useState(INITIAL_NAME);

  const countIncrement = () => setCount((prevCount) => prevCount + 1); // () 파라미터로 이전의 값 넘어옴
  const countDecrement = () => setCount((prevCount) => prevCount - 1);

  const countReset = () => setCount(INITIAL_COUNT);


  const handleChangeName = (e) => {
    setName(e.target.value);
  }

  const [text, setText] = useState("");
  const [inputTextVal, setInputTextVal] = useState("");
  const inputChange = (e) => setInputTextVal(e.target.value);
  const handleClick = () => {
    setText(inputTextVal);
  }

  return (
    <div>

      <p>
        현재 카운트: <b>{count}</b>
        <br />

          count의 초기값: <b>{INITIAL_COUNT}</b>
      </p>
      <br />

      <button onClick={countIncrement}> + </button>
      <button onClick={countDecrement}> - </button>
      <button onClick={countReset}> reset </button>
      <br/><br/>

      <p>
        Hello, <b>{name} :D</b>
        <br/>

        name의 초기값: <b>{INITIAL_NAME}</b>
      </p>

      <input type="text" onChange={handleChangeName}/>
      <br/>

      <p>text: { text }</p>
      <input type="text" onChange={inputChange} value={ inputTextVal }/>
      <input type="button" value="입력" onClick={handleClick} />
      <br/>



    </div>
  );
}

function App() {
  return (
    <div className="App">
        <SampleComponent/>
    </div>
  );
}

export default App;
