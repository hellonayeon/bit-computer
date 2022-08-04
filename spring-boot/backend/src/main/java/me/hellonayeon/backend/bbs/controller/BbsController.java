package me.hellonayeon.backend.bbs.controller;

import java.util.Date;
import me.hellonayeon.backend.bbs.dto.param.DeleteCommentResponse;
import me.hellonayeon.backend.bbs.dto.request.CommentRequest;
import me.hellonayeon.backend.bbs.dto.request.BbsListRequest;
import me.hellonayeon.backend.bbs.dto.request.CreateBbsRequest;
import me.hellonayeon.backend.bbs.dto.request.CreateCommentRequest;
import me.hellonayeon.backend.bbs.dto.request.UpdateBbsRequest;
import me.hellonayeon.backend.bbs.dto.response.CommentResponse;
import me.hellonayeon.backend.bbs.dto.response.BbsListResponse;
import me.hellonayeon.backend.bbs.dto.response.BbsResponse;
import me.hellonayeon.backend.bbs.dto.response.CreateBbsResponse;
import me.hellonayeon.backend.bbs.dto.response.CreateCommentResponse;
import me.hellonayeon.backend.bbs.dto.response.DeleteBbsResponse;
import me.hellonayeon.backend.bbs.dto.response.UpdateBbsResponse;
import me.hellonayeon.backend.bbs.service.BbsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bbs")
public class BbsController {

	private final BbsService service;

	public BbsController(BbsService service) {
		this.service = service;
	}

	/* [GET /bbs] 게시글 목록 API */
	@GetMapping
	public ResponseEntity<BbsListResponse> getBbsList(@ModelAttribute BbsListRequest req){
		System.out.println("BbsController getBbsList() " + new Date());

		return ResponseEntity.ok(service.getBbsList(req));
	}

	/* [GET /bbs/{seq}?readerId={id}] 게시글 상세 API */
	@GetMapping("/{seq}")
	public ResponseEntity<BbsResponse> getBbs(@PathVariable  Integer seq, @RequestParam String readerId) {
		System.out.println("BbsController getBbs() " + new Date());

		return ResponseEntity.ok(service.getBbs(seq, readerId));
	}

	/* [POST] /bbs 게시글 작성 */
	@PostMapping
	public ResponseEntity<CreateBbsResponse> createBbs(CreateBbsRequest req) {
		System.out.println("BbsController createBbs " + new Date());

		return ResponseEntity.ok(service.createBbs(req));
	}

	/* [POST] /bbs/{parentSeq}/answer 게시글 답글 작성  */
	@PostMapping("/{parentSeq}/answer")
	public ResponseEntity<CreateBbsResponse> createBbsAnswer(@PathVariable Integer parentSeq, @RequestBody CreateBbsRequest req) {
		System.out.println("BbsController createBbsAnswer " + new Date());

		return ResponseEntity.ok(service.createBbsAnswer(parentSeq, req));
	}

	/* [PATCH] /bbs/{seq} 게시글 수정  */
	// TODO - 수정하는 사람 ID 확인
	@PatchMapping("/{seq}")
	public ResponseEntity<UpdateBbsResponse> updateBbs(@PathVariable Integer seq, @RequestBody UpdateBbsRequest req) {
		System.out.println("BbsController updateBbs " + new Date());

		return ResponseEntity.ok(service.updateBbs(seq, req));
	}

	@DeleteMapping("/{seq}")
	public ResponseEntity<DeleteBbsResponse> deleteBbs(@PathVariable Integer seq) {
		System.out.println("BbsController deleteBbs " + new Date());

		return ResponseEntity.ok(service.deleteBbs(seq));
	}


	/* [GET] /bbs/{seq}/comment 댓글 조회 */
	@GetMapping("/{seq}/comment")
	public ResponseEntity<CommentResponse> getBbsCommentList(@PathVariable Integer seq,
																@ModelAttribute CommentRequest req) {
		System.out.println("BbsController getBbsCommentList " + new Date());

		return ResponseEntity.ok(service.getBbsCommentList(seq, req));
	}

	/* [POST] /bbs/{seq}/comment 댓글 작성 */
	@PostMapping("/{seq}/comment")
	public ResponseEntity<CreateCommentResponse> createComment(@PathVariable Integer seq,
																@RequestBody CreateCommentRequest req) {
		System.out.println("BbsController createComment " + new Date());

		return ResponseEntity.ok(service.createComment(seq, req));
	}

	/* [DELETE] /bbs/comment/{seq} 댓글 삭제 */
	@DeleteMapping("/comment/{seq}")
	public ResponseEntity<DeleteCommentResponse> deleteComment(@PathVariable Integer seq) {
		System.out.println("BbsController deleteComment " + new Date());

		return ResponseEntity.ok(service.deleteComment(seq));
	}
}








