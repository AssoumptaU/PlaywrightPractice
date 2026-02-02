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

//        playwright.close();
    }
}
