package assignment2;

import java.util.ArrayList;
import java.util.Map;

public abstract class User implements Cloneable {
	
	private String id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private UserType userType;
	private PermissionType permission;
	private boolean status;
	
	public User(String id, String firstName, String lastName, String username, String password, UserType userType,
			PermissionType permission, boolean status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.permission = permission;
		this.status = status;
	}
	

	protected void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public PermissionType getPermission() {
		return permission;
	}

	public void setPermission(PermissionType permission) {
		this.permission = permission;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public boolean verifyUsernameAndPassword(String username, String password) {
		if (this.username == username && this.password == password) {
			return true;
		}
		return false;
	}

	public boolean verifyUsername(String username) {
		if (this.username == username) {
			return true;
		}
		return false;
	}
	
	public boolean verifyUserType(UserType userType) {
		if(this.userType == userType) {
			return true;
		}
		return false;
	}
	
	public boolean verifyPermission(PermissionType permission) {
		if(this.permission == permission) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", userType=" + userType + ", permission=" + permission + ", status=" + status;
	}
	
	public User clone() {
		try {
			User other = (User) super.clone();
			return other;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
	
	/* public int compareTo(User user) {
		
	} */
	
	public static User findUserByUsername(ArrayList<User> userList, String username) {
		for (User user : userList) {
			if (user.getUsername().contains(username)) {
				return user;
			}
		}
		return null;
	}
	
	public boolean verifyLogIn(ArrayList<User> users, String username, String password) {
		for (User user : users) {
			if (user.verifyUsernameAndPassword(username, password)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<User> filterUserByUserType(ArrayList<User> users, UserType userType) {
		
	}
	
	public static boolean verifyLogInByUsernameAndPassword(ArrayList<User> users, String username, String password) {
		
	}
	
	public static ArrayList<String> getListOfUserFullName(ArrayList<User> users) {
		
	}
	
	public static Map<String, User> getMapOfUserWithUsernameAsKey(ArrayList<User> users) {
		
	}
	
	public static Map<String, User> getMapOfUserWithLastNameAsKey(ArrayList<User> users) {
		
	}
	
	
}
