package me.hellonayeon.backend.comment.controller;

import java.util.Date;
import me.hellonayeon.backend.bbs.dto.request.CreateCommentRequest;
import me.hellonayeon.backend.bbs.dto.response.CreateCommentResponse;
import me.hellonayeon.backend.comment.dto.request.CommentRequest;
import me.hellonayeon.backend.comment.dto.response.CommentResponse;
import me.hellonayeon.backend.comment.dto.response.DeleteCommentResponse;
import me.hellonayeon.backend.comment.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbs")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
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
