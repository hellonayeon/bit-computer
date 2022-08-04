import { BrowserRouter, Link, Routes, Route } from "react-router-dom";
import BbsList from "./Components/BbsList";
import BbsDetail from "./Components/BbsDetail";
import BbsWrite from "./Components/BbsWrite";
import BbsUpdate from "./Components/BbsUpdate";
import BbsAnswer from "./Components/BbsAnswer";


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

            <div className="collapse navbar-collapse" id="navbar-content">
              <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                  <Link className="nav-link" to="/">🏡 Home</Link>
                </li>
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
