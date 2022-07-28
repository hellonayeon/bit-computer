import {useState, useMemo} from "react";

function App() {

  const [countStateA, setCountStateA] = useState(0);
  const [countStateB, setCountStateB] = useState(0);

  const countResultA = () => {
    setCountStateA( (pCount) => pCount + 1 );
    console.log("A + 1 버튼 클릭 👆🏻");
  }

  const countResultB = () => {
    setCountStateB( (pCount) => pCount + 1 );
    console.log("B + 1 버튼 클릭 👆🏻");
  }

  const square = (params) => {
    console.log("square() 함수 실행");
    return params * params;
  }

  // 컴포넌트 안에서 변경된 영역만 변경
  // B 에 대한 변경만 감지하고 싶은 경우
  const squareArea = useMemo( () => square(countStateB), [countStateB]);

  return (
    <div>
        <h5>
          계산 결과 A: {countStateA}
          <button onClick={countResultA}> 계산 A+1 </button>
        </h5>
        <h5>
          계산 결과 B: {countStateB}
          <button onClick={countResultB}> 계산 B+1 </button>
        </h5>

        <h5>[정사각형의 면적] 계산 결과 B x 계산 결과 B = {squareArea}</h5>
    </div>
  );
}

export default App;
