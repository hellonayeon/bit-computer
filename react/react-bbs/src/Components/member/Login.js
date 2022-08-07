/* 로그인 컴포넌트 */

import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";

function Login() {

	const navigate = useNavigate();

	const [id, setId] = useState("");
	const [pwd, setPwd] = useState("");

	const changeId = (event) => {
		setId(event.target.value);
	}

	const changePwd = (event) => {
		setPwd(event.target.value);
	}

	const login = async () => {

		const req = {
			id: id,
			pwd: pwd
		}

		await axios.post("http://localhost:3000/user/login", req)
		.then((resp) => {
			console.log("[Login.js] login() success :D");
			console.log(resp.data);

				alert(resp.data.id + "님, 성공적으로 로그인 되었습니다 🔐");

				// JWT 토큰 저장
				localStorage.setItem("bbs_access_token", resp.data.jwt);
				localStorage.setItem("id", resp.data.id);

				navigate("/bbslist");
			

		}).catch((err) => {
			console.log("[Login.js] login() error :<");
			console.log(err);

			alert("⚠️ " + err.response.data);
		});
	}

	return (
		<div>
			<table className="table">
				<tbody>
					<tr>
						<th className="table-primary">아이디</th>
						<td>
							<input type="text" value={id} onChange={changeId} size="50px" />
						</td>
					</tr>

					<tr>
						<th className="table-primary">비밀번호</th>
						<td>
							<input type="password" value={pwd} onChange={changePwd} size="50px" />
						</td>
					</tr>
				</tbody>
			</table><br />

			<div className="my-3 d-flex justify-content-center">
				<button className="btn btn-primary" onClick={login}>로그인</button>
			</div>

		</div>
	);
}

export default Login;