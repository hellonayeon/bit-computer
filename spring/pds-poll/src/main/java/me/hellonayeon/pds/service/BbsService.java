package me.hellonayeon.pds.service;


import java.util.List;
import me.hellonayeon.pds.dto.BbsDto;
import me.hellonayeon.pds.dto.BbsParam;

public interface BbsService {

	List<BbsDto> bbslist(BbsParam bbs);
	int getBbsCount(BbsParam bbs);
	
	boolean writeBbs(BbsDto dto);
	
	BbsDto getBbs(int seq);
}
