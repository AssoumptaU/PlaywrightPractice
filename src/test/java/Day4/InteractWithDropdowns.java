package Day4;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractWithDropdowns {
    public static void main(String[] args){

        String selectDropdownURL = "https://www.testmuai.com/selenium-playground/select-dropdown-demo/";
        String jqueryDropdownURL = "https://www.testmuai.com/selenium-playground/jquery-dropdown-search-demo/";

        //launch browser

       Page page = Playwright.create().chromium().launch(
               new BrowserType.LaunchOptions().setHeadless(false)
        ).newPage();

       page.navigate("https://www.testmuai.com/selenium-playground/select-dropdown-demo/");
       Locator dropDownLocator = page.locator("Select#select-demo");

        //Select by value
//        dropDownLocator.selectOption("Wednesday");
//        assertThat(page.locator("p.selected-value")).containsText("Wednesday");

        //Select by label
//        dropDownLocator.selectOption(new SelectOption().setValue("Tuesday"));
//        assertThat(page.locator("p.selected-value")).containsText("Tuesday");

        // Select by index
//        dropDownLocator.selectOption(new SelectOption().setIndex(2));

        //Select multiple options
//        Locator statesmultiDropdown = page.locator("Select#multi-select");
//        statesmultiDropdown.selectOption(new String[] {"Texas", "New Jersey", "Ohio"});
//        Locator lastOptionButton = page.locator("#printAll");
//        lastOptionButton.click();
//        Locator options = statesmultiDropdown.locator("option");
//        System.out.println(options.count());
//        List<String> allInnerTexts = options.allInnerTexts();
//        allInnerTexts.forEach(option-> System.out.println(option));

        //Select Jquery


    }
}
