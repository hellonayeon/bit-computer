package me.hellonayeon.backend.bbs.service;

import java.util.List;

import me.hellonayeon.backend.bbs.dao.BbsDao;
import me.hellonayeon.backend.bbs.dto.param.CreateBbsParam;
import me.hellonayeon.backend.bbs.dto.param.UpdateBbsParam;
import me.hellonayeon.backend.bbs.dto.request.CreateBbsRequest;
import me.hellonayeon.backend.bbs.dto.request.UpdateBbsRequest;
import me.hellonayeon.backend.bbs.dto.response.CreateBbsResponse;
import me.hellonayeon.backend.bbs.dto.response.UpdateBbsResponse;
import me.hellonayeon.backend.domain.Bbs;
import me.hellonayeon.backend.bbs.dto.param.BbsCountParam;
import me.hellonayeon.backend.bbs.dto.param.BbsListParam;
import me.hellonayeon.backend.bbs.dto.request.BbsListRequest;
import me.hellonayeon.backend.bbs.dto.response.BbsListResponse;
import me.hellonayeon.backend.bbs.dto.response.BbsResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbsService {

	private final BbsDao dao;

	public BbsService(BbsDao dao) {
		this.dao = dao;
	}

	public BbsListResponse getBbsList(BbsListRequest req) {

		BbsListParam bbsListParam = new BbsListParam(req);
		setBbsPageParam(bbsListParam);
		List<Bbs> bbsList = getBbsSearchPageList(bbsListParam);

		int pageCnt = getBbsCount(new BbsCountParam(req));

		return new BbsListResponse(bbsList, pageCnt);
	}

	/* 페이지 설정 */
	private void setBbsPageParam(BbsListParam param) {
		int page = param.getPage() - 1;
		int start = page * 10 + 1;
		int end = (page + 1) * 10;

		param.setPageStart(start);
		param.setPageEnd(end);
	}

	/* 글 목록 */
	private List<Bbs> getBbsSearchPageList(BbsListParam param) {
		return dao.getBbsSearchPageList(param);
	}

	/* 글의 총 개수 */
	private Integer getBbsCount(BbsCountParam param) {
		return dao.getBbsCount(param);
	}

	/* 특정 글 */
	public BbsResponse getBbs(Integer seq) { return new BbsResponse(dao.getBbs(seq)); }

	/* 글 추가 */
	public CreateBbsResponse createBbs(CreateBbsRequest req) {
		CreateBbsParam param = new CreateBbsParam(req);
		dao.createBbs(param);
		return new CreateBbsResponse(param.getSeq());
	}

	/* 글 수정 */
	public UpdateBbsResponse updateBbs(Integer seq, UpdateBbsRequest req) {
		Integer updatedRecordCount = dao.updateBbs(new UpdateBbsParam(seq, req));
		return new UpdateBbsResponse(updatedRecordCount);
	}
}






