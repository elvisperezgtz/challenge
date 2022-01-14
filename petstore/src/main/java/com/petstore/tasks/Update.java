package com.petstore.tasks;

import net.serenitybdd.screenplay.Tasks;

public class Update {
    public static PetInformation petInformationWithInfo(String jsonBody){
        return Tasks.instrumented(PetInformation.class, jsonBody);
    }
}
