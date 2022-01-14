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
        "in order to register all the relevant info"})

@WithTagValuesOf({"pets", "updatePets"})
public class FindPets extends BaseConf {
    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_be() {

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
    public void status_non_existing() {

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
    public void status_existing() {

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
    public void find_pet_with_non_exist_ID() {

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
