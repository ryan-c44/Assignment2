package assignment2;

import java.util.*;

public class Service implements Cloneable, ProductInformation, ShoppingCart {
	
	private String id;
	private String name;
	private String detail;
	private String parts;
	private double duration;
	private double pricePerUnit;
	private boolean status;
	
	public Service(String id, String name, String detail, String parts, double duration, double pricePerUnit, boolean status) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.parts = parts;
		this.duration = duration;
		this.pricePerUnit = pricePerUnit;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParts() {
		return parts;
	}

	public void setParts(String parts) {
		this.parts = parts;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public int compareTo(Service other) {
		return this.id.compareTo(other.id);
	}
	
	public Service clone() {
		try {
			Service other = (Service) super.clone();
			return other;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", detail=" + detail + ", parts=" + parts + ", duration="
				+ duration + ", pricePerUnit=" + pricePerUnit + ", status=" + status + "]";
	}

	public String getAttributeDescriptionForSavingToFile() {
		return "ID, Name, Detail, Parts, Duration, Price Per Unit, Status";
	}
	
	public String getDataToSaveToFile() {
		return "Service [id=" + id + ", name=" + name + ", detail=" + detail + ", parts=" + parts + ", duration="
				+ duration + ", pricePerUnit=" + pricePerUnit + ", status=" + status + "]";
	}
	
	public static Service findServiceByID(ArrayList<Service> serviceList, String id) {
		for(Service service : serviceList) {
			if(service.getId().equals(id)) {
				return service;
			}
		}
		return null;
	}
	
	public static ArrayList<Service> findServiceByKeyWordSearchOnName(ArrayList<Service> serviceList, String name) {
		ArrayList<Service> services = new ArrayList<Service>();
		
		for(Service service : serviceList) {
			if(service.getName().contains(name)) {
				services.add(service);
			}
		}
		return services;
	}
	
	public static ArrayList<Service> filterServiceByDuration(ArrayList<Service> serviceList, double duration) {
		ArrayList<Service> services = new ArrayList<Service>();
		
		for(Service service : serviceList) {
			if(service.getDuration() == duration) {
				services.add(service);
			}
		}
		return services;
	}

	
	public String getProductDescription() {
		return name + " " + duration;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public String getUnitDescription() {
		return detail;
	}
	
	public String getProductID() {
		return id;
	}

}
