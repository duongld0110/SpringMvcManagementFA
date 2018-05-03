package com.fa.management.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user", catalog = "fa_g1", uniqueConstraints = @UniqueConstraint(columnNames = "Username"))
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 848190349966576216L;
	private UserId id;

	public User() {
	}

	public User(UserId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "username", column = @Column(name = "Username", unique = true, nullable = false, length = 50)),
			@AttributeOverride(name = "password", column = @Column(name = "Password", nullable = false, length = 50)),
			@AttributeOverride(name = "roll", column = @Column(name = "Roll", nullable = false)) })
	public UserId getId() {
		return this.id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

}
