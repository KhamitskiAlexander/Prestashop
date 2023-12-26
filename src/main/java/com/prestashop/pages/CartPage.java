package com.prestashop.pages;

import java.util.ArrayList;
import java.util.List;

import com.prestashop.utils.DriverActions;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private final By itemNamesInCart = By.xpath("//div[@class='product-line-info']");
    private final By proceedToCheckoutButton = By.xpath("//div[@class='card cart-summary']//a[@class='btn btn-primary']");

    public List<String> getAllItemNamesInCart() {
        List <String> listOfThingsInCart = DriverActions.getListOfStrings(itemNamesInCart);
        List<String> listOfThingsInCartInUpperCase = new ArrayList<>();
        for (String s : listOfThingsInCart) {
            listOfThingsInCartInUpperCase.add(s.toUpperCase());
        }
        return listOfThingsInCartInUpperCase;
    }

    public void clickProceedToCheckoutButton() {
        DriverActions.click(proceedToCheckoutButton);
    }
}
