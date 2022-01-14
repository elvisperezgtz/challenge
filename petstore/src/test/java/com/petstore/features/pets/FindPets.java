package com.petstore.features.pets;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Find;
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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a PetStore user",
        "I want to be able to find a pet info",
        "in order to get all the relevant info"})

@WithTagValuesOf({"pets", "updatePets"})
public class FindPets extends BaseConf {
    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_PetsBeShow_when_SendsPetTags() {

        elvis.attemptsTo(
                Find.petByTags("string")
        );

        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("Should pet ID be created",
                        response -> response.body("size()", Matchers.greaterThanOrEqualTo(1)))
        );
    }

    @Test
    public void should_serviceResponseBe400_whenPetStatusDoesNotExists() {

        elvis.attemptsTo(
                Find.petByStatus("undefined")
        );

        elvis.should(
                seeThatResponse("Service should response 400",
                        response -> response.statusCode(is(400))),
                seeThatResponse("The response",
                        response -> response.body("message",equalTo("Input error: query parameter `status value `undefined` is not in the allowable values `[available, pending, sold]`"))
                )
        );
    }

    @Test
    public void should_showPetInfo_whenPetStatusDoesExists() {

        elvis.attemptsTo(
                Find.petByStatus("available")
        );

        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The response",
                        response -> response.body("size()", Matchers.greaterThanOrEqualTo(1))
                )
        );
    }

    @Test
    public void should_serviceResponseBe404_whenPetIDDoesNotExists() {

        elvis.attemptsTo(
                Find.petByID(3000)
        );

        elvis.should(
                seeThatResponse("Service should response 404",
                        response -> response.statusCode(is(404))),
                seeThatResponse("The response",
                        response -> response.body( Matchers.equalTo("Pet not found"))
                )
        );
    }
}
