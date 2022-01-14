package com.petstore.enums;

public enum EndPoints {

        GET_PET_BY_ID("api/v3/pet/%d"),
        PET("api/v3/pet"),
        FIND_PETS_BY_TAGS("api/v3/pet/findByTags?tags={tags}"),
        FIND_PETS_BY_STATUS("api/v3/pet/findByStatus?status={status}"),
        UPLOAD_PET_IMAGE("api/v3/pet/%d/uploadImage"),
        PET_INVENTORY("api/v3/store/inventory"),
        STORE_ORDER("api/v3/store/order/"),
        USER("api/v3/user/"),
        LOGIN("api/v3/user/login?username={username}&password={password}"),
        LOGOUT("api/v3/user/logout"),
        ;

        private final String path;

        EndPoints(String path) {
            this.path = path;
        }

        public String path() {
            return path;
        }
    }