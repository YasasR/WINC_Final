package WINC_FrontEnd.winc_front;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {
	
	private static Service service;
	private static RestTemplate restTemplate;
	
	private Service() {}
	
	public static Service getServiceInstance() {
		if (service == null) {
			restTemplate = new RestTemplate();
			service = new Service();
		}
		return service;
	}
	
	public Exhibit[] getAllExhbitsCount() {
		ResponseEntity<Exhibit[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/getExhibits", Exhibit[].class);
        return responseEntity.getBody();
	}
}
