package com.javahome.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Person")

@NamedQueries(value={
		
		@NamedQuery(name="personSelectQuery",query="from PersonModel as pm where pm.id>=? and pm.id<=?"),
		@NamedQuery(name="personUpdateQuery",query="update PersonModel set pname=:name where id=:personId")
		
})

@NamedNativeQueries(value={
		@NamedNativeQuery(name="personNativeSelectQuery",query="select * from Person where pid>=? and pid<=?",resultClass=PersonModel.class)
})
public class PersonModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3291436339238376489L;

	@Column(name="pid")
	@Id
	private int id;

	@Column(name="name")
	private String pname;

	@Column(name="emailId")
	private String pemailId;

	public PersonModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonModel(int id, String pname, String pemailId) {
		super();
		this.id = id;
		this.pname = pname;
		this.pemailId = pemailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPemailId() {
		return pemailId;
	}

	public void setPemailId(String pemailId) {
		this.pemailId = pemailId;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + ", pemailId=" + pemailId + "]";
	}

}
