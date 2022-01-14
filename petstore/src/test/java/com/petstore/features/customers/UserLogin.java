package com.petstore.features.customers;

import com.petstore.config.BaseConf;
import com.petstore.tasks.LogOut;
import com.petstore.tasks.Login;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a PetStore manager",
        "I want to be able to login",
        "in order to get access to whole functionality"})
@WithTagValuesOf({"store", "orders"})
public class UserLogin extends BaseConf {

    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_theUserBeLoggedIn_when_submittingValidCredentials(){

        elvis.attemptsTo(Login.with("bugHunter","12345"));
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The user is logged in",
                        response -> response.body(
                                Matchers.containsString("Logged in user session")))
        );
    }
    @Test
    public void should_theUserBeAbleToLogOut(){
        elvis.wasAbleTo(Login.with("bugHunter","12345"));
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The user logged in",
                        response -> response.body(
                                Matchers.containsString("Logged in user session")))
        );
        elvis.attemptsTo(LogOut.ofCurrentSession());
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The user logged out",
                        response -> response.body(
                                Matchers.containsString("User logged out")))
        );
    }
}
