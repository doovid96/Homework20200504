package demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataBuilders.PersonalInformation;
import dataBuilders.PersonalInformationBuilder;
import dataBuilders.PersonalInformationObjectMothers;
import demoqa.pages.FormsPage;

public class Form extends DemoQaTestBase {

	@Test
	public void canFillTopPartOfFormUsingConventialPattern() {

		String expectedFirstName = "Dennis";
		String expectedLastName = "Taylor";
		String expectedGender = "Male";

		FormsPage formsPage = new FormsPage(driver, baseUrl);

		formsPage
		.navigate()
		.enterFormDetails(expectedFirstName, expectedLastName, expectedGender);

		String actualFirstName = formsPage.firstNameTextbox.getAttribute("value");
		String actualLastName = formsPage.lastNameTextbox.getAttribute("value");
		String actualGender = formsPage.getGender();

		Assert.assertEquals(actualFirstName, expectedFirstName);
		Assert.assertEquals(actualLastName, expectedLastName);
		Assert.assertEquals(actualGender, expectedGender);
	}

	@Test
	public void canFillTopPartOfFormUsingValueObject() {

		PersonalInformation userData = new PersonalInformation();
		userData.setFirstName("Dennis");
		userData.setLastName("Taylor");
		userData.setGender("Male");

		FormsPage formsPage = new FormsPage(driver, baseUrl);

		formsPage
		.navigate()
		.enterFormDetails(userData);

		String actualFirstName = formsPage.firstNameTextbox.getAttribute("value");
		String actualLastName = formsPage.lastNameTextbox.getAttribute("value");
		String actualGender = formsPage.getGender();

		Assert.assertEquals(actualFirstName, userData.getFirstName());
		Assert.assertEquals(actualLastName, userData.getLastName());
		Assert.assertEquals(actualGender, userData.getGender());
	}

	@Test
	public void canFillTopPartOfFormUsingBuilder() {

		PersonalInformation userData = PersonalInformationBuilder
				.runtimeBuilder()
				.withFirstName("Dennis")
				.withLastName("Taylor")
				.withGender("Male")
				.build();

		FormsPage formsPage = new FormsPage(driver, baseUrl);

		formsPage
		.navigate()
		.enterFormDetails(userData);

		String actualFirstName = formsPage.firstNameTextbox.getAttribute("value");
		String actualLastName = formsPage.lastNameTextbox.getAttribute("value");
		String actualGender = formsPage.getGender();

		Assert.assertEquals(actualFirstName, userData.getFirstName());
		Assert.assertEquals(actualLastName, userData.getLastName());
		Assert.assertEquals(actualGender, userData.getGender());
	}

	@Test
	public void canFillTopPartOfFormUsingObjectMother() {

		PersonalInformation userData = PersonalInformationObjectMothers.getJohnSmith();

		FormsPage formsPage = new FormsPage(driver, baseUrl);

		formsPage
		.navigate()
		.enterFormDetails(userData);

		PersonalInformation actualUserData = formsPage.getFormFieldData();

		Assert.assertEquals(actualUserData.getFirstName(), userData.getFirstName());
		Assert.assertEquals(actualUserData.getLastName(), userData.getLastName());
		Assert.assertEquals(actualUserData.getGender(), userData.getGender());
	}
}
