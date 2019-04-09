import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//*[@id=\"login_field\"]");  //описание полей страницы
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By signInButton = By.xpath("//input[@type=\"submit\"]");
    private By heading = By.xpath("//div[@class=\"auth-form-header p-0\"]/h1");
    private By error = By.xpath("//*[@id=\"js-flash-container\"]//div[@class=\"container\"]");
    private By createAccLink = By.xpath("//a[text()=\"Create an account\"]");

    public LoginPage typeUsername(String username){  //метод ввода юзернейм
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){      //метод ввода пароля
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds (String username, String password){ //метод ввода инвалид кред для логина
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }





}

