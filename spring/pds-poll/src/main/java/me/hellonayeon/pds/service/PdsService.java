package me.hellonayeon.pds.service;

import java.util.List;
import me.hellonayeon.pds.dto.PdsDto;

public interface PdsService {

    List<PdsDto> pdslist();

    int uploadPds(PdsDto dto);

    PdsDto pdsdetail(int seq);
}
