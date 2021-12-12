package com.userinfo.app.tvnet.tvnetpage;

import com.userinfo.app.tvnet.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


@Component
public class SearchComponent extends Base {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm");

    @FindBy(xpath = "//ul[@class='article-comments']/li")
    private List<WebElement> comments;



    private boolean isWriterClosed = false;

    public boolean isWriterClosed() {
        return isWriterClosed;
    }

    public void writeComments() throws IOException {

        this.wait.until((d) -> this.comments.listIterator().next().isDisplayed());
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Selenium Test " + dateFormat.format(date) + ".txt"),
                StandardCharsets.UTF_8))) {
            for (WebElement element : comments) {
                writer.write(element.getText() + "\n===============================\n");
            }
        } catch (Exception e) {
            System.err.println("Writer issue: " + e);
        } finally {
            isWriterClosed = true;
        }

    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.comments.listIterator().next().isDisplayed());
    }
}
