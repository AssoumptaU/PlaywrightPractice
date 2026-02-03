package browserContext;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LearnBrowserContext {
    public static void main(String[] args){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        page.getByLabel("E-Mail Address").type("uwabera@gmail.com");
        page.getByLabel("Password").type("1234");
        page.locator("input.btn-primary").click();
        Locator myAccount = page.getByText("Edit your account information");
        assertThat(myAccount).isVisible();

//

        //How to Open a new tab with the same browser session
       Page newTab=  page.context().newPage();
       newTab.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
        assertThat(myAccount).isVisible();
        newTab.close();
        context.close();

        //Opening a new BrowserContext
        BrowserContext context2 = browser.newContext();
       Page userPage = context2.newPage();
       userPage.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");

       //Opening Multiple browsers
        BrowserType firefox = playwright.firefox();
        firefox.launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        ).newPage();

        playwright.close();
    }
}
