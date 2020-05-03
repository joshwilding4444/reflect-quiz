package com.reflectquiz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema="reflectquiz_dummy")
public class User implements Serializable {
	@Id
	@GeneratedValue(generator="reflectquiz_dummy.users_id_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "reflectquiz_dummy.users_id_seq", allocationSize=1)
	@Column
	private int id;
	@Column
	private String username;
	@Column
	private String userpassword;
	@Column
	private String userrole;
	
	public User() {
		super();
	}
	
	public User(int id, String username, String userpassword, String userrole) {
		super();
		this.id = id;
		this.username = username;
		this.userpassword = userpassword;
		this.userrole = userrole;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userpassword=" + userpassword + ", userrole=" + userrole
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((userpassword == null) ? 0 : userpassword.hashCode());
		result = prime * result + ((userrole == null) ? 0 : userrole.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (userpassword == null) {
			if (other.userpassword != null)
				return false;
		} else if (!userpassword.equals(other.userpassword))
			return false;
		if (userrole == null) {
			if (other.userrole != null)
				return false;
		} else if (!userrole.equals(other.userrole))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserPassword(String userPassword) {
		this.userpassword = userPassword;
	}
	public String getUserRole() {
		return userrole;
	}
	public void setUserRole(String userRole) {
		this.userrole = userRole;
	}
	
	
}
