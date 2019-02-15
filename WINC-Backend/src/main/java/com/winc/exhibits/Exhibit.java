package com.winc.exhibits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity

//import org.springframework.data.annotation.*;

public class Exhibit {
	
//	@Id
	private int id;
	private String name;
	private int count;
	private String[] tags;
	
//	public Exhibit(int id, String name, int count) {
//		this.id = id;
//		this.name = name;
//		this.count = count;
//	}
	
//	public Exhibit(int id, int count, String[] tags) {
//		this.id = id;
//		this.count = count;
//		this.name = "Not Specified";
//		this.tags = tags;
//	}
	
	public Exhibit(int id, int count, String name, String[] tags) {
		this.id = id;
		this.count = count;
		this.name = name;
		this.tags = tags;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String[] getTags() {
		return this.tags;
	}
	
	public String toString() {
		return this.id + " " + this.name + " " + this.count + " " + Arrays.toString(this.tags);
	}
}
