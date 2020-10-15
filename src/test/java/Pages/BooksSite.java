package Pages;

import org.openqa.selenium.WebDriver;

public class BooksSite {
    WebDriver webDriver;

    public BooksSite(WebDriver driver){
        webDriver = driver;
    }

    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    public SearchResultPage searckResultPage(){ return new SearchResultPage(webDriver);}

}

