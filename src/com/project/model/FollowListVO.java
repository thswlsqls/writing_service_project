package com.project.model;

import java.time.LocalDate;
import java.util.Comparator;

public class FollowListVO {
	private String followNo;
	private String followDate;
	private String followeeId;
	private String followerId;
	private String followeePenName;
	
	public FollowListVO() {}
	

//	public FollowListVO(String followDate, String followee_Id) {
//		this(null, followDate, followee_Id, null, null);
//	}
	
	public FollowListVO(String followeeId, String followerId, String followeePenName) {
		this(null, LocalDate.now().toString(), followeeId, followerId, followeePenName);
	}
	
	public FollowListVO(String followNo
			, String followDate
			, String followeeId
			, String followerId
			, String followeePenName) {
		super();
		setFollowNo(followNo);
		setFollowDate(followDate);
		setFolloweeId(followeeId);
		setFollowerId(followerId);
		setFolloweePenName(followeePenName);
	}
	public String getFollowNo() {
		return followNo;
	}
	public void setFollowNo(String followNo) {
		this.followNo = followNo;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	public String getFolloweeId() {
		return followeeId;
	}
	public void setFolloweeId(String followeeId) {
		this.followeeId = followeeId;
	}
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}
	public String getFolloweePenName() {
		return followeePenName;
	}

	public void setFolloweePenName(String followeePenName) {
		this.followeePenName = followeePenName;
	}

	@Override
	public String toString() {
		return "FollowListVO [followNo=" + followNo + ", followDate=" + followDate + ", followeeId=" + followeeId
				+ ", followerId=" + followerId + ", followeePenName=" + followeePenName + "]\n";
	}
	
}
