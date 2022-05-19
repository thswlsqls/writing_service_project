package com.project.model;

public class BookmarkVO {
	
	private String writeNo;
	private String userId;
	
	private String bookmartDate;
	private String suggestionName;
	private String penName;
	
	public BookmarkVO() {}
	
	public BookmarkVO(String writeNo
			, String userId
			, String bookmartDate
			, String suggestionName
			, String penName) {
		super();
		setWriteNo(writeNo);
		setUserId(userId);;
		setBookmartDate(bookmartDate);
		setSuggestionName(suggestionName);
		setPenName(penName);
	}

	public BookmarkVO(String bookmartDate, String suggestionName, String penName) {
		super();
		setBookmartDate(bookmartDate);
		setSuggestionName(suggestionName);
		setPenName(penName);
	}
	
	public String getBookmartDate() {
		return bookmartDate;
	}
	public void setBookmartDate(String bookmartDate) {
		this.bookmartDate = bookmartDate;
	}
	public String getSuggestionName() {
		return suggestionName;
	}
	public void setSuggestionName(String suggestionName) {
		this.suggestionName = suggestionName;
	}
	public String getPenName() {
		return penName;
	}
	public void setPenName(String penName) {
		this.penName = penName;
	}
	public String getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BookmarkVO [writeNo=" + writeNo + ", userId=" + userId + ", bookmartDate=" + bookmartDate
				+ ", suggestionName=" + suggestionName + ", penName=" + penName + "]\n";
	}
}
