package dataBuilders;

public class PersonalInformation {
	private String firstName;
	private String lastName;
	private String gender;
	
	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
