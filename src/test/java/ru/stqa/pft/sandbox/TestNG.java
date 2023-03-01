package ru.stqa.pft.sandbox;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNG {

  @Test
  public void testArea1() {
    Distance d = new Distance(2.0, 2.0, 4.0, 8.0);
    Assertions.assertTrue(d.area() > 0);
    Assertions.assertEquals(d.area(), 7.0);
  }

  @Test
  public void testArea2() {
    Distance d = new Distance(12.2, 5.0, 14.0, 8.0);
    Assertions.assertNotEquals(d.area(), 0);
    Assertions.assertEquals(d.area(), 4.0);
  }

  @Test
  public void testArea3() {
    Distance d = new Distance(0.0, 0.0, 4.0, 8.0);
    Assertions.assertFalse(d.area() < 0);
    Assertions.assertEquals(d.area(), 9.0);
  }
  @Test
  public void testArea4() {
    Distance d = new Distance(-2.0, -5.0, 4.0, 100.0);
    Assertions.assertEquals(d.area(), 106.0);
  }
  @Test
  public void testArea5() {
    Distance d = new Distance(2.0, 5.0, 4.0, 8.0);
    Assertions.assertEquals(d.area(), 4.0);
  }
  @Test
  public void testArea6() {
    Distance d = new Distance(0, 0, 0, 0);
    Assertions.assertFalse(d.area() > 0);
    Assertions.assertEquals(d.area(), 0);
  }
}
