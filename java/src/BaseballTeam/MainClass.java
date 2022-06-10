package BaseballTeam;

import BaseballTeam.controller.BaseballController;
import BaseballTeam.dao.BaseballDao;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        (new BaseballController()).run();
    }
}
