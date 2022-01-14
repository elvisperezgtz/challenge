package com.petstore.features.store;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Create;
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
@Narrative(text = {"As a PetStore user",
        "I want to be able to create an order",
        "in order to apply for a pet"})
@WithTagValuesOf({"store", "orders"})
public class StoreOrders extends BaseConf {

    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_theOrderBeCreated_When_sendOrderInfo() throws IOException {
        String jsonBody = generateStringFromResource("src/main/resources/data/store/store.json");

        elvis.attemptsTo(
                Create.anOrderWithInfo(jsonBody)
        );
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The order most be created",
                        response -> response.body("id",
                                Matchers.equalTo(12)))
        );
        elvis.attemptsTo(Find.orderByID(12));
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200))),
                seeThatResponse("The order is",
                        response -> response.body("id",
                                Matchers.equalTo(12)))
        );

    }
}
