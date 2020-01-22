package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class MapPage {

    public void checkResultTitle(String resultTitle) {
        $(".section-hero-header-title-title").waitUntil(Condition.visible, 5000).
                shouldHave(Condition.matchesText(resultTitle));
    }
}
