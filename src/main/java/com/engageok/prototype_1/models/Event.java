package com.engageok.prototype_1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="Name cannot be blank")
	private String name;
	
	@Size(min=1, message="Description cannot be blank")
	private String description;
	
	private Long user_id;
	
	private Date date;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "events_users",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<User> users;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organization")
	private Organization organization;
	//
	
	public Event() {}

	//			GETTERS AND SETTERS 
	
	
	public Long getId() {
		return id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
