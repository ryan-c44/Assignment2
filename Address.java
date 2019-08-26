package assignment2;

public class Address {
	
	private String street_number;
	private String street_name;
	private String suburb;
	private String city;
	private String state;
	private int postcode;
	
	public Address(String street_number, String street_name, String suburb, String city, String state, int postcode) {
		this.street_number = street_number;
		this.street_name = street_name;
		this.suburb = suburb;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
	}
	
	public Address() {
		this.street_number = "123";
		this.street_name = "Default St";
		this.suburb = "DefaultVille";
		this.city = "Default";
		this.state = "DF";
		this.postcode = 0;
	}
	
	public String toString() {
		return "Address [street_number=" + street_number + ", street_name=" + street_name + ", suburb=" + suburb
				+ ", city=" + city + ", state=" + state + ", postcode=" + postcode + "]";
	}
}
