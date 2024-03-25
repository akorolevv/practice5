package com.example.practice5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    ArrayList<String> elements_of_category = new ArrayList<String>();
    ArrayList<String> selectedElements = new ArrayList<String>();
    ArrayAdapter<String> elementsAdapter;
    ListView elementsListView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Получаем переданные данные о категории из Intent
        String category = getIntent().getStringExtra("category");

        // Используем соответствующий массив строк в зависимости от категории

        int categoryId = -1;
        if (category != null)
        {
            if (category.equals(getString(R.string.category_fruits)))
            {
                categoryId = R.array.frukty;
            }
            else if (category.equals(getString(R.string.category_milks)))
            {
                categoryId = R.array.molochka;
            }
            else if (category.equals(getString(R.string.category_meat)))
            {
                categoryId = R.array.myaso;
            }
            else if (category.equals(getString(R.string.category_beverages)))
            {
                categoryId = R.array.napitki;
            }
            else if (category.equals(getString(R.string.category_vegetables)))
            {
                categoryId = R.array.ovoschi;
            }
        }

        // Если категория определена, заполняем список элементами выбранной категории
        if (categoryId != -1)
        {
            String[] categoryItems = getResources().getStringArray(categoryId); // Получение массива строк из ресурсов
            elements_of_category.addAll(Arrays.asList(categoryItems)); // Добавление всех элементов массива в список
        }

        elementsListView = findViewById(R.id.my_list_view);  // Инициализация ListView по идентификатору
        elementsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, elements_of_category); // Создание адаптера для ListView
        elementsListView.setAdapter(elementsAdapter);

        elementsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String user = elementsAdapter.getItem(position);
                if (elementsListView.isItemChecked(position)) {
                    selectedElements.add(user);
                } else {
                    selectedElements.remove(user);
                }
            }
        });
    }

    public void add(View view)
    {
        EditText userName = findViewById(R.id.userName);
        String user = userName.getText().toString();
        if(!user.isEmpty())
        {
            elementsAdapter.add(user);
            userName.setText("");
            elementsAdapter.notifyDataSetChanged();
        }
    }

    public void remove(View view)
    {
        // Получаем и удаляем выделенные элементы
        for(int i=0; i< selectedElements.size();i++)
        {
            elementsAdapter.remove(selectedElements.get(i));
        }

        // Снимаем все ранее установленные отметки
        elementsListView.clearChoices();

        // Очищаем массив выбранных объектов
        selectedElements.clear();
        elementsAdapter.notifyDataSetChanged();
    }
}
