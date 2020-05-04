package dataBuilders;

public class PersonalInformationObjectMothers {
	
	public static PersonalInformation getDennisTaylor() {
		
		return PersonalInformationBuilder.runtimeBuilder()
				.withFirstName("Dennis")
				.withLastName("Taylor")
				.withGender("Male")
				.build();
	}
	
	public static PersonalInformation getJaneDoe() {
		
		return PersonalInformationBuilder.runtimeBuilder()
				.withFirstName("Jane")
				.withLastName("Doe")
				.withGender("Female")
				.build();
	}
	
	public static PersonalInformation getJohnSmith() {
		
		return PersonalInformationBuilder.runtimeBuilder()
				.withFirstName("John")
				.withLastName("Smith")
				.withGender("Male")
				.build();
	}
}
