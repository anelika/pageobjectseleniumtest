import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class=\"setup-header setup-org\"]/h1");
    private By userNameField = By.xpath("//*[@id=\"user_login\"]");
    private By emailField = By.xpath("//*[@id=\"user_email\"]");
    private By passwordField = By.xpath("//*[@id=\"user_password\"]");
    private By signUpButton = By.xpath("//*[@id=\"signup_button\"]");
    private By mainError = By.xpath("//div[contains(text(), \"There were problems creating your account.\")]");
    private By userNameError = By.xpath("//*[@id=\"user_login\"]/following-sibling::p");
    private By emailError = By.xpath("//*[@id=\"user_email\"]/ancestor::dd/following-sibling::dd");
    private By passwordError = By.xpath("//*[@id=\"user_password\"]/following-sibling::p");

    public SignUpPage typeUserName(String username){    //вводим username и остаемся на странице
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typePassword(password);
        this.typeEmail(email);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText(){
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement(userNameError).getText();
    }

    public String getPasswordErrorText(){
        return driver.findElement(passwordError).getText();
    }

    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }




}
