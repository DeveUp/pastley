package com.pastley.models.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nickname;
	private Long points;
	private String password;
	private String ip;
	private String lastPassword;
	private boolean statu;
	private boolean session;
	private String dateRegister;
	private String dateUpdate;
	private String dateLastDate;
	private String dateSession;
	private Person person;

	/**
	 * 
	 * @Override public int hashCode() { return Objects.hash(ip); }
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 *           if (obj == null) return false; if (getClass() != obj.getClass())
	 *           return false; User other = (User) obj; return Objects.equals(ip,
	 *           other.ip); }
	 **/
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", points=" + points + ", password=" + password + ", ip="
				+ ip + ", lastPassword=" + lastPassword + ", statu=" + statu + ", session=" + session
				+ ", dateRegister=" + dateRegister + ", dateUpdate=" + dateUpdate + ", dateLastDate=" + dateLastDate
				+ ", dateSession=" + dateSession + ", person=" + person + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public boolean isStatu() {
		return statu;
	}

	public void setStatu(boolean statu) {
		this.statu = statu;
	}

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public String getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDateLastDate() {
		return dateLastDate;
	}

	public void setDateLastDate(String dateLastDate) {
		this.dateLastDate = dateLastDate;
	}

	public String getDateSession() {
		return dateSession;
	}

	public void setDateSession(String dateSession) {
		this.dateSession = dateSession;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

}
