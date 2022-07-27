import Message from "./Message"; // import Message from "./Message.js"

function App() {

  /**
   * Function
   */
  function funcName01(user) { // 'user'를 'key' 값으로 접근
    return user.name + " " + user.age;
  }

  const user = {
    name: "hellonayeon",
    age: 25
  }

  // 함수처럼 보이나 '상수'
  // arrow 함수 (특정 이름이 없는 함수)
  // function (not component)
  const funcName02 = (user) => {
    return user.name + " " + user.age; 
  }

  // '==' reference. '===' value.
  const flag = false;

  /**
   * Component
   */
  const MyComponent01 = () => {
    return (
      <div>
        <p>나의 컴포넌트</p>
      </div>
    );
  }

  // 태그들을 함수식으로 사용하게 만들면서,
  // 각각의 속성들을 접근할 수 있도록 만들 수 있다 !
  const MyComponent02 = (props) => { // properties = props
    return (
      <div>
        <p>나의 컴포넌트 이름: {props.name} {props.age} </p>
      </div>
    );
  }

  /**
   * Property
   */

  return (
    <div>
      <div>
          Hello (funcName01), { funcName01(user) }
      </div>
      <div>
          Hello (funcName02), { funcName02(user) }
      </div>
      <div>
        { flag && <p>flag: true</p> }
        { flag === false && <p>flag: false</p> } 
      </div>

      <MyComponent01/>

      <MyComponent02 name="hellonayeon" age="24" />

      <Message height="182.3" />

    </div>
  );
}

export default App;
