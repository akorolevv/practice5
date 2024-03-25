package com.example.practice5;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private RecyclerView recyclerView; // Приватное поле для RecyclerView
    private ArrayList<Dataitem> dataItems; //  список элементов данных
    private CustomAdapter adapter; // адаптер

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        recyclerView = findViewById(R.id.recyclerView); // Инициализация RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Установка LayoutManager для RecyclerView

        // Генерация тестовых данных
        dataItems = new ArrayList<>(); // Создание нового ArrayList
        dataItems.add(new Dataitem(R.drawable.scale_1200, "Item 1")); // Добавление картинки
        dataItems.add(new Dataitem(0, "Текстовое поле 1")); // Добавление текста
        dataItems.add(new Dataitem(0, "Текстовое поле 2"));
        dataItems.add(new Dataitem(0, "Текстовое поле 3"));

        adapter = new CustomAdapter(dataItems); // Создание адаптера
        recyclerView.setAdapter(adapter);   // Установка адаптера для RecyclerView
    }
}
