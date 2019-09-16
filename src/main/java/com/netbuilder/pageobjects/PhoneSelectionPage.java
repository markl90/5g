package com.netbuilder.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PhoneSelectionPage {

    private WebDriver driver;

    @FindBy(className = "facet-keyword")
    private WebElement brandSelectionPane;

    @FindBy(className = "capacity-options")
    private WebElement capacitySelectionPane;

    @FindBy(className = "colour-options")
    private WebElement colourSelectionPane;

    private List<WebElement> products;



    public PhoneSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findBrandAndSelect(String text){
        WebElement brandSelector = brandSelectionPane.findElement(By.id("brand-"+text));
        brandSelector.click();
    }

    public void findCapacityAndSelect(String capacity){
        WebElement capacitySelector = capacitySelectionPane.findElement(By.id("capacity-"+capacity));
        capacitySelector.click();
    }

    public void findColourAndSelect(String colour){
        List<WebElement> colourSelector = colourSelectionPane.findElements(By.tagName("label"));
        WebElement colourButton = null;
        for (WebElement e: colourSelector){
            if(e.getAttribute("title").equals(colour)){
                colourButton = e;
            }
        }
        colourButton.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(colourButton, 0, 0)
                .moveByOffset(-30, -30)
                .click()
                .build()
                .perform();

    }

    public List<WebElement> findProducts(){
        products = driver.findElements(By.cssSelector("div.product.ng-scope.not-promoted"));
        return products;
    }

    public void selectProduct(int product){
//       WebElement listItem =  driver.findElement(By.xpath("//*[@id=\"mobileProduct\"]/div/div[2]/div[2]/div[2]/div/div["+product+"]"));
       WebElement chooseNowButton = driver.findElement(By.cssSelector("button.button.purple"));
        chooseNowButton.click();
    }
}
