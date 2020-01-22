package pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class ResultPage {
    public void checkResults() {
        $("#resultStats").shouldBe(Condition.visible);
    }

    public void moreButton() {
        $("g-header-menu [role='button']").click();
    }

    public void getMenuTab(String tabName) {
        $$(".hdtb-imb").findBy(Condition.text(tabName)).click();

    }

    public void checkTitle(String title) {
        $("title").shouldHave(attribute("text", title));
    }

    public void moreElementsList(String name) {
        $$("[role='menuitem']").findBy(Condition.text(name)).click();

    }

    public MapPage goToMapPage() {
        return page(MapPage.class);
    }

    public VideoPage goToVideoPage() {
        return page(VideoPage.class);
    }


}
