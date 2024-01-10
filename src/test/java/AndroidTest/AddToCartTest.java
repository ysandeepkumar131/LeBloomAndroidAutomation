package AndroidTest;

import Pages.AddTocart;
import Pages.HomePage;
import Pages.LebloomGuestPage;
import Utility.BrowserUtility;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class AddToCartTest {
    AndroidDriver driver = BrowserUtility.getAndroidDriver();
    HomePage homePage = new HomePage(driver);
    LebloomGuestPage guestPage = new LebloomGuestPage(driver);

    AddTocart AddTo=new AddTocart(driver);

    @Test
    public void runAddToCartTest()
    {
        AddTo.ClickOnPopularSalons();
    }

}
