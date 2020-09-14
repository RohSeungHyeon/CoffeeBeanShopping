package model;

import java.sql.Date;

public class Comment {
	private int comID;
	private String comWriter;
	private String comContent;
	private Date comDate;
	private int comQnaid;
	
	public Comment() {
		super();
	}

	public Comment(int comID, String comWriter, String comContent, Date comDate, int comQnaid) {
		super();
		this.comID = comID;
		this.comWriter = comWriter;
		this.comContent = comContent;
		this.comDate = comDate;
		this.comQnaid = comQnaid;
	}

	public int getComID() {
		return comID;
	}

	public void setComID(int comID) {
		this.comID = comID;
	}

	public String getComWriter() {
		return comWriter;
	}

	public void setComWriter(String comWriter) {
		this.comWriter = comWriter;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public int getComQnaid() {
		return comQnaid;
	}

	public void setComQnaid(int comQnaid) {
		this.comQnaid = comQnaid;
	}

	@Override
	public String toString() {
		return "Comment [comID=" + comID + ", comWriter=" + comWriter + ", comContent=" + comContent + ", comDate="
				+ comDate + ", comQnaid=" + comQnaid + "]";
	}
	
	
}
