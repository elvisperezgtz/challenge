package com.petstore.features.customers;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Create;
import com.petstore.tasks.EliminateAnUser;
import com.petstore.tasks.Find;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static com.petstore.utils.JSON.generateStringFromResource;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a PetStore manager",
        "I want to be able to create an user",
        "in order to register new users"})
@WithTagValuesOf({"store", "orders"})
public class Users extends BaseConf {

    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_theUserBeCreated_When_sendOrderInfo() throws IOException {
        String jsonBody = generateStringFromResource("src/main/resources/data/users/users.json");

        elvis.attemptsTo(
                Create.aNewUserWithInfo(jsonBody)
        );
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The order most be created",
                        response -> response.body("id",
                                Matchers.equalTo(12)))
        );
        elvis.attemptsTo(Find.userByUsername("bugBuster"));
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The first name is",
                        response -> response.body("firstName",
                                Matchers.equalTo("John")))
        );
    }

    @Test
    public void should_TheUserBeEliminated_when_SendUsername(){

        elvis.attemptsTo(EliminateAnUser.withUsername("bugBuster"));
        elvis.attemptsTo(Find.userByUsername("bugHunter"));
        elvis.should(
                seeThatResponse("Service should response 404",
                        response -> response.statusCode(is(404))),
                seeThatResponse("User not found",
                        response -> response.body(
                                Matchers.equalTo("User not found")))
        );
    }
}