package me.hellonayeon.backend.hellosample.dao;

import java.util.List;
import me.hellonayeon.backend.hellosample.dto.response.MemberResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
//@Repository
public interface MemberDao {

    public List<MemberResponse> selectAllMember();

}
