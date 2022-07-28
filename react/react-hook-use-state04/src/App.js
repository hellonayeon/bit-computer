
// Component 규칙
// 1. 첫 글자는 대문자
// 2. '_'(under bar) 포함하면 경고
// 3. function 과의 차이? component는 적어도 하나의 return 문 존재

import { useState } from "react";

// 외부 컴포넌트
function MyMessageComponent() {
  return (
      <h1>MyMessage Component</h1>
  );
}

// App == main
function App() {

  // Hook (사용할 변수)
  // const [getter, setter] = useState("initial value")
  const [text, setText] = useState("initial text !");


  // 내부 컴포넌트
  const Msg = () => {

    const [inputText, setInputText] = useState("initial input value !");
    
    function btnClick() {
      setText(inputText);
    }

    function handleChange(e) {
      setInputText(e.target.value)
    }

    return (
      <div>
        <p>📨 메시지 📨</p>
        <h3>text: {text}</h3>
        <button type="button" onClick={btnClick}>버튼</button>

        <input type="text" value={inputText} onChange={handleChange}/> 
      </div>
    );
  }


  return (
    <div>
        <MyMessageComponent/>
        <Msg/>
    </div>    
  );
}

export default App;
