package dataBuilders;

public class PersonalInformationBuilder {

	PersonalInformation personalInformation;
	
	public static PersonalInformationBuilder runtimeBuilder() {
		PersonalInformationBuilder builder = new PersonalInformationBuilder();
		builder.personalInformation = new PersonalInformation();
		return builder;
	}

	public PersonalInformationBuilder withFirstName(String firstName) {
		personalInformation.setFirstName(firstName);

		return this;
	}

	public PersonalInformationBuilder withLastName(String lastName) {
		personalInformation.setLastName(lastName);

		return this;
	}

	public PersonalInformationBuilder withGender(String gender) {
		personalInformation.setGender(gender);
		return this;
	}

	public PersonalInformation build() {
		return personalInformation;
	}	
}
