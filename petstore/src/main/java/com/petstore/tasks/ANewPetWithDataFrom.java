package com.petstore.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.is;

public class ANewPetWithDataFrom implements Task {
    private final String jsonBody;

    public ANewPetWithDataFrom(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NewPet.withDataFrom(jsonBody)
        );

    }
}
