package com.srinath.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
public class Food {
	@Id
private int id;
private String name;
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
@Override
public String toString() {
	return "Food [id=" + id + ", name=" + name + "]";
}
public Food(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Food() {
	super();
	// TODO Auto-generated constructor stub
}


}
