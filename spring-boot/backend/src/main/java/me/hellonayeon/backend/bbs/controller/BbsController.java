package me.hellonayeon.backend.bbs.controller;

import java.util.Date;
import me.hellonayeon.backend.bbs.dto.param.UpdateBbsParam;
import me.hellonayeon.backend.bbs.dto.request.BbsListRequest;
import me.hellonayeon.backend.bbs.dto.request.CreateBbsRequest;
import me.hellonayeon.backend.bbs.dto.request.UpdateBbsRequest;
import me.hellonayeon.backend.bbs.dto.response.BbsListResponse;
import me.hellonayeon.backend.bbs.dto.response.BbsResponse;
import me.hellonayeon.backend.bbs.dto.response.CreateBbsResponse;
import me.hellonayeon.backend.bbs.dto.response.UpdateBbsResponse;
import me.hellonayeon.backend.bbs.service.BbsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	/* [GET /bbs/{seq}] 게시글 상세 API */
	@GetMapping("/{seq}")
	public ResponseEntity<BbsResponse> getBbs(@PathVariable  Integer seq) {
		System.out.println("BbsController getBbs() " + new Date());

		return ResponseEntity.ok(service.getBbs(seq));
	}

	/* [POST] /bbs 게시글 작성 */
	@PostMapping
	public ResponseEntity<CreateBbsResponse> createBbs(CreateBbsRequest req) {
		System.out.println("BbsController writeBbs " + new Date());

		return ResponseEntity.ok(service.createBbs(req));
	}

	/* [PATCH] /bbs/{seq} 게시글 수정  */
	// TODO - 수정하는 사람 ID 확인
	@PatchMapping("/{seq}")
	public ResponseEntity<UpdateBbsResponse> updateBbs(@PathVariable Integer seq, @RequestBody UpdateBbsRequest req) {
		System.out.println("BbsController updateBbs " + new Date());

		return ResponseEntity.ok(service.updateBbs(seq, req));
	}

}








