package WINC_FrontEnd.winc_front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ) {
//        RestTemplate restTemplate = new RestTemplate();
//        Exhibit exhibit = restTemplate.getForObject("http://localhost:8080/getExhibit/1", Exhibit.class);
//        log.info(exhibit.toString());
        
//        ResponseEntity<Exhibit[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/getExhibits", Exhibit[].class);
//        Exhibit[] exhibits = responseEntity.getBody();
    	
    	Service service = Service.getServiceInstance();
        
        Thread t = new Thread(() -> {
        	try {
        		while(true) {
            		for (Exhibit ex : service.getAllExhbitsCount())
                    	System.out.println(ex.toString());
            		Thread.sleep(1000);
            	}
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        });
        
        t.start();
        
        
    }
}
