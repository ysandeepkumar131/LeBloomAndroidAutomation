package Pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utility.ConfigFileReader;
public class SignUpUI extends BasePage {

    protected AndroidDriver driver;

    public SignUpUI(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    ConfigFileReader prop = new ConfigFileReader();
    String phone = prop.getConfigPropertyVal("phoneNo");

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Explore as Guest\"]")
    private WebElement ExploreAsGuest;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Sign up\"]")
    private WebElement signUpBtn;

    @FindBy(xpath = "\t\n" + "//android.view.View[@content-desc=\"Shall we sign you up?\"]")
    private WebElement ConfirmationMsg;

    @FindBy(xpath = "//android.view.View[@content-desc=\"\uD83C\uDDEE\uD83C\uDDF3\n" + "+91\"]")
    private WebElement countryDropDwn;
    //android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]\n" + "    ")
    private WebElement phoneNoTextField;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]")
    private WebElement CheckBox;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Send OTP\"]")
    private WebElement SendOTPBtn;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    private WebElement InvalidOTP;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Incorrect Code\"]")
    private WebElement IncorrectOTPErrorMsg;
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]")
    private WebElement leBloomLogo;
    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Terms of Use & Privacy\"]")
    private  WebElement TAndCTextValidation;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Resend Code\"]")
    private WebElement incorrectCodeMessageValidate;

    @FindBy (xpath="//android.widget.ImageView[@content-desc=\"Hi, Sandeep\n" + "Loyalty Points 0\n" + "POPULAR SALONS\n" + "See all\"]")
    private WebElement homePageWelcomeMsg;
    @FindBy(xpath="//android.view.View[@content-desc=\"Continue\"]")
    private WebElement continueBtnAfterOTPPage;
    public void validateUIElements()
    {

        boolean leBloomWebElement=leBloomLogo.isDisplayed();
        Assert.isTrue(leBloomWebElement,"LeBloom Logo is not displayed on SignUp Page");
        Assert.isTrue(TAndCTextValidation.getAttribute("content-desc").equalsIgnoreCase("Terms of Use & Privacy"),"Terms and Conditions statement not found ");
        Assert.isTrue(ExploreAsGuest.getAttribute("content-desc").equalsIgnoreCase("Explore as Guest"),"Explore as Guest not found");
        Assert.isTrue(SendOTPBtn.getAttribute("content-desc").equalsIgnoreCase("Send OTP"),"Send OTp button is missing");
    }

    public String signUpAction() {
        ExploreAsGuest.click();
        System.out.println(ConfirmationMsg.getAttribute("content-desc")  );
      return ConfirmationMsg.getAttribute("content-desc");

    }

    public void captureOTPFromNotification()
    {
        driver.openNotifications();
    }
    public void signUPBtnClick() {
        signUpBtn.click();
        // countryDropDwn.click();
    }

    public void enterValidPhoneNo() throws InterruptedException {
        phoneNoTextField.click();
        phoneNoTextField.sendKeys(phone);
        phoneNoTextField.clear();
//              for(int i=0;i<phone.length();i++){
//                char ch =phone.charAt(i);
//            phoneNoTextField.sendKeys(ch+"");
//            Thread.sleep(100);
//            }
        //Thread.sleep(3000);
        // Thread.sleep(500);
//            phoneNoTextField.click();
        //phoneNoTextField.sendKeys(phone);
//            phoneNoTextField.isEnabled();
        phoneNoTextField.sendKeys(phone);

    }
    public boolean sendOTPBtnDisable() {
        if (phone.length() == 0||phone.length()<10) {
            return SendOTPBtn.isEnabled();
        }
        else{
            return true;
        }
    }
    public void clickOnSendOtpBtn() {

        CheckBox.click();
        //Thread.sleep(3000);
        //phoneNoTextField.click();
        try {
            if (phone.length()  == 10 ) {
                if( CheckBox.isEnabled())
                SendOTPBtn.click();
//               else{
//                   System.out.println("Please check this check button");
//                }

            }
            else{
                boolean bl=SendOTPBtn.isEnabled();
                Assert.isTrue(bl,"Send OTP Buttons is disbaled ");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    //check whether this text is present on this Dialog Box or not
    public boolean isConfirmationMsgDisplayed() {
        try {
            boolean blResult = false;
             blResult = ConfirmationMsg.isDisplayed();
            return blResult;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    String invalidPhone = prop.getConfigPropertyVal("InvalidPhone");

    public void sendInvalidPhoneNo() throws InterruptedException {
        phoneNoTextField.click();
        phoneNoTextField.sendKeys(invalidPhone);
        phoneNoTextField.clear();
//              for(int i=0;i<phone.length();i++){
//                char ch =phone.charAt(i);
//            phoneNoTextField.sendKeys(ch+"");
//            Thread.sleep(100);
//            }
        Thread.sleep(3000);
        // Thread.sleep(500);
//            phoneNoTextField.click();
        //phoneNoTextField.sendKeys(phone);
//            phoneNoTextField.isEnabled();
        phoneNoTextField.sendKeys(invalidPhone);
    }

    public boolean invalidPhoneNumberSendOtpBtn() {
        try {
            boolean otpBtn = SendOTPBtn.isEnabled();
            return otpBtn;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void enterInvalidOTP() {
        InvalidOTP.click();
        InvalidOTP.sendKeys(prop.getConfigPropertyVal("InvalidOTPCode"));
    }
    public void enterValidOTP() throws InterruptedException {
        InvalidOTP.clear();
        InvalidOTP.click();
        Thread.sleep(3000);
        continueBtnAfterOTPPage.isDisplayed();
//        String textMsg=homePageWelcomeMsg.getAttribute("content-desc");
//        String wlcomMsg="Hi, Sandeep";
//        textMsg.contains(wlcomMsg);

    }


    public String InvalidOTPErrMsg() throws InterruptedException {
        //System.out.println("test");

        String actualmsg = IncorrectOTPErrorMsg.getAttribute("content-desc");
        //System.out.println("test");
        return actualmsg;
     }
    public boolean resendCode() throws InterruptedException {
        Thread.sleep(3000);
        boolean blIncMessage = false;
         blIncMessage=incorrectCodeMessageValidate.isDisplayed();
        return blIncMessage;
    }

}

