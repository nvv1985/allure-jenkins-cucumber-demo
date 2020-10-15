import Pages.BooksSite;
import Pages.MainPage;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class TestMy {
    WebDriver webdriver = new ChromeDriver();
    BooksSite website;

    @Before
    public void setUp() {
        website = new BooksSite(webdriver);

        webdriver.get("http://it-ebooks.info/");
        System.out.println("Шаг 1: Вводим текст поиска");
        website.mainPage().enterSearchableText("Automation");
        System.out.println("Шаг 2: Нажимаем кнопку поиска");
        website.mainPage().clickSearchBtn();
        System.out.println("Шаг 3: Ожидние загрузки результатов");
        website.searckResultPage().waitForSearchResults();
    }

    @Test
    public void testSearchBookUrl() {
        System.out.println("Проверка URL");
        assertTrue(webdriver.getCurrentUrl().contains("https://it-ebooks-search.info/search?q=Automation"));

    }

    @Test
    public void testBooksSearch() {
        System.out.println("Проверка результатов поиска по количеству");
        assertEquals(10, webdriver.findElements(By.cssSelector(".gsc-webResult.gsc-result")).size());
    }

    @Test
    public void testOpenBookInfoFromSearch(){
        System.out.println("Открытие информации о книге");
        website.searckResultPage().openBookFromResultsBy("Cookbook - Free Download : PDF - Price");
        //System.out.println("Ожидание загрузки информации");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("desc")));
    }

    @After
    public void tearDown() {
        if (webdriver != null)
            webdriver.quit();
    }
}



