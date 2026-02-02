package Day3;

import com.microsoft.playwright.*;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractWithInputs {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = browser.newPage();
//        page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo/");
//        page.locator("input#user-message").type("Hey Tester");
//        page.locator("#showInput").click();
//        String message = page.locator("#message").textContent();
//        System.out.println(message);
//        assertThat(page.locator("#message")).hasText("Hey Tester");

//        playwright.close();
//        browser.close();

        //Type vs
        //page.navigate("https://www.testmuai.com/selenium-playground/generate-file-to-download-demo/");
        //page.locator("#textbox").type("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
//        page.navigate("https://letcode.in/edit");
//        String inputValue = page.locator("#getMe").inputValue();
//        System.out.println(inputValue);
//

//        String placeholderValue = page.locator("#fullName").getAttribute("placeholder");
//        System.out.println(placeholderValue);
//
//        Locator fullNamelocator = page.locator("#fullName");
//        assertThat(fullNamelocator).hasAttribute("placeholder", "Enter first & last name");
//
//        page.locator("#clearMe").clear();

        page.navigate("https://www.testmuai.com/selenium-playground/checkbox-demo/");
        Locator checkBox = page.locator("//*[@id=\"__next\"]/div/div/section/div/div/div[1]/label/input");
        checkBox.check();
//        assertThat(checkBox).isChecked();


    }
}

//Methods:
//inputValue: reads and returns the value that's in the input
