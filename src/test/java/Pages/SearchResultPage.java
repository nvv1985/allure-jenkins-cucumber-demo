package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SearchResultPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public SearchResultPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);
    }

    public void waitForSearchResults(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".gsc-webResult.gsc-result")));
    }

    public void openBookFromResultsBy(String bookTitle) {
        List<WebElement> books = webDriver.findElements(By.cssSelector(".gsc-webResult.gsc-result"));
        for (WebElement book: books){
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getText().contains(bookTitle))
                bookLink.click();
        }
    }
    public WebDriver getWebDriver(String browsertype) {
                return browsertype.contains("Chrome") ? new ChromeDriver(): new FirefoxDriver();
    }
}
