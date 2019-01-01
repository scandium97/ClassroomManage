package bean;

public class User {
	private String id=null;
	private String passwd=null;
	private String tel=null;
	private String status="None";
	public User() {}
	public User(String _id, String _pw, String _tel,int _status) {
		id = _id;
		passwd = _pw;
		tel = _tel;
		switch(_status) {
			case 0: status="student" ;break;
			case 1: status="teacher";break;
		}
	}
	public void setPasswd(String newpw){
		passwd = newpw;
	}
	public void setTel(String newtel) {
		tel = newtel;
	}
}
