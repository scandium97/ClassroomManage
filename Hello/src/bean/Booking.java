package bean;

public class Booking {
	private String user_id;
	private String cr_id;
	private int weekNo;
	private int dayNo;
	private int timeNo;
	private String reason;
	public Booking(){}
	public Booking(String u, String cr, int w , int d ,int t, String c){
		user_id=u;
		cr_id = cr;
		weekNo = w;
		dayNo = d;
		timeNo = t;
		reason = c;
	}
	public String GetUserId() {
		return user_id;
	}
	public String GetCrId() {
		return cr_id;
	}
	public int GetWeekNo() {
		return weekNo;
	}
	public int GetDayNo() {
		return dayNo;
	}
	public int GetTimeNo() {
		return timeNo;
	}
	public String GetReason() {
		return reason;
	}
	public String toJSONString() {
		String js = "{\"userid\":\"" + user_id +"\",\"crid\":\""+cr_id+ 
				"\",\"weekno\":"+ String.valueOf(weekNo) +
				",\"dayno\":" + String.valueOf(dayNo)+
				",\"timeNo\":" + String.valueOf(timeNo)+
				",\"reason\":\"" + reason +"\"}";
		return js;
	}
}
