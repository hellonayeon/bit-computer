import { useContext } from "react";
import { AuthContext } from "../context/AuthProvider";
import { Link } from "react-router-dom";

function Nav() {

	const { auth, setAuth } = useContext(AuthContext);

	return (
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

						{							
							(localStorage.getItem("id") || auth) ?
								<>
									{/* 회원 정보 */}
									<li className="nav-item">
										<span className="nav-link"> {auth ? auth : localStorage.getItem("id")} 님 반값습니다 👋🏻 </span>
									</li>

									{/* 로그아웃 */}
									<li className="nav-item">
										<Link className="nav-link" to="/logout">로그아웃</Link>
									</li>

								</>
								:
								<>
									{/* 로그인 */}
									<li className="nav-item">
										<Link className="nav-link" to="/login">로그인</Link>
									</li>

									{/* 회원가입 */}
									<li className="nav-item">
										<Link className="nav-link" to="/join">회원가입</Link>
									</li>
								</>
						}

					</ul>
				</div>
			</div>
		</nav>
	);
}

export default Nav;