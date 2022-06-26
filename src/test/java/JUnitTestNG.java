import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
public class JUnitTestNG {
     @Test(alwaysRun = true) @BeforeMethod
     public void beforeTest(){
        Configuration.browserSize = "2100x1080";
        open("https://www.ukrposhta.ua/ua");
    }
    @Test(priority = 2, timeOut = 2000)
        public void deliveryOutsideUkraine() {
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

        @Test(priority = 1, invocationCount = 3)
        public void header() {
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

        @Test(priority = 3, invocationCount =2)
        public void calculateButton() {
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
            $(cssSelector("#weight")).val("1").pressEnter();
            $(cssSelector("#main app-form-submit button")).click();
        }

        @Test(dataProvider = "trackcode",priority = 4)
        public void trackButton(String val) {
            $(cssSelector("#trackcode")).shouldHave(empty);
            $(cssSelector("#trackcode")).setValue(val);
            $(cssSelector("#main span.default-btn-content")).click();
            $(xpath("//*[@id='trackcode']")).clear();
        }

        @Test(priority = 5, enabled = false)
        public void philately() {
            $(cssSelector("#philately-link")).click();
            $(cssSelector("#philately-sub-menu li:nth-child(4)")).click();
        }
    @DataProvider
    public Object[][] trackcode(){
        return new Object[][]{{"RA123456789UA"},{"RA123456788UA"}};
    }

    }

