package com.seleniumexpress.selexplms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;

	@Column(name = "instructor_name")
	private String name;

	@Column(name = "instructor_training_exp")
	private int teachingExp;

	@Column(name = "instructor_email")
	private String emai;
	
	@OneToMany(mappedBy = "instructor",fetch = FetchType.LAZY)
	private List<Course> courses;
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	

	public Instructor(String name, int teachingExp, String emai) {
		this.name = name;
		this.teachingExp = teachingExp;
		this.emai = emai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeachingExp() {
		return teachingExp;
	}

	public void setTeachingExp(int teachingExp) {
		this.teachingExp = teachingExp;
	}

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", teachingExp=" + teachingExp + ", emai=" + emai + "]";
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
