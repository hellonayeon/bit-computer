package me.hellonayeon.pds.service;

import java.util.List;
import me.hellonayeon.pds.dao.BbsDao;
import me.hellonayeon.pds.dto.BbsDto;
import me.hellonayeon.pds.dto.BbsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {
		return dao.bbslist(bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {		
		return dao.getBbsCount(bbs);
	}
	
	@Override
	public boolean writeBbs(BbsDto dto) {		
		return dao.writeBbs(dto);
	}
	
	@Override
	public BbsDto getBbs(int seq) {		
		return dao.getBbs(seq);
	}
}
