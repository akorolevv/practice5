package com.example.practice5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Dataitem> dataItems; // Приватное поле для хранения списка элементов

    public CustomAdapter(ArrayList<Dataitem> dataItems) {
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false); // Создание View из макета list_item
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dataitem item = dataItems.get(position); // Получение элемента из списка по позиции
        holder.imageView.setImageResource(item.getImageResource()); // Установка изображения
        holder.textView.setText(item.getText()); // Установка текста
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    } // Возврат размера списка элементов

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView; // Публичное поле для изображения
        public TextView textView; // Публичное поле для текста

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView); // Инициализация ImageView
            textView = itemView.findViewById(R.id.textView); // Инициализация TextView
        }
    }
}

