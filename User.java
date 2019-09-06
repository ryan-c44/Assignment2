package assignment2;

import java.util.*;

public abstract class User implements Cloneable, Comparable<User> {
	
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
	

	protected void setId(String id) throws Exception {
		this.id = id;
		
		for(int i = 0; i < id.length(); i++) {
			if(Character.isDigit(id.charAt(i))) {
				throw new Exception();
			}
		}
	}
	
	public String errorMessage() {
		return "Invalid ID.";
	}
	
	public String getId() {
		return id;
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

	public void setPermission(PermissionType permission) throws Exception {
		this.permission = permission;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) throws Exception {
		if(password.length() < 7) {
			throw new Exception();
		} else {
			this.password = password;
		}
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public boolean verifyUsernameAndPassword(String username, String password) {
		if(this.username.equals(username) && this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public boolean verifyUsername(String username) {
		if (this.username.equals(username)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyUserType(UserType userType) {
		if(this.userType.equals(userType)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyPermission(PermissionType permission) {
		if(this.permission.equals(permission)) {
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
	
	@Override
	public int compareTo(User otherUser) {
		return this.id.compareTo(otherUser.id);
	} 

	public static User findUserByUsername(ArrayList<User> userList, String username) {
		for (User user : userList) {
			if (user.getUsername().contains(username)) {
				return user;
			}
		}
		return null;
	}
	
	public static ArrayList<User> filterUserByUserType(ArrayList<User> users, UserType userType) {
		for(User user : users) {
			if(user.getUserType() == userType) {
				users.add(user);
			}
		}
		return users;	
	}
	
	public static boolean verifyLogInByUsernameAndPassword(ArrayList<User> users, String username, String password) {
		for(User user : users) {
			if(user.verifyUsernameAndPassword(username, password)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<String> getListOfUserFullName(ArrayList<User> users) {
		
		ArrayList<String> userFullNames = new ArrayList<String>();
		
		for(User user : users) {
			userFullNames.add(user.getFullName());
		}
		return userFullNames;
	}
	
	public static Map<String, User> getMapOfUserWithUsernameAsKey(ArrayList<User> users) {
		Map<String, User> map = new HashMap<String, User>();
		for(User user : users) {
			map.put(user.getUsername(), user);
		}
		return map;
	}
	
	public static Map<String, User> getMapOfUserWithLastNameAsKey(ArrayList<User> users) {
		Map<String, User> map = new HashMap<String, User>();
		for(User user : users) {
			map.put(user.getLastName(), user);
		}
		return map;
	}
	
}
