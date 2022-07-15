package me.hellonayeon.pds.dao;

import java.util.List;
import me.hellonayeon.pds.dto.PdsDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PdsDaoImpl implements PdsDao {

    @Autowired
    SqlSession session;

    String namespace = "Pds.";

    @Override
    public List<PdsDto> pdslist() {
        return session.selectList(namespace + "pdslist");
    }

    @Override
    public int uploadPds(PdsDto dto) {
        return session.insert(namespace + "uploadpds", dto);
    }

    @Override
    public PdsDto pdsdetail(int seq) {
        return session.selectOne(namespace + "pdsdetail", seq);
    }
}
