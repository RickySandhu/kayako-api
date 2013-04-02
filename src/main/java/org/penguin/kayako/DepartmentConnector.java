package org.penguin.kayako;

import org.penguin.kayako.ApiRequest.ApiRequestException;
import org.penguin.kayako.ApiResponse.ApiResponseException;

public class DepartmentConnector {
    private final KayakoClient client;
    
    public DepartmentConnector(KayakoClient client) {
        this.client = client;
    }
    
    public Department get(int id) throws ApiResponseException, ApiRequestException {
        return new ApiRequest(client)
                .withPath("Base").withPath("Department")
                .withPath(String.valueOf(id))
                .get().as(DepartmentCollection.class).getDepartments().get(0);
    }
}