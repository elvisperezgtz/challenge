package com.petstore.features.store;

import com.petstore.config.BaseConf;
import com.petstore.tasks.Eliminate;
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

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
@Narrative(text = {"As a PetStore user",
        "I want to be able to create an order",
        "in order to apply for a pet"})
@WithTagValuesOf({"store", "orders"})
public class EliminateAnOrder extends BaseConf {

    Actor elvis;

    @Before
    public void setUp() {
        elvis = theActorCalled("Elvis");
    }

    @Test
    public void should_theOrderDeleted_When_sendAnID() throws IOException {


        elvis.attemptsTo(
                Eliminate.orderWithID(12)
        );
        elvis.should(
                seeThatResponse("Service should response 200",
                        response -> response.statusCode(is(200)))
        );

        elvis.attemptsTo(Find.orderByID(12));
        elvis.should(
                seeThatResponse("Service should response 404",
                        response -> response.statusCode(is(404))),
                seeThatResponse("The order has been eliminated",
                        response -> response.body(
                                Matchers.equalTo("Order not found")))
        );
    }
}
