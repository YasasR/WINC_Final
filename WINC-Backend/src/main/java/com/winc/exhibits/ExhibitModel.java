package com.winc.exhibits;

import java.security.Timestamp;
import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class ExhibitModel {

	@Id
	String idToDb;
	int id;
	String name;
	int count;
	Date date;
	String[] tags;
	String time;
	
	public ExhibitModel(int id, String name, int count, String[] tags) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.tags = tags;
		this.time = Long.toString(System.currentTimeMillis());
	}
	
	public String getIdToDb() {
		return idToDb;
	}
	public void setIdToDb(String idToDb) {
		this.idToDb = idToDb;
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
}
