package com.healthcare.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer iduser;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	@Column(name = "stateconnect")
	private boolean stateConnect;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idprofil", foreignKey=@ForeignKey(name="fk_userprofil"))
	private Profil profil;
	
	
	public User() {}
	

	public User(String firstName, String lastName, String userName, String passWord, boolean stateConnect,
			Profil profil) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.stateConnect = stateConnect;
		this.profil = profil;
	}

	
	
	
	
	public Profil getProfil() {
		return profil;
	}


	public void setProfil(Profil profil) {
		this.profil = profil;
	}


	public boolean isStateConnect() {
		return stateConnect;
	}


	public void setStateConnect(boolean stateConnect) {
		this.stateConnect = stateConnect;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getIdUser() {
		return iduser;
	}


	public void setIdUser(Integer idUser) {
		this.iduser = idUser;
	}

	

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWord=" + passWord + ", stateConnect=" + stateConnect + ", profil=" + profil + "]";
	}

	

}
