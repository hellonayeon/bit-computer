import logo from './logo.svg';
import './App.css';

function App() {

  // 소스부
  const name = "hellonayeon";
  var age = 24;
  let addr = "경기도 고양시 야옹야옹";
  const elem = <h3>{ name } {age}</h3>

  // (className == class)
  return (
    <div className="App"> 
      <h1>Hello React { name } { age } { addr } :)</h1>

      { elem }

      <h2 style={ {color: 'yellow', backgroundColor:'#0000FF' } }>Test Title</h2>



    </div>
  );
}

export default App;
