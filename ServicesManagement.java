package assignment2;

import java.util.*;

public class ServicesManagement {
	
	private ArrayList<Service> services = new ArrayList<Service>();
	
	public ServicesManagement() {
		
	}
	
	public boolean addService(Service service) {
		return services.add(service);
	}
	
	public Service findServiceByKeyWordSearch(String name) {
		for(Service service : services) {
			if(service.getName().equals(name)) {
				return service;
			}
		}
		return null;
	}
}
