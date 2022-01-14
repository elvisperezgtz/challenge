package com.petstore.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.petstore.enums.EndPoints.STORE_ORDER;

public class OrderByID implements Task {
    private final int id;

    public OrderByID(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(STORE_ORDER.path().concat(String.valueOf(id)))
                .with(requestSpecification ->
                        requestSpecification.contentType(ContentType.JSON)

                )
        );
    }


}
