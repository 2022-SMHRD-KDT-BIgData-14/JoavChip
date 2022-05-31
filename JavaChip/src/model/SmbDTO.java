package model;

public class SmbDTO {

	
	//field
	private String id, pw, n_name; 
	int c_no;
	
	//»ý¼ºÀÚ
	
	/**
	 * @param id
	 * @param pw
	 * @param name
	 * @param charNem
	 */
	public SmbDTO(String id, String pw, String n_name, int c_no) {
		super();
		this.id = id;
		this.pw = pw;
		this.n_name = n_name;
		this.c_no = c_no;
	}
	
	
	public SmbDTO(String id, String pw, String n_name) {
		super();
		this.id = id;
		this.pw = pw;
		this.n_name = n_name;
	}
	public SmbDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	// getter setter
	
	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
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

}
