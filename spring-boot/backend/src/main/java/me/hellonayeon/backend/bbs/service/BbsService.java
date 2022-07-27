package me.hellonayeon.backend.bbs.service;

import java.util.List;

import me.hellonayeon.backend.bbs.dao.BbsDao;
import me.hellonayeon.backend.bbs.dto.BbsDto;
import me.hellonayeon.backend.bbs.dto.BbsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbsService {

	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getBbsList() {
		return dao.getBbsList();
	}
	
	public boolean writeBbs(BbsDto dto) {
		int n = dao.writeBbs(dto);
		return n>0;
	}
	
	public List<BbsDto> getBbsSearchList(BbsParam param) {
		return dao.getBbsSearchList(param);
	}
	
	public List<BbsDto> getBbsSearchPageList(BbsParam param) {
		return dao.getBbsSearchPageList(param);
	}
	
	public int getBbsCount(BbsParam param) {
		return dao.getBbsCount(param);
	}

	public BbsDto getBbs(Integer seq) { return dao.getBbs(seq); }
}






