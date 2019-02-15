package com.winc.exhibits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExhibitService {
	
//	@Autowired
//	private ExhibitRepository exhibitRepository;
	
	private List<Exhibit> exhibits = new ArrayList<> (Arrays.asList(
			new Exhibit(1, 7, "Smart_Board_1", null),
			new Exhibit(2, 1, "Smart_Board_2", null),
			new Exhibit(3, 5, "Smart_Board_3", null),
			new Exhibit(4, 8, "Smart_Board_4", null),
			new Exhibit(5, 3, "Printed", null)
			));
	
	private int[] totalMinutes = {0, 0, 0, 0, 0};
	
	public List<Exhibit> getExhibits() {
		return this.exhibits;
	}
	
	public int[] getTotoalMinutes() {
		return totalMinutes;
	}
	
	public Exhibit addExhibit(Exhibit exhibit) {
		exhibits.add(exhibit);
		return exhibit;
	}

	public Exhibit updateTopic(int id, Exhibit exhibit) {
		for (int i=0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getId() == id) {
				exhibits.set(i, exhibit);
				return exhibit;
			}
		}
		return null;
	}

	public void deleteExhibit(int id) {
		for (int i=0; i < exhibits.size(); i++) {
			if (exhibits.get(i).getId() == id) {
				exhibits.remove(i);
			}
		}
	}

	// returns one exhibit by id
	public Exhibit getExhibit(int id) {
		return this.exhibits.stream().filter((e) -> e.getId() == id).findFirst().get();
	}
	
	// Increase total count
	public void increaseCount(int idx, int tagsCount) {
		totalMinutes[idx - 1] = totalMinutes[idx - 1] + tagsCount;
	}

}
