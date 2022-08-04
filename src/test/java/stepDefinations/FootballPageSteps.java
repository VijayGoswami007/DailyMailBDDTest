package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FootballPage;
import utility.PropertiesReader;

public class FootballPageSteps {
    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private FootballPage footballPage;

    public FootballPageSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
        Thread.sleep(1000); // Wait for the GDPR button
        driver.findElement(new By.ByXPath("//div[@class='footer_GqesM']//button[2]")).click();
    }
    @Given("I am visiting the FootballPage")
    public void visitTheFootballPage() throws Exception {
        this.footballPage = new FootballPage(driver, wait);
    }

    @And("navigate to sports tab")
    public void navigateToSports() {
        this.footballPage.navigateTo("sports");
    }

    @And("navigate to football tab")
    public void navigateToFootball() {
        this.footballPage.navigateTo("football");
    }

    @And("navigate to headline article")
    public void navigateToHeadLineArticle() {
        this.footballPage.navigateTo("headline");
    }

    @Then("^traverse to the gallery image$")
    public void traverseToGallery() {
        this.footballPage.openGallery();
    }

    @Then("should be able to move next")
    public void traverseNext() {
        this.footballPage.moveNextGallery();
    }

    @Then("should be able to move prev")
    public void traversePrev() {
        this.footballPage.movePrevGallery();
    }

    @Then("should be able to share")
    public void share() {
        this.footballPage.share("facebook");
    }
}
