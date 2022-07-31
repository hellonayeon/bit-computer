import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";


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

	return (
		<div>
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
		</div>
	);
}

export default BbsDetail;