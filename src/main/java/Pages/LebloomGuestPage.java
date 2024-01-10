package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LebloomGuestPage extends BasePage{

    public LebloomGuestPage(AndroidDriver driver)
    {super(driver);}
    @AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Studio\"]")
    public WebElement StudioIcon;
      public void clickOnGuestIcon()
    {
        StudioIcon.click();

    }

}
