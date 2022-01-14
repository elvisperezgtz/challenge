package com.petstore.tasks;

import com.petstore.enums.EndPoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class LogOut implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(EndPoints.LOGOUT.path())

        );
    }
    public static LogOut ofCurrentSession(){
        return Tasks.instrumented(LogOut.class);
    }
}
