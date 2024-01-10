package AndroidTest;


import Pages.HomePage;

import Pages.LebloomGuestPage;

import Utility.BrowserUtility;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;


public class AndroidTest {
  AndroidDriver driver = BrowserUtility.getAndroidDriver();
  HomePage homePage = new HomePage(driver);
  LebloomGuestPage guestPage = new LebloomGuestPage(driver);

  @Test (priority = 1)
  public void ValidateSearchIconOnHomepage()
  {
    Assert.isTrue(homePage.ValidateSearchPresent(),"Search bar is not displayed");
  }

  @Test (priority = 2)
  public void clickOnSearchIconOnHomepage()
  {
   homePage.clickOnSearchBar();
  }

  @Test (priority = 3)
  public void clickOnTime()
  {
    homePage. selectDate();
    homePage.clickOnTimeBtn();
    homePage.setTimeOnClock();
  }


}


