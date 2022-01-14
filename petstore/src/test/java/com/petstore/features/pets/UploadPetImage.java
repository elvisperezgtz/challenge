package com.petstore.features.pets;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Upload;
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
@Narrative(text = {"As a PetStore user",
        "I want to be able to upload a pet image",
        "in order to update all the relevant pet info"})

@WithTagValuesOf({"pets", "uploadImage"})
public class UploadPetImage extends BaseConf {
    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_notUploadTheImage_when_submitAnInvalidFileType (){

        elvis.attemptsTo(Upload.petImage(900));
        elvis.should(
                seeThatResponse("Service should response 415",
                        response -> response.statusCode(is(415))),
                seeThatResponse("The response body",
                        response -> response.body("message",
                                Matchers.equalTo("HTTP 415 Unsupported Media Type")))
        );

    }

}
