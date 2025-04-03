package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRent {
    private WebDriver driver;

    // локатор для поля "Дата"
    private By fieldDate = By.xpath(".//*[@placeholder='* Когда привезти самокат']");

    // локатор для поля "Срок"
    private By fieldPeriod = By.xpath(".//*[text() ='* Срок аренды']");

    // локатор для поля "Комментарий"
    private By fieldComment = By.xpath(".//*[@placeholder='Комментарий для курьера']");

    // локатор для кнопки "Заказать"
    private By buttonOrder = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы "Про аренду"
    public void waitForLoadAboutRentData() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(fieldDate)));
    }

    // метод заполнения поля "Дата"
    public void setFieldDate(String date) {
        driver.findElement(fieldDate).click();
        driver.findElement(By.xpath(".//*[@aria-label = '" + date + "']")).click();
    }

    // метод заполнения поля "Срок"
    public void setFieldPeriod(String period) {
        driver.findElement(fieldPeriod).click();
        driver.findElement(By.xpath(".//*[text() = '" + period + "']")).click();
    }

    // метод заполнения поля "Цвет"
    public void setFieldColor(String color) {
        driver.findElement(By.xpath(".//*[text() = '" + color + "']")).click();
    }

    // метод заполнения поля "Комментарий"
    public void setFieldComment(String comment) {
        driver.findElement(fieldComment).sendKeys(comment);
    }

    // метод для клика по кнопке "Заказать"
    public void clickOrder() {
        driver.findElement(buttonOrder).click();
    }

    // шаг объединяющий все методы
    public void fullOutTheFormAboutRentScooter(String date, String period, String color, String comment) {
        waitForLoadAboutRentData();
        setFieldDate(date);
        setFieldPeriod(period);
        setFieldColor(color);
        setFieldComment(comment);
        clickOrder();
    }
}
