package com.oufaaa.MyPosts.Entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private int postid;
	private String content;
	private String username;
	private String status;
	private String date_created;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", content=" + content + ", username=" + username + ", status=" + status
				+ ", date_created=" + date_created + "]";
	}
	
	
}
