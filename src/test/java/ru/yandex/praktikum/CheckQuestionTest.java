package ru.yandex.praktikum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class CheckQuestionTest {
    private final String question;
    private final String answer;
    private WebDriver driver;

    public CheckQuestionTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionAndAnswer() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
        };
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void checkAnswerInChrome() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePage = new HomePageScooter(driver);
        String result = homePage.clickOnQuestionAndGetAnswer(question, answer);
        Assert.assertEquals("Ошибка в тексте ответа", answer, result);
        driver.quit();
    }

    @Test
    public void checkAnswerInFireFox() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter homePage = new HomePageScooter(driver);
        String result = homePage.clickOnQuestionAndGetAnswer(question, answer);
        Assert.assertEquals("Ошибка в тексте ответа", answer, result);
        driver.quit();
    }
}