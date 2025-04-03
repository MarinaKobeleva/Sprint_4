package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmation {

    private WebDriver driver;

    // локатор для кнопки "Да"
    private By buttonYes = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы "Хотите оформить заказ?" и клик по кнопке "Да"
    public void waitForLoadAboutRentDataAndClickYes() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(buttonYes))).click();
    }
}
