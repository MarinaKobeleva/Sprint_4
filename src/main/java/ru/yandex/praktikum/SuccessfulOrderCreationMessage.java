package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulOrderCreationMessage {
    private WebDriver driver;

    // локатор кнопки "Посмотреть статус"
    private By statusOrderButton = By.xpath(".//*[text()='Посмотреть статус']");

    public SuccessfulOrderCreationMessage(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы "Заказ оформлен"
    public String waitForLoadAndGetMessage() {
        return new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(statusOrderButton))).getText();
    }
}
