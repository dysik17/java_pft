package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().editGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("TEST1", "TEST2", "TEST3"));
    app.getGroupHelper().updateGroupModification();
    app.getGroupHelper().submitGroupCreation();
  }
}
