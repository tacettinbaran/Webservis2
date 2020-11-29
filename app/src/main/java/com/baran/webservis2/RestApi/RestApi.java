package com.baran.webservis2.RestApi;

import com.baran.webservis2.Models.TodosModel;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface RestApi {

    //https://jsonplaceholder.typicode.com/todos

    @GET("/todos")
    Call<List<TodosModel>> todosGetir();
}

