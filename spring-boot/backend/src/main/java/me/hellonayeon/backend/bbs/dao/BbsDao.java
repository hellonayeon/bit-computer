package me.hellonayeon.backend.bbs.dao;

import java.util.List;
import me.hellonayeon.backend.bbs.dto.param.CreateBbsParam;
import me.hellonayeon.backend.bbs.dto.param.UpdateBbsParam;
import me.hellonayeon.backend.domain.Bbs;
import me.hellonayeon.backend.bbs.dto.param.BbsCountParam;
import me.hellonayeon.backend.bbs.dto.param.BbsListParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;



@Mapper
@Repository
public interface BbsDao {

	List<Bbs> getBbsSearchPageList(BbsListParam param);
	Integer getBbsCount(BbsCountParam param);

	Bbs getBbs(Integer seq);

	void createBbs(CreateBbsParam param);

	Integer updateBbs(UpdateBbsParam param);
}
