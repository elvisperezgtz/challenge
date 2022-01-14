package com.petstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("tags")
    private List<Category> tags;

    @JsonProperty("status")
    private String status;


}
