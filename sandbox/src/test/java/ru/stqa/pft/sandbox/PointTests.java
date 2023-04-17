package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test

  public void distanceTest1() {
    Point p1 = new Point(-0.8, 0.8);
    Point p2 = new Point(0.8, 0.8);
    double distance = p1.distance(p2);
    Assert.assertEquals(distance, 1.6);
  }

  @Test
  public void distanceTest2() {
    Point p1 = new Point(0.4, 0.8);
    Point p2 = new Point(1.1, 3.2);
    double distance = p1.distance(p2);
    Assert.assertEquals(distance, 2.5000000000000004);
  }

  @Test
  public void distanceTest3() {
    Point p1 = new Point(1.5, 2.5);
    Point p2 = new Point(3.5, 3.5);
    double distance = p1.distance(p2);
    Assert.assertEquals(distance, 2.23606797749979);
  }

  @Test
  public void distanceTest4() {
    Point p1 = new Point(8.8, 2.5);
    Point p2 = new Point(3.5, 3.5);
    double distance = p1.distance(p2);
    Assert.assertEquals(distance,5.3935146240647205);
  }

  @Test
  public void distanceTest5() {
    Point p1 = new Point(-9.5, -4.5);
    Point p2 = new Point(0.5, 3.5);
    double distance = p1.distance(p2);
    Assert.assertEquals(distance, 12.806248474865697);
  }
}
