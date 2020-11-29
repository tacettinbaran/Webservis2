package com.baran.webservis2;

import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.baran.webservis2.Adapter.TodosAdapter;
import com.baran.webservis2.Models.TodosModel;
import com.baran.webservis2.RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<TodosModel> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istekAt();
    }

    public void tanimla(){
        listView = findViewById(R.id.listview);
    }

    public void istekAt() {

        Call<List<TodosModel>> istek = ManagerAll.getInstance().getTodos();
        list = new ArrayList<>();

        istek.enqueue(new Callback<List<TodosModel>>() {

            @Override
            public void onResponse(Call<List<TodosModel>> call, Response<List<TodosModel>> response) {
                if (response.isSuccessful()){
                    list = response.body();
                    TodosAdapter todosAdapter = new TodosAdapter(list,getApplicationContext());
                    listView.setAdapter(todosAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<TodosModel>> call, Throwable t) {

            }
        });
    }
}