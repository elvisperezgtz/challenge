package com.petstore.tasks;

import net.serenitybdd.screenplay.Tasks;

public class Create  {

    public static ANewPetWithDataFrom aNewPetWithDataFrom(String jsonBody){
        return Tasks.instrumented(ANewPetWithDataFrom.class,jsonBody);
    }

    public static AnOrderWithInfo anOrderWithInfo(String jsonBody){
        return Tasks.instrumented(AnOrderWithInfo.class,jsonBody);
    }

    public static ANewUserWithInfo aNewUserWithInfo(String jsonBody){
        return Tasks.instrumented(ANewUserWithInfo.class, jsonBody);
    }
}
