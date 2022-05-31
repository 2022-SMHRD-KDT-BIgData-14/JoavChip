package model;

public class SmbDTO {

	
	//field
	private String id, n_name; 
	int pw;
	int c_no;
	int lv;
	int point;
	
	//»ý¼ºÀÚ
	
	public SmbDTO(String id, int pw, String n_name, int c_no, int lv) {
		super();
		this.id = id;
		this.pw = pw;
		this.n_name = n_name;
		this.c_no = c_no;
		this.lv = lv;
	}

	/**
	 * @param id
	 * @param pw
	 * @param name
	 * @param charNem
	 */
	public SmbDTO(String id, int pw, String n_name, int c_no) {
		super();
		this.id = id;
		this.pw = pw;
		this.n_name = n_name;
		this.c_no = c_no;
	}
	
	public SmbDTO(String id, String n_name, int pw, int c_no, int lv, int point) {
		super();
		this.id = id;
		this.n_name = n_name;
		this.pw = pw;
		this.c_no = c_no;
		this.lv = lv;
		this.point = point;
	}

	

	public SmbDTO(String id, int pw, String n_name) {
		super();
		this.id = id;
		this.pw = pw;
		this.n_name = n_name;
	}
	public SmbDTO(String id, int pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	// getter setter
	
	public SmbDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	
	public int getPw() {
		return pw;
	}
	
	public void setPw(int pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return n_name;
	}
	
	
	public void setName(String n_name) {
		this.n_name = n_name;
	}
	
	public int getCharNem() {
		return c_no;
	}
	public void setCharNem(int c_no) {
		this.c_no = c_no;
	}

	

	public int getLv() {
		return lv;
	}
	
	
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
