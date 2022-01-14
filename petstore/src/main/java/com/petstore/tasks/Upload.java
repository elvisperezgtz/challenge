package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class Upload implements Task {
private final int id;

    public Upload(int id) {
        this.id = id;
    }

    @Override
    @Step("{0} uploads a pet photo")
    public <T extends Actor> void performAs(T actor) {

        String petImage= "https://misanimales.com/wp-content/uploads/2021/02/hiperplasia-pastor-aleman-768x504.jpg?auto=webp&quality=45&width=3840&crop=16:9,smart,safe";

        actor.attemptsTo(
                Post.to(String.format(EndPoints.UPLOAD_PET_IMAGE.path(),id))
                        .with(requestSpecification ->
                                requestSpecification
                                        .contentType(ContentType.MULTIPART)
                                        .multiPart("file", petImage, "text/html")
                                        .body("{}")

                                )
       );

    }
    public static Upload petImage(int id){
        return Tasks.instrumented(Upload.class, id);
    }
}
