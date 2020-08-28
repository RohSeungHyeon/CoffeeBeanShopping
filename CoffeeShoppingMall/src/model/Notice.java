package model;

import java.sql.Date;

import org.json.simple.JSONAware;

public class Notice implements JSONAware {
	private int notID;
	private String notTitle;
	private String notWriter;
	private Date notDate;
	private String notContent;

	public Notice() {
		super();
	}

	public Notice(int notID, String notTitle, String notWriter, Date notDate, String notContent) {
		super();
		this.notID = notID;
		this.notTitle = notTitle;
		this.notWriter = notWriter;
		this.notDate = notDate;
		this.notContent = notContent;
	}

	public int getNotID() {
		return notID;
	}

	public void setNotID(int notID) {
		this.notID = notID;
	}

	public String getNotTitle() {
		return notTitle;
	}

	public void setNotTitle(String notTitle) {
		this.notTitle = notTitle;
	}

	public String getNotWriter() {
		return notWriter;
	}

	public void setNotWriter(String notWriter) {
		this.notWriter = notWriter;
	}

	public Date getNotDate() {
		return notDate;
	}

	public void setNotDate(Date notDate) {
		this.notDate = notDate;
	}

	public String getNotContent() {
		return notContent;
	}

	public void setNotContent(String notContent) {
		this.notContent = notContent;
	}

	@Override
	public String toString() {
		return "Notice [notID=" + notID + ", notTitle=" + notTitle + ", notWriter=" + notWriter + ", notDate=" + notDate
				+ ", notContent=" + notContent + "]";
	}

	@Override
	public String toJSONString() {
		return "{\"notID\" : \"" + notID + "\", \"notTitle\" : \"" + notTitle + "\", \"notWriter\" : \"" + notWriter
				+ "\", \"notDate\" : \"" + notDate + "\", \"notContent\" : \"" + notContent + "\"}";
	}

}
