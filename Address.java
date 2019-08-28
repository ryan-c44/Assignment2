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
		this.street_number = "";
		this.street_name = "";
		this.suburb = "";
		this.city = "";
		this.state = "";
		this.postcode = 0;
	}
	
	public String toString() {
		return "Address [street_number=" + street_number + ", street_name=" + street_name + ", suburb=" + suburb
				+ ", city=" + city + ", state=" + state + ", postcode=" + postcode + "]";
	}

	protected String getStreet_number() {
		return street_number;
	}

	protected void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	protected String getStreet_name() {
		return street_name;
	}

	protected void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	protected String getSuburb() {
		return suburb;
	}

	protected void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	protected String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	protected String getState() {
		return state;
	}

	protected void setState(String state) {
		this.state = state;
	}

	protected int getPostcode() {
		return postcode;
	}

	protected void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	
}
