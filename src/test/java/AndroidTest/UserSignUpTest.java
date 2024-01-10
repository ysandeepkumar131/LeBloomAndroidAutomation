package AndroidTest;

import Pages.SignUpUI;
import Utility.BrowserUtility;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class UserSignUpTest {
    AndroidDriver driver = BrowserUtility.getAndroidDriver();

    SignUpUI sign = new SignUpUI(driver);


@Test(priority =-1)
public void validateAllElementsPresentOnLoginPage()
{
    sign.validateUIElements();
}

    @Test(priority = 1)
    public void runsignUpUITest() {
        Assert.isTrue(sign.signUpAction().equalsIgnoreCase("Shall we sign you up?"),"Error message not matched");
    }

    @Test(priority = 2)
    public void confirmationDialogBox() {
        Assert.isTrue(sign.isConfirmationMsgDisplayed(), "Search bar is not displayed");
        sign.signUPBtnClick();
    }

    @Test(priority = 3)
    public void sendValidPhoneNumberTest() throws InterruptedException {
        sign.enterValidPhoneNo();
    }

    @Test(enabled = false)
    public void sendInvalidPhoneNumberTest() throws InterruptedException {
        sign.sendInvalidPhoneNo();
        Assert.isTrue(sign.invalidPhoneNumberSendOtpBtn(),"Send OTP Button is Not Visible");

    }
    @Test(priority = 4)
    public void clickOnSendOTP()
    {
        Assert.isTrue(sign.invalidPhoneNumberSendOtpBtn(),"Send OTP Button is disable ");
        sign.clickOnSendOtpBtn();
    }
    @Test(priority = 5)
    public void enterInvalidOTP() throws InterruptedException {
        sign.enterInvalidOTP();
         OTPErrorCodeValidation();
        resendCodeValidation();
    }
    public void OTPErrorCodeValidation() throws InterruptedException {
        String msg=sign.InvalidOTPErrMsg();
        Assert.isTrue(msg.equalsIgnoreCase("Incorrect code"),"incorrect code  ");
       // Assert.isTrue(sign.InvalidOTPErrMsg(),"Error Message is incorrect ");

    }

    public void resendCodeValidation() throws InterruptedException {
        Assert.isTrue(sign.resendCode(),"error message is invalid ");
    }

    @Test(priority = 6)
    public void enterValidOTP() throws InterruptedException {
        sign.enterValidOTP();

    }

}
