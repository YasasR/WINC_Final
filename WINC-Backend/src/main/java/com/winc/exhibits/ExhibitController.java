package com.winc.exhibits;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExhibitController {
	
	@Autowired
	private ExhibitService exhibitService;
	
	@Autowired
	private ExhibitRepository repository;
	
	@RequestMapping("/getExhibits")
	public List<Exhibit> getExhibits() {
		return this.exhibitService.getExhibits();
	}
	
	@RequestMapping("/getTotalMinutes")
	public int[] getTotalMinutes() {
		return this.exhibitService.getTotoalMinutes();
	}
	
	@RequestMapping("/getExhibit/{id}")
	public Exhibit getExhibit(@PathVariable int id) {
		return this.exhibitService.getExhibit(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addExhibit")
	public Exhibit addExhibit(@RequestBody Exhibit exhibit) {
		return this.exhibitService.addExhibit(exhibit);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/updateExhibit")
	public Exhibit updateExhibit(@RequestBody Exhibit exhibit) {
		
//		System.out.println(exhibit.toString());
		
		// Print object
		System.out.println(exhibit.toString());
		
		// Increase the total number of minutes
		this.exhibitService.increaseCount(exhibit.getId(), exhibit.getCount());
//		System.out.println(Arrays.toString(this.exhibitService.getTotoalMinutes()));
		
		// Save to database
		this.repository.save(new ExhibitModel(exhibit.getId(), exhibit.getName(), exhibit.getCount(), exhibit.getTags()));
//		System.out.println(exhibit.toString());
		
		// Return the object
		return this.exhibitService.updateTopic(exhibit.getId(), exhibit);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void delelteExhibit(@PathVariable int id) {
		this.exhibitService.deleteExhibit(id);
	}
}
