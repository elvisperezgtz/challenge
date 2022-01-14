package com.petstore.tasks;

import net.serenitybdd.screenplay.Tasks;

public class Find {
    public static PetByID petByID(int id){
        return Tasks.instrumented(PetByID.class, id);
    }
    public static PetByTags petByTags(String tags){
        return Tasks.instrumented(PetByTags.class, tags);
    }
    public static PetByStatus petByStatus(String status){
        return Tasks.instrumented(PetByStatus.class,status);
    }

    public static OrderByID orderByID(int id){
        return Tasks.instrumented(OrderByID.class,id);
    }

    public static UserByUsername userByUsername(String username) {
        return Tasks.instrumented(UserByUsername.class, username);
    }
}
