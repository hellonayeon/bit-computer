import React from "react"
import Session from "react-session-api";

function App() {

  function save() {
      // let counter = 10;
      // Session.set("counter", counter);

      // let obj = { "id": "abc", "pwd": "123" };
      // Session.set("obj", obj);

      let jsonObj = [ {"name": "NaYeon Kwon", "number": 1001}, {"name": "Doong Doong 🐾", "number": 1002} ]
      Session.set("jsonObj", jsonObj);
  }

  function load() {
      // let count = Session.get("counter");
      // alert(count);

      // let obj = Session.get("obj");
      // alert(JSON.stringify(obj));
      // alert(obj.id);

      let jsonObj = Session.get("jsonObj");
      alert(jsonObj[1].name)
  }

  return (
    <div>
        <h3>Session Test</h3>

        <button type="button" onClick={save}> Session Save </button>
        <button type="button" onClick={load}> Session Load </button>
    </div>
  );
}

export default App;
