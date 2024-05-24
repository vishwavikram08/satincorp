import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TendableTechStepDefinition {
	
	TendableTechPageClass tendableTech = new TendableTechPageClass();
	
	@SuppressWarnings("deprecation")
	@Given("user launches the Tendable tech URL on compatible browser")
	public void user_launches_the_tendable_tech_url_on_compatible_browser() {
		tendableTech.setUp();
		System.out.println("user is able to launch the website");
	    
	}

	@When("user navigates through the top level menus and request a demo button is present and active")
	public void user_navigates_through_the_top_level_menus_and_request_a_demo_button_is_present_and_active() {
		tendableTech.navigateThroughTopMenus();
		System.out.println("User is able to navigate through the top menus and is able to validate the Request a demo button");
	}

	@When("user clicks the Contact us button")
	public void user_clicks_the_contact_us_button() {
		tendableTech.clickContactUsBtn();
		System.out.println("User is able to click on the contact us button");
	    
	}

	@When("user click on the Marketing option")
	public void user_click_on_the_marketing_option() {
		tendableTech.clickMarketingOption();
		System.out.println("User is able to click on the marketing option and is displayed with the form");
	}

	@Then("user fills up the form excluding the Message field and confirms the error message after submission")
	public void user_fills_up_the_form_excluding_the_message_field_and_confirms_the_error_message_after_submission() {
		tendableTech.enterCustomerDetails("vishwa singh", "PwC", "Management", "9648899288", "vishwasingh@gmail.com");
		System.out.println("User is able to enter the details and is able to verify the error message");
	}

}
