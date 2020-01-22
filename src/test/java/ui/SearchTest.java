package ui;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.MapPage;
import pages.ResultPage;
import pages.VideoPage;

public class SearchTest {

    @Test(groups = "Ui")
    public void searchTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.search("Selenide");
        ResultPage resultPage = mainPage.searchButton();
        resultPage.checkResults();
        resultPage.checkTitle("Selenide - Поиск в Google");
    }

    @Test(groups = "Ui")
    public void findVideoTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.search("automation testing");
        ResultPage resultPage = mainPage.searchButton();
        resultPage.checkResults();
        resultPage.getMenuTab("Видео");

        VideoPage videoPage = resultPage.goToVideoPage();
        videoPage.checkVideoName("Automation Testing Tutorial");

    }

    @Test(groups = "Ui")
    public void findPurchaseTest() {
        MainPage mainPage = new MainPage();
        mainPage.checkLogo();
        mainPage.search("book");
        ResultPage resultPage = mainPage.searchButton();
        resultPage.checkResults();
        resultPage.moreButton();
        resultPage.moreElementsList("Покупки");

    }

    @Test(groups = "Ui")
    public void mapTest() {
        String searchText = "Санкт-Петербург";

        MainPage mainPage = new MainPage();
        mainPage.search(searchText);

        ResultPage resultPage = mainPage.searchButton();
        resultPage.getMenuTab("Карты");

        MapPage mapPage = resultPage.goToMapPage();
        mapPage.checkResultTitle(searchText);

    }

}
