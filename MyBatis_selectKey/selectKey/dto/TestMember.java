package selectKey.dto;

public class TestMember {
	
	private String id;
	private int no;
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "TestMember [id=" + id + ", no=" + no + ", pw=" + pw + "]";
	}
	
	


}
