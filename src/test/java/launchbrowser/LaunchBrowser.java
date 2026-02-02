package launchbrowser;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {
     public static void main(String[] args){
         Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
        page.navigate("https://ecommerce-playground.lambdatest.io/index.php");
        Locator myAccount = page.locator("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
        myAccount.hover();
        page.locator("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[1]/a/div/span").click();
        assertThat(page).hasTitle("Account Login");
//         assertThat(page).hasURL("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
         page.getByPlaceholder("E-mail Address").type("hel-lo@gmail.com");
         page.getByPlaceholder("Password").type("12345");
         page.locator("//input[@value='Login']").click();
         assertThat(page).hasTitle("My Account");
         page.close();
         browser.close();
         playwright.close();
     }
}
