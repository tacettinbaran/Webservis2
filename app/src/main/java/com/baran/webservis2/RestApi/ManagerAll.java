package com.baran.webservis2.RestApi;

import com.baran.webservis2.Models.TodosModel;
import retrofit2.Call;

import java.util.List;

public class ManagerAll extends BaseManager {


    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {
        return ourInstance;
    }

    public Call<List<TodosModel>> getTodos(){
        Call<List<TodosModel>> call = getRestApiClient().todosGetir();
        return call;
    }
}
