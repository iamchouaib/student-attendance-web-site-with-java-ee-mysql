package model;

public class Teacher {

	//feild
	private int id;
	private String firstName ;

	private String lastName ;
	private String email;
	
	private String groups;
	private String about;
	
	private String module;
	private String password;
	private String image;
	public Teacher(int id, String firstName, String lastName, String email, String groups, String about, String module,
			String password, String image) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.groups = groups;
		this.about = about;
		this.module = module;
		this.password = password;
		this.image = image;
	}
	public Teacher() {
		// TODO Auto-generated constructor stub  // constractor for test 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", groups=" + groups + ", about=" + about + ", module=" + module + ", password=" + password
				+ ", image=" + image + "]";
	}
	
	
}
