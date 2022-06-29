package com.accessHQ.test;

import com.accessHQ.models.PlanetPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPlanetsSuite {
    private ChromeDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/index.html#/planets");
        driver.manage().window().maximize();
    }

    @Test
    public void testEarthExplore(){
        var planet = new PlanetPage(driver);
        planet.clickExplore(p -> p.getName().equalsIgnoreCase("Earth")  );
        Assertions.assertEquals("Exploring Earth", planet.getPopUp());
    }

    @Test
    public void findPlanetWithRadiusOf58232(){
        var planet = new PlanetPage(driver);
        planet.clickExplore(p -> p.getRadius() == 58232);
        Assertions.assertEquals("Exploring Saturn", planet.getPopUp());
    }

    @Test
    public void findPlanetWithDistanceOf57910000(){
        var planet = new PlanetPage(driver);
        planet.clickExplore(p -> p.getDistance() == 57910000L);
        Assertions.assertEquals("Exploring Mercury", planet.getPopUp());
    }

//    @Test
//    public void findPlanetWithFurthestDistance(){
//        var planet = new PlanetPage(driver);
//        planet.clickExplore(new DistanceMatchingStrategy(57910000L));
//        Assertions.assertEquals("Exploring Mercury", planet.getPopUp());
//    }


    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
