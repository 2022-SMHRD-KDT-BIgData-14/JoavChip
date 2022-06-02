package model;

public class SmbMusicVO {
	
	private String when, path;

	// »ý¼ºÀÚ
	public SmbMusicVO(String when, String path) {
		this.when = when;
		this.path = path;
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
