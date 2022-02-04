package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static utils.DateAndTime.getCurrentDate;
import static utils.EnvConstants.BASE_URL;


public class BasePage extends PageObject {
    private String randomString1 = randomAlphabetic(4, 8);
    private String randomString2 = randomAlphabetic(4, 8);

    public int getIntFromPrice(String priceNonFormatted) {
        return Integer.parseInt(priceNonFormatted
                .replace(",", "")
                .replace(" lei", "")
                .replace(".", "")
                .replace("-", "")
                .replace(" [Remove]", ""));
    }

    public String getDateFromOrder(WebElementFacade dateNonFormatted) {
        String date = dateNonFormatted.getText()
                //format will be MM.dd.YYYY
                .replace("January", "01")
                .replace("February", "02")
                .replace("March", "03")
                .replace("April", "04")
                .replace("May", "05")
                .replace("June", "06")
                .replace("July", "07")
                .replace("August", "08")
                .replace("September", "09")
                .replace("October", "10")
                .replace("November", "11")
                .replace("December", "12")
                .replace(" ", ".")
                .replace(",", "");
        //System.out.println(date);
        return date;
    }

    public String getCurrentDateWithOrderFormat(){
        String date = getCurrentDate()
                .replace(".0",".");
        //System.out.println(date);
        return date;
    }

    public String getRandomString1() {
        return randomString1;
    }

    public String getRandomString2() {
        return randomString2;
    }
}
