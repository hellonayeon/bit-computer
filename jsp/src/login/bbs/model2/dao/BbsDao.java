package login.bbs.model2.dao;

import login.bbs.model2.db.DBClose;
import login.bbs.model2.db.DBConnection;
import login.bbs.model2.dto.BbsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BbsDao {

    private static BbsDao dao = new BbsDao();

    private BbsDao() {

    }

    public static BbsDao getInstance() {
        return dao;
    }

    public List<BbsDto> getBbslist() {
        String sql = "select seq, id, ref, step, depth, "
                + "title, content, wdate, del, readcount "
                + "from bbs "
                + "order by ref desc, step asc";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<BbsDto> list = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                BbsDto dto = new BbsDto(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getInt(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getString(6),
                                        rs.getString(7),
                                        rs.getString(8),
                                        rs.getInt(9),
                                        rs.getInt(10));
                list.add(dto);
            }
            System.out.println("4/4 getBblist success");
        } catch (SQLException e) {
            System.out.println("getBblist fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }

    public boolean writeBbs(BbsDto dto) {
        String sql = "INSERT INTO BBS(ID, REF, STEP, DEPTH, " +
                                        "TITLE, CONTENT, WDATE, " +
                                        "DEL,READCOUNT) " +
                      "VALUES (?, (select ifnull(max(ref), 0)+1 from bbs b), 0, 0, " +
                      "?, ?, NOW(), " +
                      "0, 0)";


        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getTitle());
            psmt.setString(3, dto.getContent());

            count = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0;
    }

    public List<BbsDto> getBbsSearchlist(String choice, String search) {
        String sql = "select seq, id, ref, step, depth, "
                + "title, content, wdate, del, readcount "
                + "from bbs ";

        String sWord = "";
        if (choice.equals("title")) {
            sWord = " where title like '%" + search + "%'";
        }
        else if (choice.equals("content")) {
            sWord = " where content like '%" + search + "%'";
        }
        else if (choice.equals("writer")) {
            sWord = " where id='" + search + "'";
        }
        sql += sWord;

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<BbsDto> list = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                BbsDto dto = new BbsDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));
                list.add(dto);
            }
            System.out.println("4/4 getBblist success");
        } catch (SQLException e) {
            System.out.println("getBblist fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }

    /* 글의 총 개수 */
    public int getAllBbs(String choice, String search) {

        String sql = "select count(*) from bbs ";

        String sWord = "";
        if (choice.equals("title")) {
            sWord = " where title like '%" + search + "%'";
        }
        else if (choice.equals("content")) {
            sWord = " where content like '%" + search + "%'";
        }
        else if (choice.equals("writer")) {
            sWord = " where id='" + search + "'";
        }
        sql += sWord;

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        int len = 0;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);

            rs = psmt.executeQuery();
            if (rs.next()) {
                len = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return len;
    }

    public List<BbsDto> getBbsPagelist(String choice, String search, int pageNumber) {
        String sql = "select seq, id, ref, step, depth, "
                + "title, content, wdate, del, readcount "
                + "from ";

        sql += " ( select row_number() over (order by ref desc, step asc) as rnum," +
                "              seq, id, ref, step, depth, title, content, wdate, del, readcount" +
                "              from bbs ";

        String sWord = "";
        if (choice.equals("title")) {
            sWord = " where title like '%" + search + "%'";
        }
        else if (choice.equals("content")) {
            sWord = " where content like '%" + search + "%'";
        }
        else if (choice.equals("writer")) {
            sWord = " where id='" + search + "'";
        }
        sql += sWord;

        sql += " order by ref desc, step asc) a";
        sql += " where rnum between ? and ? ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        int start, end;
        start = 1 + 10*pageNumber;
        end = 10 + 10*pageNumber;

        List<BbsDto> list = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();
            System.out.println("1/4 getBbslist success");

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, start);
            psmt.setInt(2, end);
            System.out.println("2/4 getBbslist success");

            rs = psmt.executeQuery();
            System.out.println("3/4 getBbslist success");

            while (rs.next()) {
                BbsDto dto = new BbsDto(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10));
                list.add(dto);
            }
            System.out.println("4/4 getBblist success");
        } catch (SQLException e) {
            System.out.println("getBblist fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }
}
