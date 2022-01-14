package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class PetByID implements Task {

    private final int id;

    public PetByID(int id) {
        this.id = id;
    }

    @Step("{0} calls the endpoint #endpoint by GET method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(String.format(EndPoints.GET_PET_BY_ID.path(),id))
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON)
                        )
        );
    }


}
