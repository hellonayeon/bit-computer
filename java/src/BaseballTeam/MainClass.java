package BaseballTeam;

import BaseballTeam.dao.BaseballPlayerManager;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        (new BaseballPlayerManager()).run();
    }
}
