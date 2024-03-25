package com.example.practice5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);

        Spinner spinner = findViewById(R.id.spinner);
        TextView textView = findViewById(R.id.textView);

        // Создайте массив данных для Spinner
        String[] data = {"Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4", "Элемент 5"};

        // Создайте адаптер для Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // макет для отображения выпадающего списка

        // Установите адаптер для Spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // Получите выбранный элемент из Spinner
                String selectedItem = (String) parent.getItemAtPosition(position);
                // Отобразите выбранный элемент в текстовом поле
                textView.setText("Выбранный элемент: " + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
