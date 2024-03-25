package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView categoriesView = (ListView) findViewById(R.id.my_list_view); // Инициализация categoriesView типа ListView
        String[] categoriesNames = getResources().getStringArray(R.array.categories); // Получение массива строк из ресурсов

        // Создание адаптера ArrayAdapter для отображения данных в ListView
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categoriesNames);
        categoriesView.setAdapter(categoriesAdapter); // Установка адаптера для ListView

        categoriesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // Создание нового объекта Intent для перехода на SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Добавление дополнительной информации в Intent о выбранной категории
                intent.putExtra("category", categoriesNames[position]);


                startActivity(intent);
            }
        });

    }
}