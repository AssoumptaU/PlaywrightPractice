package frames;

import com.microsoft.playwright.*;

public class LearnFrames {

public static void main(String[] args){

    Playwright playwright = Playwright.create();
    BrowserType browserType = playwright.chromium();
    Page page = browserType.launch(
            new BrowserType.LaunchOptions().setHeadless(false)
    ).newPage();

    //iFrame
    page.navigate("https://quilljs.com/playground/snow");
    FrameLocator frame = page.frameLocator("iframe.sp-preview-iframe");
    Locator body = frame.locator("//*[@id=\"editor\"]/div[1]");
    body.click();
    body.clear();
    body.fill("Nowhere to be found haha");


    //Nested Frames
    page.navigate("https://letcode.in/frame");
    FrameLocator firstFrame = page.frameLocator("#firstFr");
    firstFrame.getByPlaceholder("Enter name").type("My name is YUUUU");
    FrameLocator innerFrame = firstFrame.frameLocator("body > app-root > app-frame-content > div > div > div > iframe");
    innerFrame.getByPlaceholder("Enter email").type("assoumpta@gmail.com");



//    playwright.close();




}
}
