package Pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    protected AndroidDriver driver;
    public HomePage(AndroidDriver driver) {
        super(driver);
       // this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Search for salon and services\"]")
   private WebElement SearchBar;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Time\n" +"--:--\"]")
    private WebElement TimeIcon;

    @FindBy(xpath="//android.widget.SeekBar[@content-desc=\"Select hours 2\"]")
    private WebElement TimeSetForHour;

    @FindBy(xpath="//android.widget.SeekBar[@content-desc=\"Select minutes 21\"]")
    private WebElement TimeSetForMinute;

    @FindBy(xpath="//android.widget.RadioButton[@content-desc=\"AM\"]")
    private WebElement selectPMtoAM;

    @FindBy(xpath="//android.widget.RadioButton[@content-desc=\"PM\"]")
    private WebElement selectAMtoPM;

    @FindBy(xpath="//android.widget.Button[@content-desc=\"OK\"]")
    private WebElement clickOnOk;


    @FindBy(xpath="\t\n" + "//android.view.View[@content-desc=\"Search\"]\n")
    private WebElement clickOnSearch;

    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Date\n" +"02/01/2024\"]")
    private WebElement clickOnCalender;

    @FindBy(xpath="//android.view.View[@content-desc=\"8\"]")
    private WebElement ChooseDate;

    @FindBy(xpath="//android.view.View[@content-desc=\"Done\"]")
    private WebElement ClickOnDone;
    public boolean ValidateSearchPresent()
    {
        boolean blResult = false;
        blResult=  SearchBar.isDisplayed();
        return blResult;

    }

    public void clickOnSearchBar()
    {
      SearchBar.click();

    }

    public void clickOnTimeBtn()
    {
        TimeIcon.click();
    }

    public void selectDate()
    {
        clickOnCalender.click();
        ChooseDate.click();
        ClickOnDone.click();
    }
    public void setTimeOnClock()
    {
//        TimeSetForHour.click();
//        TimeSetForMinute.click();
//        selectPMtoAM.click();
        clickOnOk.click();
        clickOnSearch.click();
    }

}