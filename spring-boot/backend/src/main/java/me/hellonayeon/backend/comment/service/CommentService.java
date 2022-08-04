package me.hellonayeon.backend.comment.service;

import java.util.List;
import me.hellonayeon.backend.bbs.dto.request.CreateCommentRequest;
import me.hellonayeon.backend.bbs.dto.response.CreateCommentResponse;
import me.hellonayeon.backend.comment.dao.CommentDao;
import me.hellonayeon.backend.comment.domain.Comment;
import me.hellonayeon.backend.comment.dto.param.CommentListParam;
import me.hellonayeon.backend.comment.dto.param.CreateCommentParam;
import me.hellonayeon.backend.comment.dto.request.CommentRequest;
import me.hellonayeon.backend.comment.dto.response.CommentResponse;
import me.hellonayeon.backend.comment.dto.response.DeleteCommentResponse;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentDao dao;

    public CommentService(CommentDao dao) {
        this.dao = dao;
    }

    /* 댓글 조회 */
    public CommentResponse getBbsCommentList(Integer seq, CommentRequest req) {
        CommentListParam param = new CommentListParam(seq);
        param.setPageParam(req.getPage(), 5);

        List<Comment> commentList = dao.getCommentPageList(param);
        Integer pageCnt = dao.getCommentCount(seq);

        return new CommentResponse(commentList, pageCnt);
    }

    /* 댓글 작성 */
    public CreateCommentResponse createComment(Integer seq, CreateCommentRequest req) {
        CreateCommentParam param = new CreateCommentParam(seq, req);
        dao.createComment(param);
        return new CreateCommentResponse(param.getSeq());
    }

    /* 댓글 삭제 */
    public DeleteCommentResponse deleteComment(Integer seq) {
        Integer deletedRecordCount = dao.deleteComment(seq);
        return new DeleteCommentResponse(deletedRecordCount);
    }
}
