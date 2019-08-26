package assignment2;

public enum PermissionType {
	Edit("Allow to view or edit", 1), Booking("Only allow to view and booking the service", 2), View("Only allow to view the services", 3), None("Don't have any permission", 5);
	
	private String name;
	private int id;
	
	PermissionType(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return this.name();
	}
}
