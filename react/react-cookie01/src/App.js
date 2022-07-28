import {useState} from "react";
import {useCookies} from "react-cookie";

function App() {

  const [name, setName] = useState("");
  const [cookie, setCookie] = useCookies(["name"]);

  const Save = () => {
    setCookie("name", name, { path: "/" });
  }

  const Load = () => {
    alert(cookie.name);
  }

  const changeName = (event) => setName(event.target.value);



  return (
    <>
        <h3>Cookie Test</h3>

        <input type="text" onChange={changeName} value={name}/>
        <button onClick={Save}> Save Cookie </button>
        <button onClick={Load}> Load Cookie </button>
    </>
  );
}

export default App;
