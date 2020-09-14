package model;

import java.sql.Date;

public class Qna {
	private int qnaID;
	private String qnaTitle;
	private String qnaWriter;
	private Date qnaDate;
	private String qnaContent;
	
	public Qna() {
		super();
	}

	public Qna(int qnaID, String qnaTitle, String qnaWriter, Date qnaDate, String qnaContent) {
		super();
		this.qnaID = qnaID;
		this.qnaTitle = qnaTitle;
		this.qnaWriter = qnaWriter;
		this.qnaDate = qnaDate;
		this.qnaContent = qnaContent;
	}

	public int getQnaID() {
		return qnaID;
	}

	public void setQnaID(int qnaID) {
		this.qnaID = qnaID;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaWriter() {
		return qnaWriter;
	}

	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	@Override
	public String toString() {
		return "Qna [qnaID=" + qnaID + ", qnaTitle=" + qnaTitle + ", qnaWriter=" + qnaWriter + ", qnaDate=" + qnaDate
				+ ", qnaContent=" + qnaContent + "]";
	}
	
	
}
