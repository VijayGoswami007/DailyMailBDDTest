package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseClass;

public class FootballPage extends BaseClass {

    private boolean isGalleryOpen = false;

    public FootballPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='nav-primary cleared bdrgr3 cnr5']//a[@href='/sport/index.html']")
    private WebElement sportsLink;

    @FindBy(xpath = "//div[@class='sport nav-secondary-container']//a[@href='/sport/football/index.html']")
    private WebElement footballLink;

    @FindBy(xpath = "//div[@class='article article-tri-headline']//h2/a[1]")
    private WebElement headlineLink;

    @FindBy(xpath = "//div[contains(@class, 'artSplitter')][1]//div[@class='image-wrap']")
    private WebElement galleryButton;

    @FindBy(xpath = "//div[contains(@class, 'paginationButtons')]//button[contains(@class, 'previousButton')]")
    private WebElement prevButton;

    @FindBy(xpath = "//div[contains(@class, 'paginationButtons')]//button[contains(@class, 'nextButton')]")
    private WebElement nextButton;

    @FindBy(xpath = "//div[contains(@class, 'galleryWrapper')][1]//button[contains(@class,'closeButton')]")
    private WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class, 'artSplitter')][1]//li[contains(@class,'shareIcon')]")
    private WebElement shareicon;
    @FindBy(xpath = "//div[contains(@class, 'artSplitter')][1]//li[contains(@class,'linkItem')][1]")
    private WebElement facebook;

    public String getTitle() {
        return this.driver.getTitle();
    }

    ;

    public void navigateTo(String menuName) {
        if (menuName.equals("sports")) {
            this.sportsLink.isDisplayed();
            this.sportsLink.click();
        }

        if (menuName.equals("football")) {
            this.footballLink.isDisplayed();
            this.footballLink.click();
        }

        if (menuName.equals("headline")) {
            this.headlineLink.isDisplayed();
            this.headlineLink.click();
        }
    }

    public void openGallery() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", this.galleryButton);
        this.galleryButton.isDisplayed();
        this.galleryButton.click();
        this.isGalleryOpen = true;
    }

    public void moveNextGallery() {
        if (this.isGalleryOpen) {
            this.nextButton.click();
        }
    }

    public void movePrevGallery() {
        if (this.isGalleryOpen) {
            this.prevButton.click();
        }
    }

    public void share(String media) {
        //ensure gallery closed
        if (this.isGalleryOpen) {
            this.closeButton.isDisplayed();
            this.closeButton.click();
        }

        if (media.equals("facebook")) {
            this.shareicon.isDisplayed();
            this.shareicon.click();
            this.facebook.isDisplayed();
            this.facebook.click();
        }
    }
}