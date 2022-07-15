package me.hellonayeon.pds.dao;

import java.util.List;
import me.hellonayeon.pds.dto.PdsDto;

public interface PdsDao {

    List<PdsDto> pdslist();

    int uploadPds(PdsDto dto);

    PdsDto pdsdetail(int seq);
}
