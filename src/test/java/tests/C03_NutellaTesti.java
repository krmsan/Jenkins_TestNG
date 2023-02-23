package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NutellaTesti {

    @Test(groups = {"minireg1","minireg2","smoke"})
    public void test01(){
        ReusableMethods.bekle(3);
        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        // nutella icin arama yapin
        //WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        AmazonPage amazonPage= new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edin
        // WebElement aramaSonucuElementi= Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedKelime="Nutella";
        String actualAramaSonucu= amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
        System.out.println("JENKINS ILE CALISTIRILDI");
        System.out.println("TESTNG KULLANILDI");
        System.out.println("SUPER");

        Driver.closeDriver();

    }
}
