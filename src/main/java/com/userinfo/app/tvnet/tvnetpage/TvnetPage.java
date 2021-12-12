package com.userinfo.app.tvnet.tvnetpage;

import com.userinfo.app.tvnet.Base;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TvnetPage extends Base {

    @Autowired
    private WebDriver driver;

    @Autowired
    private SearchComponent searchComponent;


    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public void goTo(){
        this.driver.manage().window().maximize();
        this.driver.get("https://www.tvnet.lv/7367564/noteiktam-grupam-kompenses-rigas-sabiedriska-transporta-izdevumus/comments");
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
