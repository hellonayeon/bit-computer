import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";
import CommentWrite from "./CommentWrite";
import CommentList from "./CommentList";


function BbsDetail() {

	const [bbs, setBbs] = useState({});
	const { seq } = useParams(); // 파라미터 가져오기

	const getBbsDetail = async () => {

		await axios.get(`http://localhost:3000/bbs/${seq}`)
		.then((resp) => {
			console.log("[BbsDetail.js] useEffect() success :D");
			console.log(resp.data);

			setBbs(resp.data.bbs);
		})
		.catch((err) => {
			console.log("[BbsDetail.js] useEffect() error :<");
			console.log(err);
		});

	}

	useEffect(() => {
		getBbsDetail();
	}, []);

	const updateBbs = {
		seq: bbs.seq,
		id: bbs.id,
		title: bbs.title,
		content: bbs.content
	}

	const parentBbs = {
		id: bbs.id,
		title: bbs.title
	}

	return (
		<div>

			{
				/* 자신이 작성한 게시글인 경우에만 수정 삭제 가능 */
				(sessionStorage.getItem("id") == bbs.id) ?
				<div className="my-3 d-flex justify-content-end">

					<Link className="btn btn-primary"  to="/bbsupdate" state={{ bbs: updateBbs }}>수정</Link> &nbsp; &nbsp;
					<Link className="btn btn-danger"  to={{pathname: `/bbsdelete/${seq}`}}>삭제</Link>
				</div>
				:
				null
			}

			<div className="my-3 d-flex justify-content-end">
				<Link className="btn btn-primary" to={{pathname: `/bbsanswer/${bbs.seq}` }} state={{ parentBbs: parentBbs }}>답글 달기</Link>
			</div>

			<table className="table">
				<tbody>
					<tr>
						<th className="table-primary">작성자</th>
						<td>
							<input type="text" className="form-control"  value={bbs.id || ""} size="50px" readOnly />
						</td>
					</tr>

					<tr>
						<th className="table-primary">제목</th>
						<td>
							<input type="text" className="form-control" value={bbs.title || ""} size="50px" readOnly />
						</td>
					</tr>

					<tr>
						<th className="table-primary">작성일</th>
						<td>
							<input type="text" className="form-control"  value={bbs.createdAt || ""} size="50px" readOnly />
						</td>
					</tr>

					<tr>
						<th className="table-primary">조회수</th>
						<td>
							<input type="text" className="form-control"  value={bbs.readCount || "0"} size="50px" readOnly />
						</td>
					</tr>

					<tr>
						<th className="table-primary">내용</th>
						<td>
							<textarea className="form-control" value={bbs.content || ""} rows="10" readOnly ></textarea>
						</td>
					</tr>
				</tbody>
			</table>

			<div className="my-3 d-flex justify-content-center">
				<Link className="btn btn-primary" to="/bbslist">글 목록</Link>
			</div><br/><br/>

			{/* 댓글 작성 컴포넌트 */}
			<CommentWrite seq={seq}/>
			
			{/* 댓글 리스트 컴포넌트 */}
			<CommentList  seq={seq}/>

		</div>
	);
}

export default BbsDetail;