import axios from "axios";
import { useState, useEffect } from "react";
import Pagination from "react-js-pagination";

function CommentList(props) {

	const seq = props.seq;

	// Paging
	const [page, setPage] = useState(1);
	const [totalCnt, setTotalCnt] = useState(0);

	const [commentList, setCommentList] = useState([]);

	const changePage = (page) => {
		setPage(page);
		getCommentList(page);
	}

	const getCommentList = async (page) => {
		await axios.get(`http://localhost:3000/bbs/${seq}/comment`, { params: { "page": page } })
			.then((resp) => {
				console.log("[BbsComment.js] getCommentList() success :D");
				console.log(resp.data);

				setCommentList(resp.data.commentList);
				setTotalCnt(resp.data.pageCnt);

			}).catch((err) => {
				console.log("[BbsComment.js] getCommentList() error :<");
				console.log(err);

			});
	}


	useEffect(() => {
		getCommentList(1);
	}, []);

	return (
		<>

			{
				commentList.map(function (comment, idx) {
					return (
						<CommentDiv obj={comment} key={idx} />
					);
				})
			}

			<Pagination
				activePage={page}
				itemsCountPerPage={5}
				totalItemsCount={totalCnt}
				pageRangeDisplayed={5}
				prevPageText={"‹"}
				nextPageText={"›"}
				onChange={changePage} />

		</>

	);
}

/* 댓글 컴포넌트 */
function CommentDiv(props) {
	const comment = props.obj;

	return (
		<>
			
			{/* 상단 영역 (프로필 이미지, 댓글 작성자, 댓글 작성시간) */}
			<div className="my-1 d-flex justify-content-center">
				<div className="col-1">
					<img src="/images/profile-placeholder.png" alt="프로필 이미지"
						className="profile-img" />
				</div>
				<div className="col-5">
					<div className="row">
						<span>{comment.id}</span>
					</div>
					<div className="row">
						<span>{comment.createdAt}</span>
					</div>
				</div>

				{
					/* 자신이 작성한 댓글인 경우에만 수정 삭제 가능 */
					(sessionStorage.getItem("id") == comment.id) ?
						<div className="col-4 d-flex justify-content-end">
							<button className="btn btn-primary">수정</button> &nbsp;
							<button className="btn btn-danger">삭제</button>
						</div>
						:
						null
				}
			</div>

			{/* 하단 영역 (댓글 내용) */}
			<div className="my-1 d-flex justify-content-center">
				<textarea className="col-10" rows="5" value={comment.content || ""} readOnly></textarea>
			</div>

		</>
	);
}

export default CommentList;