package BaseballTeam.util.file;

import BaseballTeam.domain.Batter;
import BaseballTeam.domain.Human;
import BaseballTeam.domain.Pitcher;

import java.io.*;
import java.util.List;

public class FileProcessor {
    private static File file = new File("./baseball-team.txt");

    public void createFile(String fname) {

    }

    /**
     * @param player 파일에서 읽어온 선수 리스트
     * @return 마지막 선수 번호
     * @throws IOException
     */
    public static int loadFile(List<Human> player) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while ((str = br.readLine()) != null) {
            String[] split = str.split(",");
            String position = split[split.length-1];
            if (position.equals("투수")) {
                player.add(new Pitcher(split));
            }
            else if (position.equals("타자")) {
                player.add(new Batter(split));
            }
        }

        return (player.size() == 0) ? 0 : player.get(player.size() - 1).getNo() + 1;
    }

    public static void saveFile(List<Human> player) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        String strData = "";
        for (Human h : player) {
            if (h instanceof Pitcher) {
                Pitcher pitcher = (Pitcher) h;
                strData += pitcher.toStringData() + ",투수";
            }
            else if (h instanceof Batter) {
                Batter batter = (Batter) h;
                strData += batter.toStringData() + ",타자";
            }

            pw.println(strData);
        }

        pw.close();
    }
}
