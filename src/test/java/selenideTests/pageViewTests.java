package selenideTests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by iuriiryndin on 21.04.2020
 */
public class pageViewTests extends Main{

    @Test
    public static void firstTest () {
        System.out.println("Hello test world!");
        Assert.assertTrue(true);
    }
}
