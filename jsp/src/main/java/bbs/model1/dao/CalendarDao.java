package bbs.model1.dao;

import bbs.model1.db.DBClose;
import bbs.model1.db.DBConnection;
import bbs.model1.dto.CalendarDto;
import bbs.model1.util.CalUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalendarDao {

    private static CalendarDao dao = new CalendarDao();

    private CalendarDao() { }

    public static CalendarDao getInstance() {
        return dao;
    }

    public List<CalendarDto> getCalendarList(String id, String yyyyMM) {

        String sql = "select seq, id, title, content, rdate, wdate " +
                     "from (select row_number() over (partition by substr(rdate, 1, 8) order by rdate asc) as rnum, " +
                "            seq, id, title, content, rdate, wdate " +
                "            from calendar " +
                "            where id=? and substr(rdate, 1, 6) = ?) a " +
                "     where rnum between 1 and 5";


        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<CalendarDto> list = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, yyyyMM);

            rs = psmt.executeQuery();

            while (rs.next()) {
                int i = 1;
                CalendarDto dto = new CalendarDto(  rs.getInt(i++),
                                                    rs.getString(i++),
                                                    rs.getString(i++),
                                                    rs.getString(i++),
                                                    rs.getString(i++),
                                                    rs.getString(i++)   );
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }

    public boolean addCalendar(CalendarDto cal) {

        String sql = " insert into calendar (id, title, content, rdate, wdate) " +
                     " values (?, ?, ?, ?, now()) ";

        Connection conn = null;
        PreparedStatement psmt = null;

        int count = 0;

        try {

            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, cal.getId());
            psmt.setString(2, cal.getTitle());
            psmt.setString(3, cal.getContent());
            psmt.setString(4, cal.getRdate()); // 202207061230

            count = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0;

    }

    public CalendarDto getCalendar(int seq) {

        String sql = " select id, title, content, rdate, wdate " +
                     " from calendar " +
                     " where seq=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        CalendarDto dto = null;

        try {

            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, seq);

            rs = psmt.executeQuery();
            if (rs.next()) {
                dto = new CalendarDto(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return dto;
    }

    public List<CalendarDto> getDayCalendarList(String id, String year, String month, String day) {

        String sql = " select seq, title, rdate " +
                    " from calendar " +
                    " where id=? and rdate like ?";
        String rdate = year + CalUtil.two(month) + CalUtil.two(day) + "%";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<CalendarDto> list = new ArrayList<>();

        try {

            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, rdate);

            rs = psmt.executeQuery();
            while (rs.next()) {
                CalendarDto dto = new CalendarDto(rs.getInt(1),
                                                    rs.getString(2),
                                                    rs.getString(3));

                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, rs);
        }

        return list;
    }
}
