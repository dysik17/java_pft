package ru.stqa.pft.sandbox;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class SquareTests {

  @Test
  public void testArea(){
    Square s = new Square(5);
    Assertions.assertEquals(s.area(), 25.0);

  }
}
