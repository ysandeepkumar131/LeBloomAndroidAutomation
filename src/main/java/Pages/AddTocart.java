package Pages;
import Pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTocart extends BasePage {

    AndroidDriver driver;
   public  AddTocart(AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @FindBy(xpath="//android.view.View[@content-desc=\"Recommended\n" + "4.5\n" + "POPULAR SALON GURGRAM 2\n" +
            "Sector 71\"]/android.widget.ImageView[1]")
    private WebElement PopularSalonCategory;

   @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Hair Female\"]")
   private WebElement SelectCategoryMorF;

    @FindBy(xpath="//android.view.View[@content-desc=\"Haircut(Finish + Blow Dry)\n" + "INR 1999\n" +
            "Onwards\n" + "30 Min\n" + "Add\"]")
    private WebElement SelectCategoryFemaleHair;


    public void ClickOnPopularSalons()
   {
       PopularSalonCategory.click();
       SelectCategoryMorF.click();
       SelectCategoryFemaleHair.click();
   }
}
