package com.netbuilder.steps;

import com.netbuilder.pageobjects.HomePage;
import com.netbuilder.pageobjects.PhoneSelectionPage;
import com.netbuilder.test.common.session.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class OrderJourneySteps extends TestBase {

    private HomePage homePage;
    private PhoneSelectionPage phonePage;

    @Before
    public void setUp(){
        homePage = new HomePage(driver);
        phonePage = new PhoneSelectionPage(driver);
    }

    @After
    public void tearDown(){
        session.stopDriver();
    }


    @Given("^the user is on the landing page$")
    public void the_user_is_on_the_landing_page() {
        driver.get(session.getBaseUrl());
        page.waitForLoad(driver);
        homePage.waitAndClickCloseCookies();

    }

    @When("^the the user selects the phones link$")
    public void the_the_user_selects_the_phones_link()  {
        homePage.hoverOverProductsAndServicesDropDown();
        homePage.clickPhonesLink();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    @When("^the user specifies a search selecting a result$")
    public void the_user_specifies_a_search_selecting_a_result(DataTable params){

        List<String> list = params.asList(String.class);
        String brand = list.get(2);
        String capacity = list.get(3);
//        String colour = list.get(5);
        phonePage.findBrandAndSelect(brand);
        phonePage.findCapacityAndSelect(capacity);
        page.waitForLoad(driver);
//        :ToDo
//        revisit colour selection
//        phonePage.findColourAndSelect(colour);

        List<WebElement> products = phonePage.findProducts();
        System.out.println(products.size());





        for(WebElement prod: products) {
        }


//        products.get(0).click();

        driver.findElement(By.xpath("//*[@id=\"mobileProduct\"]/div/div[2]/div[2]/div[2]/div/div/div[4]/button")).click();

//        phonePage.selectProduct(1);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @When("^the user clicks the product$")
    public void the_user_clicks_the_product() {

    }


}
