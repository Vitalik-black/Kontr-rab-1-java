/*Промежуточная контрольная работа по блоку Специализация
Задание 2.
Ваше задание на промежуточную аттестацию. Помните, что это нетолько проверка ваших знаний, но и шанс показать свои навыки!
Входные данные:
Ваш файл `input.txt` содержит множество слов, разделенных пробелами. Это слова-фрукты, овощи и другие продукты.
Представьте, что это ваш виртуальный пикник!
Задания:
        1. Осуществить подсчет слов:
        Напишите программу, которая подсчитывает количество слов в файле `input.txt`.
        2. Найти самое длинное слово:
        Создайте программу, которая находит самое длинное слово в файле.
        3. Вычислить частоту слов:
        Напишите программу, которая анализирует, сколько раз каждое слово встречается в файле. Подумайте об этом как о подсчете того,
какие фрукты и овощи самые популярные на вашем пикнике!
         Не забывайте использовать циклы и коллекции для упрощения ваших задач. Например, `HashMap` может быть очень полезным
        для подсчета частоты слов. Это как иметь корзинку для каждого вида фруктов на пикнике! */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String stroka = new String();
        File myFile = new File("input.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(myFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            stroka = new String(buffer, 0, bytesRead);
            System.out.println("Исходный файл: " + stroka);
            System.out.println();
        }
        inputStream.close();

        String[] text = new String[]{};
        text = stroka.split("\\s+");
        
        Map<String, Integer> dlina = new HashMap<>();
        for (String i : text) {
            dlina.putIfAbsent(i, i.length());
        }
        ArrayList<Integer> valueList = new ArrayList<>(dlina.values());
        Integer maxdlina = Collections.max(valueList);
        String maxslovo = null;
        for (String i : text) {
            if (i.length() == maxdlina) maxslovo = i;
        }

        Map<String, Integer> chastota = new HashMap<>();
        for (String i : text) {
            if (chastota.containsKey(i)) {
                chastota.put(i, chastota.get(i) + 1);
            } else {
                chastota.put(i, 1);
            }
        }
        ArrayList<Integer> valueList2 = new ArrayList<>(chastota.values());
        Integer indexchastoeslovo = Collections.max(valueList2);
        String chastoeslovo = null;
        for (var item : chastota.entrySet()) {
            if (item.getValue() == indexchastoeslovo) chastoeslovo = item.getKey();
        }

        System.out.println("Ассортимент для пикника из: " + text.length + " продуктов. \n" +
                "Самое длинное название из них это - " + maxslovo + ". \n" +
                "Самый популярный продукт на пикнике это - " + chastoeslovo + ". \n");


    }
}