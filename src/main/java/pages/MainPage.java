package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage() {

        open("https://www.google.com");
    }

    public ResultPage searchButton() {
        $("input[aria-label='Поиск в Google']").click();
        return page(ResultPage.class);
    }

    public void search(String searchText) {
        $("input[aria-label='Найти']").setValue(searchText);
    }

    public void checkLogo() {
        $("#hplogo").shouldBe(Condition.visible);
    }


}