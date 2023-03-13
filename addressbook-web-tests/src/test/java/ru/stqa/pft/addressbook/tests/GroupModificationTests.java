package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Testik1", null, null));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().editGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData(null, "Testik2", "Testik3"));
    app.getGroupHelper().updateGroupModification();
    app.getGroupHelper().submitGroupCreation();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
