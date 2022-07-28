
import {BrowserRouter, Link, Routes, Route, useParams} from "react-router-dom"

function App() {
  return (
    <>
      <BrowserRouter>
          <nav>
              <ul>
                <li>
                  <Link to="/">Home</Link>
                </li>
                <li>
                  <Link to="/about">About</Link>
                </li>
                <li>
                  <Link to="/users">Users</Link>
                </li>
                <li>
                  <Link to="/topics">Topics</Link>
                </li>
                <li>
                  <Link to="/topic">Topic</Link>
                </li>
              </ul>
          </nav>

          <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/about" element={<About />} />
              <Route path="/users" element={<Users />} />
              <Route path="/topics/:topicId" element={<Topics />} />
              <Route path="/topic" element={<Topic />} />
              <Route path="/topic/components" element={<Components />} />
          </Routes>
      </BrowserRouter>
    </>
  );
}

function Home() {
  return <h2>Home</h2>;
}

function About() {
  return <h2>About</h2>;
}

function Users() {
  return <h2>Users</h2>;
}

function Topics() {
  let {topicId} = useParams();
  return <h3>topic id: {topicId}</h3>
}

function Topic({}) {
  // Link 안에 Link 걸기 
  // <BrowserRouters> 안에 내부 링크에서 적용할 화면 정의해주기
    return (
      <div>
        <h2>Topic</h2>
        
        <ul>
          <li>
            <Link to="/topic/components"> Components </Link>
          </li>
          <li>
            <Link to="/topic/props-state"> Props State </Link>
          </li>
        </ul>
      </div>
    );
}

function Components () {
  return <div> Components </div>
}
 
export default App;
