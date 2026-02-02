package recordVideo;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.RecordVideoSize;

import java.nio.file.Paths;

public class LoginLogout {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
                            .setRecordVideoSize(new RecordVideoSize(1290,1080))
            );
            Page page = context.newPage();
            page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
            page.locator("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span").hover();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).fill("hellothere@gmail.com");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click( );
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("1234");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit your account")).click();
            Locator firstNameInput = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*"));
            firstNameInput.fill("uwabera@gmail.com");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowLeft");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*")).press("ArrowRight");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail*"))
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            Locator confirmationMessage = page.getByText("Success: Your account has");
            assertThat(confirmationMessage).isVisible();
            Locator myAccount = page.locator("//*[@id=\"widget-navbar-217834\"]/ul/li[6]/a/div/span");
            myAccount.hover();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout").setExact(true)).click();
           Locator logoutMessage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Account Logout"));
           assertThat(logoutMessage).isVisible();

//            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" Account Logout")).click();
//            page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(" Account Logout")).click();


        //Note: Here we were using Codegen, what it does is that it records ui interactions and generates codes for you
        // but there some interactions that it does not record which has to be done manually such as hover, assertions, ....

        page.close();
        context.close();
        playwright.close();
        }
    }

