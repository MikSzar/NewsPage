package com.fdmgroup.newspage.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"catid", "newsid"}) })
public class Plan {
	
	@Id
	@GeneratedValue
	private Integer pid;
	
	private Integer catid, newsid;
	
	public Plan() {}

	public Plan(Integer catid, Integer newsid) {
		super();
		this.catid = catid;
		this.newsid = newsid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}

	public Integer getNewsid() {
		return newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(catid, newsid, pid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plan other = (Plan) obj;
		return Objects.equals(catid, other.catid) && Objects.equals(newsid, other.newsid) && Objects.equals(pid, other.pid);
	}

	@Override
	public String toString() {
		return "Plan [pid=" + pid + ", catid=" + catid + ", newsid=" + newsid + "]";
	}
	
	

}
