package bbs.model1.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BbsDaoTest {

    @Test
    void test() {
        BbsDao dao = BbsDao.getInstance();
        assertEquals(22, dao.getAllBbs("" , ""));
    }

}