package windowHandling;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LearnWindowHandling {
    public static void main(String[] args){

       Playwright playwright = Playwright.create();
        BrowserType browser= playwright.chromium();
        Page page =  browser.launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        ).newPage();
        page.navigate("https://www.testmuai.com/selenium-playground/window-popup-modal-demo/");
        Page popup = page.waitForPopup(()->{
            page.getByText("Follow On Twitter").click();
        });
        popup.waitForLoadState();
        assertThat(popup).hasTitle("Profile / X");
        System.out.println(popup.title());
        popup.getByText("Log in").click();

        //multiple tabs



    }

}
