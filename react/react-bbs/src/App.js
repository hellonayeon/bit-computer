import { BrowserRouter, Link, Routes, Route } from "react-router-dom";
import BbsList from "./Components/bbs/BbsList";
import BbsDetail from "./Components/bbs/BbsDetail";
import BbsWrite from "./Components/bbs/BbsWrite";
import BbsUpdate from "./Components/bbs/BbsUpdate";
import BbsAnswer from "./Components/comment/BbsAnswer";
import Login from "./Components/user/Login";
import Join from "./Components/user/Join";


function App() {
	sessionStorage.setItem("id", "nayeon");

  return (
    <div>

      <header className="py-4">
        <div className="container text-center">
          <img alt="" src="/images/open-holy.jpeg" width="960" height="150" />
        </div>
      </header>

      <BrowserRouter>
        <nav className="navbar navbar-expand-md navbar-dark bg-info sticky-top">
          <div className="container">

            <div className="navbar-collapse collapse justify-content-between" id="navbar-content">
              <ul className="navbar-nav mr-auto">

                {/* 메인 화면 */}
                <li className="nav-item">
                  <Link className="nav-link" to="/">🏡 Home</Link>
                </li>

                {/* 게시판 */}
                <li className="nav-item dropdown">

                    <div className="nav-link dropdown-toggle" id="navbarDropdown" 
                       role="button" data-toggle="dropdown" aria-haspopup="true" 
                       aria-expanded="false">게시판</div>

                    <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                      <Link className="dropdown-item" to="/bbslist">글목록</Link>
                      <Link className="dropdown-item" to="/bbswrite">글추가</Link>
                    </div>   
                  </li>
              </ul>
              <ul className="navbar-nav ml-auto">
                {/* 로그인 */}
                <li className="nav-item">
                  <Link className="nav-link" to="/login">로그인</Link>
                </li>

                {/* 회원가입 */}
                <li className="nav-item">
                  <Link className="nav-link" to="/join">회원가입</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>

        <main>
          <div className="py-4">
            <div className="container">
              <Routes>
                <Route path="/" element={<Home />}></Route>

                <Route path="/bbslist" element={<BbsList />}></Route>
                <Route path="/bbswrite" element={<BbsWrite />}></Route>
                <Route path="/bbsdetail/:seq" element={<BbsDetail />}></Route>
                <Route path="/bbsupdate" element={<BbsUpdate />}></Route>
                <Route path="/bbsanswer/:parentSeq" element={<BbsAnswer />}></Route>

                <Route path="/login" element={<Login />}></Route>
                <Route path="/join" element={<Join />}></Route>
              </Routes>
            </div>
          </div>
        </main>
      </BrowserRouter>

      <footer className="py-4 bg-info text-light">
        <div className="container text-center">
          <ul className="nav justify-content-center mb-3">
            <li className="nav-item">
              <a className="nav-link" href="/">Top</a>
            </li>
          </ul>

          <p>
            <small>Copyright &copy;Graphic Arts</small>
          </p>
        </div>
      </footer>

    </div>
  );
}

function Home() {
  return (
    <div>
      <h2>Home</h2>
    </div>
  );
}

export default App;
