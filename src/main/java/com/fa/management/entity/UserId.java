package com.fa.management.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserId implements java.io.Serializable {

	private static final long serialVersionUID = -8134022896692497954L;
	private String username;
	private String password;
	private int roll;

	public UserId() {
	}

	public UserId(String username, String password, int roll) {
		this.username = username;
		this.password = password;
		this.roll = roll;
	}

	@Column(name = "Username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Roll", nullable = false)
	public int getRoll() {
		return this.roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserId))
			return false;
		UserId castOther = (UserId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null
						&& castOther.getPassword() != null && this.getPassword().equals(castOther.getPassword())))
				&& (this.getRoll() == castOther.getRoll());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result + this.getRoll();
		return result;
	}

}
