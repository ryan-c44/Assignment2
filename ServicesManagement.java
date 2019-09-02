package assignment2;

import java.util.*;

public class ServicesManagement {
	
	private ArrayList<Service> services = new ArrayList<Service>();
	
	public ServicesManagement() {
		
	}
	
	public boolean addService(Service service) {
		return services.add(service);
	}
	
	public Service findServiceByID(String id) {
		for(Service service : services) {
			if(service.getId().equals(id)) {
				return service;
			}
		}
		return null;
	}
}
