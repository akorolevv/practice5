package com.example.practice5;

public class Dataitem
{
    private int imageResource; // Приватное поле для хранения ресурса изображения
    private String text; // Приватное поле для хранения текста

    public Dataitem(int imageResource, String text)
    {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() // Геттер для получения ресурса изображения
    {
        return imageResource;
    }

    public String getText() // Геттер для получения текста
    {
        return text;
    }
}

