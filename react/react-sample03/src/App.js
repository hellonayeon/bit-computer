import './App.css';

function App() {

  const numbers = [1, 2, 3, 4, 5];
  console.log(numbers);

  const listItems = numbers.map( (number) =>
    <li key = {number.toString()}>
      {number}
    </li>
  );


  /**
   * Event
   * onClick
   * onSubmit
   * onChange
   * onMouseOver
   */

  return (
    <div>
      <ul>
        {listItems}

        <br/>
        <button onClick={ () => { console.log('button click') } }>
          button
        </button>

        <br/>
        <br/>
        <input onChange={ (event) => { console.log(event.target.value) } }></input>

      </ul>
    </div>
  );
}

export default App;
