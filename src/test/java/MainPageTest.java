import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){  //всегда вначале инициализируем наш драйвер и навстраиваем окно для тестов, перед каждым тестом
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){  //метод, проверяющий заголовок страницы соответствует, ожидаемому
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){  //проверка, что попадаем на страницу signUpPage и видим там еррор
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpassword");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){  //пробуем сайнап с пустым юзернейм
        SignUpPage signUpPage = mainPage.register("", "testemail", "testpassword");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmail(){  //пробуем сайнап с инвалид email
        SignUpPage signUpPage = mainPage.register("testuser", "qweq", "testpassword");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
