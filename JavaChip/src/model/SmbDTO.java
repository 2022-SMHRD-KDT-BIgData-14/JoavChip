package model;

public class SmbDTO {

	// field
	private String id, n_name, pw;
	int c_no;
	int lv;
	int point;

	// 持失切
	public SmbDTO() {

	}

	
	public SmbDTO(String id, String pw, String n_name, int c_no, int lv) {	

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

	public SmbDTO(String id, String n_name, String pw, int c_no, int lv, int point) {
		super();
		this.id = id;
		this.n_name = n_name;
		this.pw = pw;
		this.c_no = c_no;
		this.lv = lv;
		this.point = point;
	}

	public SmbDTO(String id, String pw, String n_name, int c_no) {	 // join
		super();
		this.id = id;
		this.pw = pw;
		this.n_name = n_name;
		this.c_no = c_no;
	}

	public SmbDTO(String id, String pw) {		// login
		this.id = id;
		this.pw = pw;
	}

	// getter setter

	public String getId() {
		return id;
	}

	public String getN_name() {
		return n_name;
	}

	public void setN_name(String n_name) {
		this.n_name = n_name;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
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

	// Music

	private String when, path;

	// 持失切
	public SmbDTO(String when, String path, char id) {
		this.when = when;
		this.path = path;

	}

	public SmbDTO(String id, String pw, int c_no) {
		super();
		this.id = id;
		this.pw = pw;
		this.c_no = c_no;
	}

	public SmbDTO(String id, int point, int lv) {
		this.id = id;
		this.point = point;
		this.lv = lv;
	}

	// Getter & Setter
	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
