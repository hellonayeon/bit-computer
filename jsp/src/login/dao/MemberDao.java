package login.dao;

import login.db.DBClose;
import login.db.DBConnection;
import login.dto.MemberDto;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

    private static MemberDao dao = new MemberDao();

    private MemberDao() {
        DBConnection.initConnection();
    }

    public static MemberDao getInstance() {
        return dao;
    }

    public boolean addMember(MemberDto dto) {
        String sql = "insert into member(id, pwd, name, email, auth) " +
                "values(?, ?, ?, ?, 3)";

        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getPwd());
            psmt.setString(3, dto.getName());
            psmt.setString(4, dto.getEmail());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0 ;
    }

    public MemberDto findById(String id) throws SQLException {
        String sql = "select * from member  " +
                     "where id=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        MemberDto findMember = null;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);

            rs = psmt.executeQuery();

            if (rs.next()) {
                findMember = new MemberDto(rs.getString(1), rs.getString(2),
                                            rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return findMember;
    }
}
