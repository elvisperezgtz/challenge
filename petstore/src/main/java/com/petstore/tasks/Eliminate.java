package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.petstore.enums.EndPoints.STORE_ORDER;

public class Eliminate implements Task {
    private final int id;

    public Eliminate(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(STORE_ORDER.path().concat(String.valueOf(id)))
                .with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)

                )
        );
    }
    public static Eliminate orderWithID(int id){
        return Tasks.instrumented(Eliminate.class,id);
    }
}
