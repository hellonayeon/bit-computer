import {useState, createContext} from "react";
import ConsumerComponent from "./ConsumerComponent";

let messageOne = ''; // global variable

function Message(props) {

  const [msg, setMsg] = useState();

  console.log(messageOne);

  return (
    <h5>
      [✉️ Message] {props.name} {msg}
    </h5>
  );
}

const SampleContextObj = createContext();


function App() {

  const [name, setName] = useState("NaYeon Kwon");

  messageOne = "Hello ✋🏻" // global variable
  const humanData = "Human 👩🏻‍💻"


  return (
    <>
      <Message name={name}/> 

      <SampleContextObj.Provider value={humanData}>
      <ConsumerComponent /> 
      </SampleContextObj.Provider>
    </>
  );
}

export default App;
