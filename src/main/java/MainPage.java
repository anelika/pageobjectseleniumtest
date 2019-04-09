import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import sun.rmi.runtime.Log;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {  //Alt+Ins - создаем конструктор класса
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@href=\"/login\"]"); //описываем основные элементы mainpage
    private By signUpButton = By.xpath("//a[text()=\"Sign up\"]");
    private By userNameField = By.xpath("//*[@id=\"user[login]\"]");
    private By emailField = By.xpath("//*[@id=\"user[email]\"]");
    private By passwordField = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpFormButton = By.xpath("//div[@class=\"rounded-1 text-gray bg-gray-light py-4 px-4 px-md-3 px-lg-4\"]//button[text()=\"Sign up for GitHub\"]");

    public LoginPage clickSignIn(){     //при нажатии на кнопку Sign In метод будет возвращать объект LoginPage и передает туда драйвер
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton(){     //при нажатии на кнопку Sign Un метод будет возвращать объект SignUpPage и передает туда драйвер
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username){    //вводим username и остаемся на странице
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public MainPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage register(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }

}
