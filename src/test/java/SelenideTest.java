import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class SelenideTest {
    @Test
    public void deliveryOutsideUkraine() {
        Configuration.browserSize = "2100x1080";
        open("https://www.ukrposhta.ua/ua");
        $(xpath("//*[@id='mizhnarodni1_main']")).scrollTo();
        $(xpath("//*[@id='mizhnarodni1_main']")).hover().click();
        $(cssSelector("#calculate1")).click();
        $(xpath("//button[text()='Дякую, ознайомлений (-а)']")).should(appear).click();
        $(xpath("//*[@id='toInternationalCalc']")).click();
        $(cssSelector("#toDomesticCalc")).shouldBe(visible);
        $(cssSelector("#departureCntry")).should(editable).doubleClick();
        $(cssSelector("#departureCntry")).setValue("Німеччина").pressEnter();
        $(cssSelector("#main app-form-h6:nth-child(4)")).scrollTo();
        $(cssSelector("#weight")).setValue("2").pressEnter();
        $(cssSelector("#lenght")).setValue("20").pressEnter();
        $(cssSelector("#height")).setValue("20").pressEnter();
        $(cssSelector("#width")).setValue("20").pressEnter();
        $(cssSelector("#ground")).scrollTo().click();
        $(cssSelector("#main app-form-submit button")).shouldBe(enabled).shouldHave(exactText("Розрахувати вартість")).click();
    }

    @Test
    public void header() {
        Configuration.browserSize = "2100x1080";
        open("https://www.ukrposhta.ua/ua");
        $(cssSelector("#bottom-line li:nth-child(1)")).shouldBe(enabled).hover();
        $(cssSelector("#services-link")).shouldBe(enabled).hover();
        $(cssSelector("#tariffs-link")).shouldBe(enabled).hover();
        $(cssSelector("#bottom-line li:nth-child(4)")).shouldBe(enabled).hover();
        $(cssSelector("#philately-link")).shouldBe(enabled).hover();
        $(cssSelector("#bottom-line li:nth-child(6)")).shouldBe(enabled).hover();
        $(cssSelector("#bottom-line li:nth-child(7)")).shouldBe(enabled).hover();
        $(xpath("//*[@id='slick-slide02']")).shouldBe(enabled).hover();
        $(cssSelector("#calculate_button")).shouldBe(enabled).hover();
        $(cssSelector("#order_button")).shouldBe(enabled).hover();
        $(cssSelector("#find_index1")).shouldBe(enabled).hover();
        $(cssSelector("#peredplata")).shouldBe(enabled).hover();
    }

    @Test
    public void calculateButton() {
        Configuration.browserSize = "2100x1080";
        open("https://www.ukrposhta.ua/ua");
        $(cssSelector("#calculate_button")).click();
        $(xpath("//button[text()='Дякую, ознайомлений (-а)']")).click();
        $(cssSelector(".modal-content")).should(Condition.disappear);
        $(cssSelector("#fromWhere")).setValue("Київ").pressEnter();
        $(xpath("//*[@id='main']//ul//button[1]")).click();
        $(cssSelector("#toWhere")).setValue("Київ").pressEnter();
        $(xpath("//*[@id='main']//form-select[2]//ul//button[1]")).click();
        $(cssSelector("#goTolatter")).scrollTo();
        $(cssSelector("#goTolatter")).click();
        $(cssSelector("#goTolatter")).shouldBe(Condition.attribute("class", "activeButton"));
        $(xpath("//button[text()='Розрахувати вартість ']")).shouldBe(Condition.disabled);
        $(cssSelector("#weight")).val("1").pressEnter();
        $(xpath("//button[text()='Розрахувати вартість']")).shouldBe(Condition.enabled);
    }

    @Test
    public void trackButton() {
        Configuration.browserSize = "2100x1080";
        open("https://www.ukrposhta.ua/ua");
        $(cssSelector("#trackcode")).shouldHave(empty);
        $(cssSelector("#trackcode")).setValue("RA123456789UA");
        $(cssSelector("#main span.default-btn-content")).click();
        $(xpath("//*[@id='trackcode']")).clear();
    }

    @Test
    public void philately() {
        Configuration.browserSize = "2100x1080";
        open("https://www.ukrposhta.ua/ua");
        $(cssSelector("#philately-link")).click();
        $(cssSelector("#philately-sub-menu li:nth-child(4)")).click();
    }
}

