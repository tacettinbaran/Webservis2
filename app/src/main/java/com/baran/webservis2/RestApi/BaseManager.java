package com.baran.webservis2.RestApi;

public class BaseManager {

    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.BASE_URL);

        return restApiClient.getRestApi();
    }
}
