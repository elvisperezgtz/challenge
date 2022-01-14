package com.petstore.features.pets;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Update;
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
@Narrative(text = {"As a PetStore user",
        "I want to be able to update a pet info",
        "in order to register all the relevant info"})
@WithTagValuesOf({"invoices", "with-taxes"})
public class UpdatePets extends BaseConf {
    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_petBeUpdate_when_submittingTheRequiredData() throws IOException {
        String jsonBody = generateStringFromResource("src/main/resources/data/pets/pet_complete.json");
        jsonBody=jsonBody.replace("Rocco","Ramsy");

        elvis.attemptsTo(
                Update.petInformationWithInfo(jsonBody)
        );

        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The name of the pet should be update to Ramsy",
                        response -> response.body("name",
                                Matchers.equalTo("Ramsy")))
        );

    }

    @Test
    public void should_petBeNotUpdate_when_aNonExistingID_isSubmitted() throws IOException {
        String jsonBody = generateStringFromResource("src/main/resources/data/pets/pet_complete.json");
        jsonBody=jsonBody.replace("11","9000");

        elvis.attemptsTo(
                Update.petInformationWithInfo(jsonBody)
        );

        elvis.should(
                seeThatResponse("Service should response 404",
                        response -> response.statusCode(is(404))),
                seeThatResponse("The response body",
                        response -> response.body(
                                Matchers.equalTo("Pet not found")))
        );

    }
    @Test
    public void should_petBeNotUpdate_when_withoutNameField_isSubmitted() throws IOException {

        String jsonBody = generateStringFromResource("src/main/resources/data/pets/pet_without_name.json");

        elvis.attemptsTo(
                Update.petInformationWithInfo(jsonBody)
        );

        elvis.should(
                seeThatResponse("Service should response 405",
                        response -> response.statusCode(is(405))),
                seeThatResponse("The response body",
                        response -> response.body(
                                Matchers.equalTo("Validation exception")))
        );

    }
}
