import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void deliveryOutsideUkraine (){
        Configuration.browserSize="2100x1080";
        open("https://www.ukrposhta.ua/ua");
        $(By.xpath("//*[@id='mizhnarodni1_main']")).scrollTo();
        $(By.xpath("//*[@id='mizhnarodni1_main']")).hover().click();
        $(By.cssSelector("#calculate1")).click();
        $(By.xpath("//button[text()='Дякую, ознайомлений (-а)']")).should(appear).click();
        $(By.xpath("//*[@id='toInternationalCalc']")).click();
        $(By.cssSelector("#toDomesticCalc")).shouldBe(visible);
        $(By.cssSelector("#departureCntry")).should(editable).doubleClick();
        $(By.cssSelector("#departureCntry")).setValue("Німеччина").pressEnter();
        $(By.cssSelector("#main app-form-h6:nth-child(4)")).scrollTo();
        $(By.cssSelector("#weight")).setValue("2").pressEnter();
        $(By.cssSelector("#lenght")).setValue("20").pressEnter();
        $(By.cssSelector("#height")).setValue("20").pressEnter();
        $(By.cssSelector("#width")).setValue("20").pressEnter();
        $(By.cssSelector("#ground")).scrollTo().click();
        $(By.cssSelector("#main app-form-submit button")).shouldBe(enabled).shouldHave(exactText("Розрахувати вартість")).click();;
    }
}
