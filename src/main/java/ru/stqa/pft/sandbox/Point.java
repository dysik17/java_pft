package ru.stqa.pft.sandbox;

public class Point {
  public static void main(String[] args){

    Distance d = new Distance(3.0, 5.0, 4.0, 8.0);
    System.out.println("Расстояние между двумя точками =  " + d.area());
  }
}
