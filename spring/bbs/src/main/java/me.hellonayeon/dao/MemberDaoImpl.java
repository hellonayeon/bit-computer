package me.hellonayeon.dao;


import me.hellonayeon.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    SqlSession session;

    String namespace = "Member.";

    @Override
    public int getId(String id) {
        return  session.selectOne(namespace + "getId", id);
    }

    @Override
    public int addMember(MemberDto dto) {
        return session.insert(namespace + "addMember", dto);
    }


}
