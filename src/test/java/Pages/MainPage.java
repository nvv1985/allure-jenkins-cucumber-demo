package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(id = "q")
    WebElement searchInputField;

    @FindBy (css = "input[type='submit']")
    WebElement searchBtn;


    public MainPage(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(webDriver,30);
        PageFactory.initElements(webDriver, this);
    }

    public void enterSearchableText(String text){
        searchInputField.clear();
        searchInputField.sendKeys(text);
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

}
