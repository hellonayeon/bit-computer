package BaseballTeam.controller;

import BaseballTeam.dao.BaseballDao;
import BaseballTeam.util.io.Printer;
import BaseballTeam.util.io.Reader;

import java.io.IOException;

public class BaseballController {

    BaseballDao baseballDao = new BaseballDao();

    public void run() throws IOException {
        baseballDao.load();
        while (true) {
            Printer.printMenu();
            int sel = Reader.readMenu();

            if (sel == 0) {
                break;
            }

            switch (sel) {
                case 1:
                    String position = Reader.readPosition();
                    baseballDao.insert(position);
                    break;
                case 2:
                    int dno = Reader.readDeleteNo();
                    baseballDao.delete(dno);
                    break;
                case 3:
                    int filter = Reader.readSearchFilter();

                    if (filter == 0) {
                        int no = Reader.readSearchNo();
                        baseballDao.search(filter, no);
                    }
                    else if (filter == 1) {
                        String name = Reader.readSearchName();
                        baseballDao.search(filter, name);
                    }

                    break;
                case 4:
                    int uno = Reader.readUpdateNo();
                    baseballDao.update(uno);
                    break;
                case 5:
                    baseballDao.printAll();
                    break;
            }
        }
        baseballDao.save();
    }
}
