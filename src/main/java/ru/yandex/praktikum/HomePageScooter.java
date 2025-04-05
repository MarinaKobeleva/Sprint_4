package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageScooter {
    private WebDriver driver;

    // локатор для списка вопросов
    private By listQuestion = By.className("accordion__button");

    // локатор для ответа на вопрос
    private By answer = By.className("accordion__panel");

    // локатор для кнопки "Заказать" сверху
    private By topButtonOrder = By.className("Button_Button__ra12g");

    // локатор для кнопки "Заказать" снизу
    private By bottomButtonOrder = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    // локатор для куки
    private By cookieButton = By.className("App_CookieButton__3cvqF");


    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки домашней страницы
    public void waitForLoadHomePageData() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(topButtonOrder)));
    }

    // метод для принятия куки
    public void acceptCookie() {
        driver.findElement(cookieButton).click();
    }

    //метод для скролла к вопросам
    public void scrollToQuestion() {
        WebElement question = driver.findElement(listQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
    }

    // метод для клика по кнопке вопроса
    public void clickOnButtonWithQuestion(String question) {
        driver.findElement(By.xpath(".//*[text() = '" + question + "']")).click();
    }

    // метод для вывода текста ответа на вопрос
    public String getTextAnswer(String answer) {
        WebElement element = driver.findElement(By.xpath(".//*[text() = '" + answer + "']"));
        return element.getText();
    }

    // шаг: при нажатии на стрелочку открывается ответ на вопрос
    public String clickOnQuestionAndGetAnswer(String question, String answer) {
        waitForLoadHomePageData();
        acceptCookie();
        scrollToQuestion();
        clickOnButtonWithQuestion(question);
        return getTextAnswer(answer);
    }

    // метод для клика по ВЕРХНЕЙ кнопке "Заказать"
    public void clickOnTopButtonOrder() {
        driver.findElement(topButtonOrder).click();
    }

    // метод для клика по НИЖНЕЙ кнопке "Заказать"
    public void clickOnBottomButtonOrder() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomButtonOrder));
        driver.findElement(bottomButtonOrder).click();
    }

    // шаг: при нажатии на стрелочку открывается ответ на вопрос
    public void waitAndAcceptCookie() {
        waitForLoadHomePageData();
        acceptCookie();
    }





}

