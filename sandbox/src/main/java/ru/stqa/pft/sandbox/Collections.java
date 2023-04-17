package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args){

    //массив
    String[] langs = {"Java", "C#", "Python", "PHP"};

    //список
    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");


    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
  }
}
