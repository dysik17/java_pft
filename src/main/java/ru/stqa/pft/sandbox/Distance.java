package ru.stqa.pft.sandbox;

public class Distance {
  public double p1;
  public double p2;
  public Distance(double x1, double y1, double x2, double y2) {
    double x = x2 - x1;
    double y = y2 - y1;
    this.p1 = Math.pow(x, 2);
    this.p2 = Math.pow(y, 2);
  }
  public double area() {
    return Math.sqrt(p1 + p2);
  }
}

