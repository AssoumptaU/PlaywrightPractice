package Day5;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

import java.nio.file.Paths;
import java.util.Arrays;

public class LearnScreenshots {
    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page =browser.newPage();

        page.navigate("https://www.testmuai.com/selenium-playground/simple-form-demo/");

        //screenshots
        Page.ScreenshotOptions screeshotOptions = new Page.ScreenshotOptions();
        page.screenshot(screeshotOptions.setPath(Paths.get("./snaps/scr.jpg")));

        //full page screenshots
        page.screenshot(screeshotOptions.setFullPage(true).setPath(Paths.get("./snaps/fullpageScr.jpg")));

        //locator screenshot
        Locator bookBtn = page.locator("button.chfw-header_demo_btn");
        bookBtn.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/locatorScr.jpg")));

        Locator headerRegion = page.locator("header#chfw-header");
        headerRegion.screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("./snaps/regionScr.png")));

        //Masking locator
       Locator input = page.locator("input#user-message");
       input.scrollIntoViewIfNeeded();
//       input.type("Hello There!");
//        page.screenshot(screeshotOptions
//                .setFullPage(false).setMask(Arrays.asList(input))
//                .setPath(Paths.get("./snaps/maskScr.jpg")));


        //Caret show/hide
        input.click();
        page.screenshot(new Page.ScreenshotOptions()
                .setCaret(ScreenshotCaret.HIDE).setPath(Paths.get("./snaps/caretHIDE.png")));

        page.screenshot(new Page.ScreenshotOptions()
                .setCaret(ScreenshotCaret.INITIAL).setPath(Paths.get("./snaps/caretINIT.png")));

        page.close();
        playwright.close();
    }
}
