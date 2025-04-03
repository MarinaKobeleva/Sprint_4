package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhoCreateOrderScooter {
    private WebDriver driver;

    // локатор для поля "Имя"
    private By fieldName = By.xpath(".//*[@placeholder='* Имя']");

    // локатор для поля "Фамилия"
    private By fieldSurname = By.xpath(".//*[@placeholder='* Фамилия']");

    // локатор для поля "Адрес"
    private By fieldAddress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для поля "Станция метро"
    private By fieldStation = By.xpath(".//*[@placeholder='* Станция метро']");

    // локатор для поля "Телефон"
    private By fieldPhoneNumber = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор для кнопки "Далее"
    private By buttonNext = By.xpath(".//button[text() = 'Далее']");

    public WhoCreateOrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания загрузки страницы "Для кого самокат"
    public void waitForLoadWhoOrderScooterData() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(fieldName)));
    }

    // метод заполнения поля "Имя"
    public void setFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    // метод заполнения поля "Фамилия"
    public void setFieldSurname(String surname) {
        driver.findElement(fieldSurname).sendKeys(surname);
    }

    // метод заполнения поля "Адрес"
    public void setFieldAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    // метод заполнения поля "Станция метро"
    public void setFieldStation(String station) {
        driver.findElement(fieldStation).click();
        driver.findElement(By.xpath(".//*[text() = '" + station + "']")).click();
    }

    // метод заполнения поля "Телефон"
    public void setFieldPhoneNumber(String phoneNumber) {
        driver.findElement(fieldPhoneNumber).sendKeys(phoneNumber);
    }

    //метод для скролла к кнопке "Далее"
    public void scrollToButtonNext() {
        WebElement next = driver.findElement(buttonNext);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", next);
    }

    // метод для клика по кнопке "Далее"
    public void clickNext() {
        driver.findElement(buttonNext).click();
    }

    // шаг объединяющий все методы
    public void fullOutTheFormWhoOrderScooter(String name, String surname, String address, String station, String phoneNumber) {
        waitForLoadWhoOrderScooterData();
        setFieldName(name);
        setFieldSurname(surname);
        setFieldAddress(address);
        setFieldStation(station);
        setFieldPhoneNumber(phoneNumber);
        clickNext();
    }
}
