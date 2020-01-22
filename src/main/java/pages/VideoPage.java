package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$$;

public class VideoPage {

    public void checkVideoName(String videoName) {
        $$("h3").filterBy(Condition.matchesText(videoName)).shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
