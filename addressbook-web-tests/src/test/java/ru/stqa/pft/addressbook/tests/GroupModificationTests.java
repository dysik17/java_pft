package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().editGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData(null, "Testik2", "Testik3"));
    app.getGroupHelper().updateGroupModification();
    app.getGroupHelper().submitGroupCreation();
  }
}
