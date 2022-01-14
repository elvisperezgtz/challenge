package com.petstore.features.pets;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Create;
import com.petstore.tasks.Find;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static com.petstore.utils.JSON.generateStringFromResource;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a PetStore user",
        "I want to be able to create a pet info",
        "in order to register all the relevant info"})
@WithTagValuesOf({"Pets", "createPets"})
public class CreatePets extends BaseConf {

    Actor elvis;

    @Before
    public void setUp() {

        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_pet_be_created_WhenISendThePetInformation() throws IOException {
        //TODO put this string in a enum
        String jsonBody = generateStringFromResource("src/main/resources/data/pets/pet_complete.json");
        elvis.attemptsTo(
                Create.aNewPetWithDataFrom(jsonBody)

        );
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The name of the pet should be Rocco",
                        response -> response.body("name",
                                CoreMatchers.is("Rocco")))
        );

        elvis.attemptsTo(
                Find.petByID(11)
        );

        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The pet name should be equals",
                        response -> response.body("name",
                                equalTo("Rocco")))
        );
    }

    @Test
    public void should_petBeCreatedWithID_when_sendsPetDataWithoutTheField_ID() throws IOException {

        String jsonBody = generateStringFromResource("src/main/resources/data/pets/pet_without_id.json");
        elvis.attemptsTo(
                Create.aNewPetWithDataFrom(jsonBody)
        );

        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("Should pet ID be created",
                        response -> response.body("id",
                                Matchers.greaterThan(0))),
                seeThatResponse("The name of the pet should be Rocco",
                        response -> response.body("name",
                                Matchers.equalTo("Rocco")))
        );
    }

    @Test
    public void should_petNotBeCreated_when_sendsDataWithoutTheNameField() throws IOException {

        String jsonBody = generateStringFromResource("src/main/resources/data/pets/pet_without_name.json");
        elvis.attemptsTo(
                Create.aNewPetWithDataFrom(jsonBody)
        );

        elvis.should(
                seeThatResponse("Service should response 400",
                        response -> response.statusCode(equalTo(400)))
        );

    }

}
