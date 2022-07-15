package me.hellonayeon.pds.service;

import java.util.List;
import me.hellonayeon.pds.dao.PdsDao;
import me.hellonayeon.pds.dto.PdsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdsServiceImpl implements PdsService {

    @Autowired
    PdsDao dao;


    @Override
    public List<PdsDto> pdslist() {
        return dao.pdslist();
    }

    @Override
    public int uploadPds(PdsDto dto) {
        return dao.uploadPds(dto);
    }

    @Override
    public PdsDto pdsdetail(int seq) {
        return dao.pdsdetail(seq);
    }
}
