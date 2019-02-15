package WINC_FrontEnd.winc_front;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Exhibit {

	private Integer id;
	private String name;
	private Integer count;
	private boolean isChanged = false;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Exhibit() {
	}

	/**
	 *
	 * @param id
	 * @param count
	 * @param name
	 */
	public Exhibit(Integer id, String name, Integer count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + ", Name: " + this.name + ", Count: " + this.count;
	}

}
