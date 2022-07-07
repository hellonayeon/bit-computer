package bbs.model1.dao;

import bbs.model1.db.DBClose;
import bbs.model1.db.DBConnection;
import bbs.model1.dto.PdsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PdsDao {

    private static PdsDao dao = new PdsDao();

    private PdsDao() { }

    public static PdsDao getInstance() {
        return dao;
    }

    public List<PdsDto> getPdsList() {

        String sql = " select seq, id, title, content, " +
                    " filename, newfilename, " +
                    " readcount, downcount, regdate " +
                    " from pds " +
                    " order by regdate asc ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<PdsDto> list = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);

            rs = psmt.executeQuery();
            while (rs.next()) {
                int i = 1;
                PdsDto dto = new PdsDto(rs.getInt(i++),
                                        rs.getString(i++),
                                        rs.getString(i++),
                                        rs.getString(i++),
                                        rs.getString(i++),
                                        rs.getString(i++),
                                        rs.getInt(i++),
                                        rs.getInt(i++),
                                        rs.getString(i++));

                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }

    public boolean writePds(PdsDto pds) {

        String sql = " insert into pds (id, title, content, filename, newfilename, " +
                " readcount, downcount, regdate)" +
                " values(?, ?, ?, ?, ?, 0, 0, now()); ";

        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {

            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);

            psmt.setString(1, pds.getId());
            psmt.setString(2, pds.getTitle());
            psmt.setString(3, pds.getContent());
            psmt.setString(4, pds.getFilename());
            psmt.setString(5, pds.getNewFilename());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0;
    }

    public PdsDto getPds(int seq) {

        String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
                + " FILENAME, NEWFILENAME, READCOUNT, DOWNCOUNT, REGDATE "
                + " FROM PDS "
                + " WHERE SEQ=? ";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        PdsDto pds = null;

        try {
            conn = DBConnection.getConnection();
            System.out.println("1/6 getPds Success");

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);
            System.out.println("2/6 getPds Success");

            rs = psmt.executeQuery();
            System.out.println("3/6 getPds Success");

            if(rs.next()) {
                int i = 1;
                pds = new PdsDto(rs.getInt(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getString(i++),
                        rs.getInt(i++),
                        rs.getInt(i++),
                        rs.getString(i++));
            }
            System.out.println("4/6 getPds Success");

        } catch (Exception e) {
            System.out.println("getPds Fail");
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return pds;
    }

    public void upReadCount(int seq) {
        String sql = " UPDATE PDS "
                + " SET READCOUNT=READCOUNT+1 "
                + " WHERE SEQ=? ";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);

            psmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }
    }

    public void upDownCount(int seq) {
        String sql = " UPDATE PDS "
                + " SET DOWNCOUNT=DOWNCOUNT+1 "
                + " WHERE SEQ=? ";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);

            psmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }
    }
}
