package model;

import java.util.Date;

public class Patent {
	private	String Patname;
	private String Pleader;
	private String Patsn;
	private Date Patapdate;
	private Date Patemdate;
	private String Patgrad;
	private String Patremarks;
	private String Paccessory;
	private int TotalRecord; //数据总条数
	private String message;//留言
	private String Paudit; //审核情况
	
	
	public Patent(String patname, String pleader, String patsn, Date patapdate, Date patemdate, String patgrad,
			String patremarks, String paccessory, int totalRecord) {
		super();
		Patname = patname;
		Pleader = pleader;
		Patsn = patsn;
		Patapdate = patapdate;
		Patemdate = patemdate;
		Patgrad = patgrad;
		Patremarks = patremarks;
		Paccessory = paccessory;
		TotalRecord = totalRecord;
	}

	public Patent(String patname, String pleader, String patsn, Date patapdate, Date patemdate, String patgrad,
			String patremarks, String paccessory, int totalRecord, String message, String paudit) {
		super();
		Patname = patname;
		Pleader = pleader;
		Patsn = patsn;
		Patapdate = patapdate;
		Patemdate = patemdate;
		Patgrad = patgrad;
		Patremarks = patremarks;
		Paccessory = paccessory;
		TotalRecord = totalRecord;
		this.message = message;
		Paudit = paudit;
	}

	public Patent(String patname, String pleader, String patsn, Date patapdate, Date patemdate, String patgrad,
			String patremarks) {
		super();
		Patname = patname;
		Pleader = pleader;
		Patsn = patsn;
		Patapdate = patapdate;
		Patemdate = patemdate;
		Patgrad = patgrad;
		Patremarks = patremarks;
	}

	public Patent(String patname, String pleader, String patsn, Date patapdate, Date patemdate, String patgrad,
			String patremarks, int totalRecord) {
		super();
		Patname = patname;
		Pleader = pleader;
		Patsn = patsn;
		Patapdate = patapdate;
		Patemdate = patemdate;
		Patgrad = patgrad;
		Patremarks = patremarks;
		TotalRecord = totalRecord;
	}
	
	public Patent() {
		// TODO Auto-generated constructor stub
	}

	public int getTotalRecord() {
		return TotalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		TotalRecord = totalRecord;
	}
	public String getPaccessory() {
		return Paccessory;
	}
	public void setPaccessory(String paccessory) {
		Paccessory = paccessory;
	}
	public String getPatname() {
		return Patname;
	}
	public void setPatname(String patname) {
		Patname = patname;
	}
	public String getPleader() {
		return Pleader;
	}
	public void setPleader(String pleader) {
		Pleader = pleader;
	}
	public String getPatsn() {
		return Patsn;
	}
	public void setPatsn(String patsn) {
		Patsn = patsn;
	}
	public Date getPatapdate() {
		return Patapdate;
	}
	public void setPatapdate(Date patapdate) {
		Patapdate = patapdate;
	}
	public Date getPatemdate() {
		return Patemdate;
	}
	public void setPatemdate(Date patemdate) {
		Patemdate = patemdate;
	}
	public String getPatgrad() {
		return Patgrad;
	}
	public void setPatgrad(String patgrad) {
		Patgrad = patgrad;
	}
	public String getPatremarks() {
		return Patremarks;
	}
	public void setPatremarks(String patremarks) {
		Patremarks = patremarks;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPaudit() {
		return Paudit;
	}

	public void setPaudit(String paudit) {
		Paudit = paudit;
	}
	
	
}
