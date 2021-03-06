package dao;


import db.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;



public class ClassroomDAO {
	static public ArrayList<String>  getAllClassroomId() {
		Connection conn = DbUtil.GetConnection();
		String sql = "select cr_id from classroom where status=1";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next()) {
				String tm = rs.getString("cr_id");
				list.add(tm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
