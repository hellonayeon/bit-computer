import {useEffect, useState} from "react"

function App() {

  const [count, setCount] = useState(0);

  useEffect( () => {
    console.log("use effect !!");
  }, []);

  return (
    <div>
        <p>count: {count}</p>
        <button onClick={ () => {setCount(count + 1)} }>카운터</button>
    </div>
  );
}

export default App;
