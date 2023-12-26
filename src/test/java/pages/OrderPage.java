package pages;

import org.openqa.selenium.By;
import utils.DataUtils;
import utils.DriverActions;

public class OrderPage extends BasePage {
    private final By personalInformationSectionTitle =
            By.xpath("//section[contains(@id, 'personal')]/h1[contains(@class, 'title')]");
    private final By firstName = By.id("field-firstname");
    private final By lastName = By.id("field-lastname");
    private final By email = By.id("field-email");
    private final By password = By.id("field-password");
    private final By birthDate = By.id("field-birthday");
    private final By mrGender = By.xpath("//label[@for='field-id_gender-1']");
    private final By agreeLabel = By.xpath("//label[contains(.,' I agree')]");
    private final By customerDataPrivacyLabel = By.xpath("//label[contains(.,' Customer')]");
    private final By address = By.id("field-address1");
    private final By city = By.id("field-city");
    private final By state = By.id("field-id_state");
    private final By zip = By.id("field-postcode");
    private final By country = By.id("field-id_country");
    private final By continueAfterAddresses = By.xpath("//input[@name='submitAddress']/following-sibling::button[contains(., 'Continue')]");
    private final By confirmDeliveryOpt = By.xpath("//button[@name='confirmDeliveryOption']");
    private final By payByBankOpt = By.xpath("//label[contains(.,'Pay by bank')]");
    private final By orderConfirmation = By.xpath("//h3[contains(.,'order')]");

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
        DriverActions.click(agreeLabel);
        DriverActions.click(customerDataPrivacyLabel);
    }

    public void fillAddresses() {
        DriverActions.setText(address, DataUtils.getRandomAddress());
        DriverActions.setText(city, DataUtils.getRandomCity());
        DriverActions.setSelectByText(state, DataUtils.getRandomState());
        DriverActions.setText(zip, DataUtils.getRandomZip());
        DriverActions.setSelectByText(country, "France");
        DriverActions.click(continueAfterAddresses);
    }

    public void clickConfirmDeliveryOpt() {
        DriverActions.click(confirmDeliveryOpt);
    }

    public void fillInPayment(){
        DriverActions.click(payByBankOpt);
        DriverActions.click(agreeLabel);
    }

    public String getOrderConfirmationMessage(){
        return DriverActions.getText(orderConfirmation);
    }
}
