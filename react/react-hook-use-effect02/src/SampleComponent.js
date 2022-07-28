import React, {useState, useEffect} from "react"


const INITIAL_COUNT = 0;

const SampleComponent = () => {
    const [count, setCount] = useState(INITIAL_COUNT);

    const callbackFunc = () => {
        document.title = `${count} 번 클릭했습니다 👆🏻`;
    }

    useEffect(callbackFunc, [count]); // count 가 변화되면 callbackFunc()를 호출하라는 의미

    const countIncrement = () => {
        setCount((pCount) => pCount + 1);
    }

    const countReset = () => {
        setCount(INITIAL_COUNT);
    }

    return (
        <>
            <h3>현재 카운트: {count}</h3>
            
            <button onClick={countIncrement}> + </button>
            <button onClick={countReset}> reset </button>
        </>
    );
}

export default SampleComponent;