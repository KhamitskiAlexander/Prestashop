package com.prestashop.pages;

import com.prestashop.utils.DataUtils;
import com.prestashop.utils.DriverActions;
import org.openqa.selenium.By;

public class OrderPage extends BasePage {
    private final By personalInformationSectionTitle =
            By.xpath("//section[contains(@id, 'personal')]/h1[contains(@class, 'title')]");
    private final By firstName = By.id("field-firstname");
    private final By lastName = By.id("field-lastname");
    private final By email = By.id("field-email");
    private final By password = By.id("field-password");
    private final By birthDate = By.id("field-birthday");
    private final By mrGender = By.xpath("//label[@for = 'field-id_gender-1']");
    private final By agreeLabel = By.xpath("//input[@name = 'psgdpr']/ancestor::label");
    private final By customerDataPrivacyLabel = By.xpath("//input[@name = 'customer_privacy']/ancestor::label");
    private final By address = By.id("field-address1");
    private final By city = By.id("field-city");
    private final By zip = By.id("field-postcode");
    private final By country = By.id("field-id_country");
    private final By continueButtonAfterAddressesSection = By.xpath("//button[@name = 'confirm-addresses']");
    private final By confirmButtonAfterDeliverySection = By.xpath("//button[@name = 'confirmDeliveryOption']");
    private final By payByBankRadioButton = By.xpath("//label[contains(., 'Pay by bank')]");
    private final By termsAndConditionsCheckbox = By.xpath("//a[contains(@id, 'terms-and-conditions')]/ancestor::label");
    private final By orderConfirmation = By.xpath("//h3[contains(., 'order')]");

    public String getPersonalInformationSectionTitle() {
        return DriverActions.getText(personalInformationSectionTitle).trim();
    }

    public void fillPersonalInfo() {
        DriverActions.click(mrGender);
        DriverActions.setText(firstName, DataUtils.getRandomFirstName());
        DriverActions.setText(lastName, DataUtils.getRandomLastName());
        DriverActions.setText(email, DataUtils.getRandomEmail());
        DriverActions.setText(password, DataUtils.getRandomPassword());
        DriverActions.setText(birthDate, DataUtils.getRandomBirthDate());
        DriverActions.jsScrollTo(agreeLabel);
        DriverActions.waitToBeVisible(agreeLabel);
        DriverActions.click(agreeLabel);
        DriverActions.jsScrollTo(customerDataPrivacyLabel);
        DriverActions.waitToBeVisible(customerDataPrivacyLabel);
        DriverActions.click(customerDataPrivacyLabel);
    }

    public void fillAddresses() {
        DriverActions.setText(address, DataUtils.getRandomAddress());
        DriverActions.setText(city, DataUtils.getRandomCity());
        DriverActions.setText(zip, DataUtils.getRandomZip());
        DriverActions.setSelectByText(country, "France");
    }

    public void clickContinueButtonAfterAddressFilling() {
        DriverActions.waitToBeVisible(continueButtonAfterAddressesSection);
        DriverActions.jsScrollTo(continueButtonAfterAddressesSection);
        DriverActions.click(continueButtonAfterAddressesSection);
    }

    public void clickConfirmDeliveryOpt() {
        DriverActions.click(confirmButtonAfterDeliverySection);
    }

    public void fillInPayment() {
        DriverActions.click(payByBankRadioButton);
        DriverActions.click(termsAndConditionsCheckbox);
    }

    public String getOrderConfirmationMessage() {
        return DriverActions.getText(orderConfirmation);
    }
}
