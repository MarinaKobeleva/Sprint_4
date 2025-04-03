package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    @RunWith(Parameterized.class)
    public class SuccessfulOrderCreationTest {
        private final String name;
        private final String surname;
        private final String address;
        private final String station;
        private final String phoneNumber;
        private final String date;
        private final String period;
        private final String color;
        private final String comment;
        private WebDriver driver;

        public SuccessfulOrderCreationTest(String name, String surname, String address, String station, String phoneNumber, String date, String period, String color, String comment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.station = station;
            this.phoneNumber = phoneNumber;
            this.date = date;
            this.period = period;
            this.color = color;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getData() {
            return new Object[][] {
                    {"Оля", "Иванова", "ул. Прибрежная, д.56, кв.2", "Сокольники", "89279586458", "Choose среда, 30-е апреля 2025 г.", "трое суток", "чёрный жемчуг", "без комментариев"},
                    {"Анна", "Дурова", "ул. Земская, д.149, кв.34", "Черкизовская", "89278465234", "Choose понедельник, 21-е апреля 2025 г.", "сутки", "серая безысходность", "без комментариев"},
            };
        }

        @After
        public void quitDriver() {
            driver.quit();
        }

        @Test
        public void checkSuccessfulOrderWithTopButtonInChrome() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePageScooter homePage = new HomePageScooter(driver);
            homePage.waitAndAcceptCookie();
            homePage.clickOnTopButtonOrder();
            WhoCreateOrderScooter whoCreateOrder = new WhoCreateOrderScooter(driver);
            whoCreateOrder.fullOutTheFormWhoOrderScooter(name, surname, address, station, phoneNumber);
            AboutRent aboutRent = new AboutRent(driver);
            aboutRent.fullOutTheFormAboutRentScooter(date, period, color, comment);
            OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
            orderConfirmation.waitForLoadAboutRentDataAndClickYes();
            SuccessfulOrderCreationMessage successfulOrder = new SuccessfulOrderCreationMessage(driver);
            String result = successfulOrder.waitForLoadAndGetMessage();
            String message = "Посмотреть статус";
            Assert.assertEquals("Ошибка при оформлении заказа", message, result);
        }

        @Test
        public void checkSuccessfulOrderWithTopButtonInFireFox() {
            driver = new FirefoxDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePageScooter homePage = new HomePageScooter(driver);
            homePage.waitAndAcceptCookie();
            homePage.clickOnTopButtonOrder();
            WhoCreateOrderScooter whoCreateOrder = new WhoCreateOrderScooter(driver);
            whoCreateOrder.fullOutTheFormWhoOrderScooter(name, surname, address, station, phoneNumber);
            AboutRent aboutRent = new AboutRent(driver);
            aboutRent.fullOutTheFormAboutRentScooter(date, period, color, comment);
            OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
            orderConfirmation.waitForLoadAboutRentDataAndClickYes();
            SuccessfulOrderCreationMessage successfulOrder = new SuccessfulOrderCreationMessage(driver);
            String result = successfulOrder.waitForLoadAndGetMessage();
            String message = "Посмотреть статус";
            Assert.assertEquals("Ошибка при оформлении заказа", message, result);
        }

        @Test
        public void checkSuccessfulOrderWithBottomButtonInChrome() {
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePageScooter homePage = new HomePageScooter(driver);
            homePage.waitAndAcceptCookie();
            homePage.clickOnBottomButtonOrder();
            WhoCreateOrderScooter whoCreateOrder = new WhoCreateOrderScooter(driver);
            whoCreateOrder.fullOutTheFormWhoOrderScooter(name, surname, address, station, phoneNumber);
            AboutRent aboutRent = new AboutRent(driver);
            aboutRent.fullOutTheFormAboutRentScooter(date, period, color, comment);
            OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
            orderConfirmation.waitForLoadAboutRentDataAndClickYes();
            SuccessfulOrderCreationMessage successfulOrder = new SuccessfulOrderCreationMessage(driver);
            String result = successfulOrder.waitForLoadAndGetMessage();
            String message = "Посмотреть статус";
            Assert.assertEquals("Ошибка при оформлении заказа", message, result);
        }

        @Test
        public void checkSuccessfulOrderWithBottomButtonInFireFox() {
            driver = new FirefoxDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            HomePageScooter homePage = new HomePageScooter(driver);
            homePage.waitAndAcceptCookie();
            homePage.clickOnBottomButtonOrder();
            WhoCreateOrderScooter whoCreateOrder = new WhoCreateOrderScooter(driver);
            whoCreateOrder.fullOutTheFormWhoOrderScooter(name, surname, address, station, phoneNumber);
            AboutRent aboutRent = new AboutRent(driver);
            aboutRent.fullOutTheFormAboutRentScooter(date, period, color, comment);
            OrderConfirmation orderConfirmation = new OrderConfirmation(driver);
            orderConfirmation.waitForLoadAboutRentDataAndClickYes();
            SuccessfulOrderCreationMessage successfulOrder = new SuccessfulOrderCreationMessage(driver);
            String result = successfulOrder.waitForLoadAndGetMessage();
            String message = "Посмотреть статус";
            Assert.assertEquals("Ошибка при оформлении заказа", message, result);
        }
    }

