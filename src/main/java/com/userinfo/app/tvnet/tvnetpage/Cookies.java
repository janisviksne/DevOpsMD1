package com.userinfo.app.tvnet.tvnetpage;

import com.userinfo.app.tvnet.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class Cookies extends Base {

    @FindBy(css = "button.css-47sehv")
    private WebElement cookieBtn;


    public void acceptCookies(){
        this.cookieBtn.click();
    }


    @Override
    public boolean isAt() {
        return this.wait.until((d) -> cookieBtn.isEnabled());
    }
}
