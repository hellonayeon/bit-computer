/* 회원가입 컴포넌트 */

import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";

function Join() {

	const [id, setId] = useState("");
	const [name, setName] = useState("");
	const [pwd, setPwd] = useState("");
	const [checkPwd, setCheckPwd] = useState("");
	const [email, setEmail] = useState("");

	const navigate = useNavigate();

	const changeId = (event) => {
		setId(event.target.value);
	}

	const changeName = (event) => {
		setName(event.target.value);
	}

	const changePwd = (event) => {
		setPwd(event.target.value);
	}

	const changeCheckPwd = (event) => {
		setCheckPwd(event.target.value);
	}

	const changeEmail = (event) => {
		setEmail(event.target.value);
	}

	/* 아이디 중복 체크 */
	const checkIdDuplicate = async () => {

		await axios.get("http://localhost:3000/user", { params: { id: id } })
			.then((resp) => {
				console.log("[Join.js] checkIdDuplicate() success :D");
				console.log(resp.data);

				if (resp.status == 200) {
					alert("사용 가능한 아이디입니다.");
				}
				
			})
			.catch((err) => {
				console.log("[Join.js] checkIdDuplicate() error :<");
				console.log(err);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
			});

	}

	/* 회원가입 */
	const join = async () => {

		const req = {
			id: id,
			name, name,
			pwd: pwd,
			checkPwd: checkPwd,
			email: email
		}

		await axios.post("http://localhost:3000/user/join", req)
			.then((resp) => {
				console.log("[Join.js] join() success :D");
				console.log(resp.data);

				alert(resp.data.id + "님 회원가입을 축하드립니다 🎊");
				navigate("/login");

			}).catch((err) => {
				console.log("[Join.js] join() error :<");
				console.log(err);

				// alert(err.response.data);

				const resp = err.response;
				if (resp.status == 400) {
					alert(resp.data);
				}
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
						<td>
							<button className="btn btn-primary" onClick={checkIdDuplicate}>아이디 중복 확인</button>
						</td>
					</tr>

					<tr>
						<th className="table-primary">이름</th>
						<td>
							<input type="text" value={name} onChange={changeName} size="50px" />
						</td>
					</tr>

					<tr>
						<th className="table-primary">비밀번호</th>
						<td>
							<input type="password" value={pwd} onChange={changePwd} size="50px" />
						</td>
					</tr>

					<tr>
						<th className="table-primary">비밀번호 확인</th>
						<td>
							<input type="password" value={checkPwd} onChange={changeCheckPwd} size="50px" />
						</td>
					</tr>

					<tr>
						<th className="table-primary">이메일</th>
						<td>
							<input type="text" value={email} onChange={changeEmail} size="50px" />
						</td>
					</tr>
				</tbody>
			</table><br />

			<div className="my-3 d-flex justify-content-center">
				<button className="btn btn-primary" onClick={join}>회원가입</button>
			</div>

		</div>
	);
}

export default Join;