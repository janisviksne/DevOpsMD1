package com.userinfo.app.tvnettests;

import com.userinfo.app.SpringBaseTestNGTest;
import com.userinfo.app.tvnet.tvnetpage.Cookies;
import com.userinfo.app.tvnet.tvnetpage.TvnetPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

@SpringBootTest
public class TvnetTest extends SpringBaseTestNGTest {

    @Autowired
    private TvnetPage tvnetPage;

    @Autowired
    private Cookies cookies;

    @Test
    public void tvnetTest1() {
        try {
            this.tvnetPage.goTo();
            assertTrue(this.cookies.isAt());
            this.cookies.acceptCookies();
            assertTrue(this.tvnetPage.isAt());
            this.tvnetPage.getSearchComponent().writeComments();
            assertTrue(this.tvnetPage.getSearchComponent().isWriterClosed());
        } catch (IOException e) {
            System.out.println("Writer could not be closed! " + e);
        }

    }
}
