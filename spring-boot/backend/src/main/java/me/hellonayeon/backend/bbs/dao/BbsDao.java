package me.hellonayeon.backend.bbs.dao;

import java.util.List;
import me.hellonayeon.backend.bbs.domain.Bbs;
import me.hellonayeon.backend.bbs.domain.Comment;
import me.hellonayeon.backend.bbs.dto.param.BbsCountParam;
import me.hellonayeon.backend.bbs.dto.param.BbsListParam;
import me.hellonayeon.backend.bbs.dto.param.CommentListParam;
import me.hellonayeon.backend.bbs.dto.param.CreateBbsAnswerParam;
import me.hellonayeon.backend.bbs.dto.param.CreateBbsParam;
import me.hellonayeon.backend.bbs.dto.param.CreateCommentParam;
import me.hellonayeon.backend.bbs.dto.param.UpdateBbsParam;
import me.hellonayeon.backend.bbs.dto.param.CreateReadCountParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface BbsDao {

	List<Bbs> getBbsSearchPageList(BbsListParam param);
	Integer getBbsCount(BbsCountParam param);

	Bbs getBbs(Integer seq);
	Integer createBbsReadCount(CreateReadCountParam param);
	Integer increaseBbsReadCount(Integer seq);

	void createBbs(CreateBbsParam param);

	Integer updateBbsStep(Integer parentSeq);
	Integer getBbsAnswerCount(Integer parentSeq);
	void createBbsAnswer(CreateBbsAnswerParam param);

	Integer updateBbs(UpdateBbsParam param);

	Integer deleteBbs(Integer seq);

	List<Comment> getCommentPageList(CommentListParam param);
	Integer getCommentCount(Integer seq);

	void createComment(CreateCommentParam param);
}
