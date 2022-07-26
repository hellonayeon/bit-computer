package me.hellonayeon.backend.bbs.dao;

import java.util.List;
import me.hellonayeon.backend.bbs.dto.BbsDto;
import me.hellonayeon.backend.bbs.dto.BbsParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface BbsDao {

	List<BbsDto> getBbsList();
	List<BbsDto> getBbsSearchList(BbsParam param);
	
	int writeBbs(BbsDto bto);
	
	List<BbsDto> getBbsSearchPageList(BbsParam param);
	int getBbsCount(BbsParam param);
}
