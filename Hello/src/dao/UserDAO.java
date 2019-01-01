package dao;
import bean.User;
import db.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import bean.Booking;



public class UserDAO {
	static public String getPasswd(String userid) {
		Connection conn = DbUtil.GetConnection();
		String pw = null;
		String sql = "select user_pw from userinfo where user_id =?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				pw = rs.getString("user_pw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pw;
	}
	
	static public boolean AddUser(String id,String pw, String tel,int st) {
		Connection conn = DbUtil.GetConnection();
		String sql = "INSERT INTO userinfo(user_id,user_pw,user_tel,"
				+ "user_status) VALUES(?,?,?,?)";
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, tel);
			psmt.setInt(4, st);
			psmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	static public ArrayList<Booking> GetUserBooking(String uid) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		Connection conn = DbUtil.GetConnection();
		String sql = "SELECT cr_id, week_no,day_no,time_no FROM waitingqueue WHERE user_id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Booking tmp = new Booking(uid,rs.getString("cr_id"),
						rs.getInt("week_no"),rs.getInt("day_no"),
						rs.getInt("time_no"), "" );
				list.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	static public boolean SubmitUserBooking(Booking t) {
		Connection conn = DbUtil.GetConnection();
		String sql = "INSERT INTO waitingqueue(user_id,cr_id,week_no,"
				+ "day_no,time_no,reason) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, t.GetUserId());
			psmt.setString(2,t.GetCrId());
			psmt.setInt(3, t.GetWeekNo());
			psmt.setInt(4, t.GetDayNo());
			psmt.setInt(5, t.GetTimeNo());
			psmt.setString(6, t.GetReason());
			psmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
