import './App.css';
import { React, useState } from "react"


/**
 * Hook (Hook의 목적)
 * 변수 (variable) - Setter, Getter 만들어 놓은 변수 
 * 외부에서는 const 로 접근하게끔 만들어 놓고, 외부에서 접근할 수 없도록 만들어 놓은 변수
 * Setter, Getter를 만들어 놓고 접근을 차단할 때 사용
 * 복잡성과 재사용성을 위해 나온 것이 Hook
 * 
 * 
 * 기본 Hook [필수]
 * useState 
 * useEffect
 * useContext
 * 
 * [추가]
 * useMemo
 * useRef 
 * 
 */

function App() {
  // state
  //     getter setter
  const [state, setState] = useState('클릭 전');

  // const 수정 불가
  // state = "Click";
  // setState("Click");

  console.log(state);

  const [msg, setMsg] = useState("");
  const btnClick = () => {
    alert(msg);
  }

  return (
    <div>
        <button onClick={ () => setState("클릭 후") }>
            {state}
        </button>
        <br/>

        <button onClick={btnClick}>
          button
        </button>
        <input onChange={ (event) => {setMsg(event.target.value)} }/>
    </div>
  );
}

export default App;
