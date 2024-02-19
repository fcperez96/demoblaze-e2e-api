package demoblaze.stepdefinitions.api;

import com.github.javafaker.Faker;
import demoblaze.models.SignupAndLoginRequest;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.rest;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class SignupAndLoginStepDefinitions {

    Faker faker = new Faker();
    String username = faker.name().username();
    String password = faker.crypto().md5();
    String reponseSignupAndLogin;
    SignupAndLoginRequest signupAndLoginRequest = new SignupAndLoginRequest(username, password);

    @When("{actor} tries to create a new user that does not exist in demoblaze")
    public void buyerTriesToCreateANewUserThatDoesNotExistInDemoblaze(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.demoblaze.com"));
        reponseSignupAndLogin = rest().contentType(JSON).relaxedHTTPSValidation()
                .body(signupAndLoginRequest).when()
                .post(as(actor).resolve("/signup"))
                .andReturn()
                .body().asString();
    }

    @Then("{actor} should see that the user was created correctly")
    public void heShouldSeeThatTheUserWasCreatedCorrectly(Actor actor) {
        Ensure.that(reponseSignupAndLogin).contains("").performAs(actor);
    }

    @But("{actor} tries to create a user that already exists")
    public void heTriesToCreateAUserThatAlreadyExists(Actor actor) {
        reponseSignupAndLogin = rest().contentType(JSON).relaxedHTTPSValidation()
                .body(signupAndLoginRequest).when()
                .post(as(actor).resolve("/signup"))
                .andReturn()
                .body().asString();
    }

    @Then("{actor} should see that it is not possible to create the user because it already exists")
    public void heShouldSeeThatItIsNotPossibleToCreateTheUserBecauseItAlreadyExists(Actor actor) {
        Ensure.that(reponseSignupAndLogin).contains("This user already exist.").performAs(actor);
    }

    @When("{actor} tries to log in with a valid username")
    public void buyerTriesToLogInWithAValidUsername(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.demoblaze.com"));
        rest().contentType(JSON).relaxedHTTPSValidation()
                .body(signupAndLoginRequest).when()
                .post(as(actor).resolve("/signup"));
        reponseSignupAndLogin = rest().contentType(JSON).relaxedHTTPSValidation()
                .body(signupAndLoginRequest).when()
                .post(as(actor).resolve("/login"))
                .andReturn()
                .body().asString();
    }

    @Then("{actor} should see a successful login")
    public void heShouldSeeASuccessfulLogin(Actor actor) {
        Ensure.that(reponseSignupAndLogin).contains("Auth_token").performAs(actor);
    }

    @But("{actor} tries to log in with incorrect information")
    public void heTriesToLogInWithIncorrectInformation(Actor actor) {
        String username = faker.name().username();
        String password = faker.crypto().md5();
        SignupAndLoginRequest signupAndLoginRequest = new SignupAndLoginRequest(username, password);
        reponseSignupAndLogin = rest().contentType(JSON).relaxedHTTPSValidation()
                .body(signupAndLoginRequest).when()
                .post(as(actor).resolve("/login"))
                .andReturn()
                .body().asString();
    }

    @Then("{actor} should see that the login was not successful")
    public void heShouldSeeThatTheLoginWasNotSuccessful(Actor actor) {
        Ensure.that(reponseSignupAndLogin).contains("User does not exist").performAs(actor);
    }
}
