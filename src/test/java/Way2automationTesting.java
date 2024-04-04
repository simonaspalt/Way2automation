import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.color.ICC_ColorSpace;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Way2automationTesting {
    WebDriver _globalDriver;

    private WebDriver globalDriver;

    @BeforeTest
    public void SetupWebDriver (){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        _globalDriver = new ChromeDriver(options);
        _globalDriver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
        _globalDriver.manage().window().maximize();
    }

    @Test
    private void DroppableDF(){
        //change frame
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //pick drag and drop elements
        WebElement draggableElement = _globalDriver.findElement(By.id("draggable"));
        WebElement droppableElement = _globalDriver.findElement(By.id("droppable"));
        //move drag to drop
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();
    }

    @Test
    public void DroppableAccept(){
        //click accept
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        //pick drag and drop
        WebElement draggableElement = _globalDriver.findElement(By.id("draggable"));
        WebElement droppableElement = _globalDriver.findElement(By.xpath("/html/body/div[3]"));
        //move drag to drop
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDrop(draggableElement, droppableElement).build().perform();

    }

    @Test
    public void DropppablePP(){
        //click prevent propogation
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        //pick drag and drops
        WebElement draggableElement = _globalDriver.findElement(By.id("draggable"));
        WebElement droppableElement1 = _globalDriver.findElement(By.id("droppable"));
        WebElement droppableElement2 = _globalDriver.findElement(By.id("droppable-inner"));
        WebElement droppableElement3 = _globalDriver.findElement(By.id("droppable2"));
        WebElement droppableElement4 = _globalDriver.findElement(By.id("droppable2-inner"));
        //drag
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDrop(draggableElement, droppableElement1).build().perform();
        actions.dragAndDrop(draggableElement, droppableElement2).build().perform();
        actions.dragAndDrop(draggableElement, droppableElement3).build().perform();
        actions.dragAndDrop(draggableElement, droppableElement4).build().perform();



    }

    @Test
    public void DroppableRDP(){
        //click RDP
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        //pick drag and drops
        WebElement draggableElement1 = _globalDriver.findElement(By.id("draggable"));
        WebElement draggableElement2 = _globalDriver.findElement(By.id("draggable2"));
        WebElement droppableElement = _globalDriver.findElement(By.id("droppable"));
        //drag
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDrop(draggableElement1, droppableElement).build().perform();
        actions.dragAndDrop(draggableElement2, droppableElement).build().perform();

    }

    @Test
    public void DraggableDefault(){
        //click darggable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[1]")).click();
        //switch iframe
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //get draggable
        WebElement draggableElement = _globalDriver.findElement(By.id("draggable"));
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDropBy(draggableElement, 50, 50).build().perform();

    }

    @Test
    public void DraggableConstrainMovement(){
        //click draggable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[1]")).click();
        //click constrain movement
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        // get draggables
        WebElement draggableElement1 = _globalDriver.findElement(By.id("draggable"));
        WebElement draggableElement2 = _globalDriver.findElement(By.id("draggable2"));
        WebElement draggableElement3 = _globalDriver.findElement(By.id("draggable3"));
        WebElement draggableElement4 = _globalDriver.findElement(By.id("draggable5"));
        //drag em
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDropBy(draggableElement1, 200, 200).build().perform();
        actions.dragAndDropBy(draggableElement2, 200, 200).build().perform();
        actions.dragAndDropBy(draggableElement3, 200, 200).build().perform();
        actions.dragAndDropBy(draggableElement4, 200, 200).build().perform();


    }

    @Test
    public void DraggableCursorstyle(){
        //click draggable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[1]")).click();
        //click cursor style
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        // get draggables
        WebElement draggableElement1 = _globalDriver.findElement(By.id("draggable"));
        WebElement draggableElement2 = _globalDriver.findElement(By.id("draggable2"));
        WebElement draggableElement3 = _globalDriver.findElement(By.id("draggable3"));
        //drag em
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDropBy(draggableElement1, 200, 200).build().perform();
        actions.dragAndDropBy(draggableElement2, 200, 200).build().perform();
        actions.dragAndDropBy(draggableElement3, 200, 200).build().perform();
    }
    @Test
    public void DraggableEvents(){
        //click draggable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[1]")).click();
        //click events
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        // get draggables
        WebElement draggableElement1 = _globalDriver.findElement(By.id("draggable"));
        //drag em
        Actions actions = new Actions(_globalDriver);
        actions.dragAndDropBy(draggableElement1, 200, 200).build().perform();
        actions.dragAndDropBy(draggableElement1, -100, -100).build().perform();
        actions.dragAndDropBy(draggableElement1, 500, 100).build().perform();
    }

    @Test
    public void DraggableAnSortable(){
        //click draggable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[1]")).click();
        //click draggable and sortable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[5]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[5]/div/iframe")));
        // get draggables and sortable(Dropables)
        WebElement draggableElement1 = _globalDriver.findElement(By.id("draggable"));
        WebElement droppableElement = _globalDriver.findElement(By.xpath("/html/body/ul[2]/li[3]"));

        //drag em
        Actions actions = new Actions(_globalDriver);

        actions.dragAndDrop(draggableElement1, droppableElement).build().perform();


    }

    @Test
    public void ResizeableDF(){
        //click on resizeable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //click and drag
        WebElement resizableElement = _globalDriver.findElement(By.xpath("/html/body/div/div[3]"));
        WebElement box = _globalDriver.findElement(By.id("resizable"));
        int width = box.getSize().getWidth();
        int height = box.getSize().getHeight();
        Actions actions = new Actions(_globalDriver);
        actions.clickAndHold(resizableElement).moveByOffset(500, 100).release().build().perform();

        Assert.assertEquals(width + 500,_globalDriver.findElement(By.id("resizable")).getSize().getWidth());
        Assert.assertEquals(height + 100,_globalDriver.findElement(By.id("resizable")).getSize().getHeight());


    }
    @Test
    public void ReizeableAnimate(){
        //click on resizeable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]")).click();
        //click animate
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        //click and drag
        WebElement resizableElement = _globalDriver.findElement(By.xpath("/html/body/div/div[3]"));
        WebElement box = _globalDriver.findElement(By.id("resizable"));
        int width = box.getSize().getWidth();
        int height = box.getSize().getHeight();
        Actions actions = new Actions(_globalDriver);
        actions.clickAndHold(resizableElement).moveByOffset(500, 100).release().build().perform();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(width + 500,_globalDriver.findElement(By.id("resizable")).getSize().getWidth());
        Assert.assertEquals(height + 100,_globalDriver.findElement(By.id("resizable")).getSize().getHeight());

    }

    @Test
    public void ResizeableConstrained(){
        //click on resizeable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]")).click();
        //click constrained
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[3]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[3]/div/iframe")));
        //
        WebElement resizableElement = _globalDriver.findElement(By.xpath("/html/body/div/div/div[3]"));
        WebElement box = _globalDriver.findElement(By.id("resizable"));
        int width = box.getSize().getWidth();
        int height = box.getSize().getHeight();
        Actions actions = new Actions(_globalDriver);
        actions.clickAndHold(resizableElement).moveByOffset(10, 50).release().build().perform();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(_globalDriver.findElement(By.id("resizable")).getSize().getWidth());
        Assert.assertEquals(_globalDriver.findElement(By.id("resizable")).getSize().getWidth(), width + 10);
        Assert.assertEquals(_globalDriver.findElement(By.id("resizable")).getSize().getHeight(), height + 50);
    }

    @Test
    public void ReassizeableHelper(){
        //click on resizeable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]")).click();
        //click helper
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[4]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[4]/div/iframe")));
        //click and drag
        WebElement resizableElement = _globalDriver.findElement(By.xpath("/html/body/div/div[3]"));
        WebElement box = _globalDriver.findElement(By.id("resizable"));
        int width = box.getSize().getWidth();
        int height = box.getSize().getHeight();
        Actions actions = new Actions(_globalDriver);
        actions.clickAndHold(resizableElement).moveByOffset(500, 100).build().perform();
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //assertain only visually?
    }
    @Test
    public void ResizeableMaxMinSize(){
        //click on resizeable
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[1]/ul/li[3]")).click();
        //click min max size
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[5]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[5]/div/iframe")));
        //drag em
        WebElement resizableElement = _globalDriver.findElement(By.xpath("/html/body/div/div[3]"));
        WebElement box = _globalDriver.findElement(By.id("resizable"));
        int width = box.getSize().getWidth();//min width 211 max 350
        int height = box.getSize().getHeight();//min height 161 max 250
        //System.out.println(width);
        //System.out.println(height);
        Actions actions = new Actions(_globalDriver);
        actions.clickAndHold(resizableElement).moveByOffset(100, 50).release().build().perform();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(_globalDriver.findElement(By.id("resizable")).getSize().getWidth());
        Assert.assertEquals(_globalDriver.findElement(By.id("resizable")).getSize().getWidth(), width + 100);//max width
        Assert.assertEquals(_globalDriver.findElement(By.id("resizable")).getSize().getHeight(),  height + 50);//max height
    }
    @Test
    public void AccordionDF(){
        //click accordion
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[1]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[1]/div/iframe")));
        //click section 2
        _globalDriver.findElement(By.xpath("/html/body/div/h3[2]/span")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // get text and assert it
        String displayedText = _globalDriver.findElement(By.xpath("/html/body/div/div[2]/p")).getText();
        Assert.assertEquals(displayedText, "Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.");
        //click on section 3
        _globalDriver.findElement(By.xpath("/html/body/div/h3[3]/span")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //assert text
        displayedText = _globalDriver.findElement(By.id("ui-id-6")).getText();
        Assert.assertEquals(displayedText, "Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.\n" +
                "List item one\n" +
                "List item two\n" +
                "List item three");
        //click section 4
        _globalDriver.findElement(By.xpath("/html/body/div/h3[4]/span")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //assert text
        displayedText = _globalDriver.findElement(By.id("ui-id-8")).getText();
        Assert.assertEquals(displayedText, "Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est.\n" +
                //"\n" +
                "Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.");

    }
    @Test
    public void AccordionCutomizeIcons(){
        //click accordion
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div[2]/ul/li[1]")).click();
        _globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[1]/ul/li[2]")).click();
        //switch frame
        _globalDriver.switchTo().frame(_globalDriver.findElement(By.xpath("/html/body/section/div[1]/div[1]/div[3]/div[2]/div/iframe")));
        Assert.assertNotNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[1]/span")));
        Assert.assertNotNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[2]/span")));
        Assert.assertNotNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[3]/span")));
        Assert.assertNotNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[4]/span")));
        //click toggle

        _globalDriver.findElement(By.xpath("/html/body/button")).click();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[1]/span")));
        Assert.assertNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[2]/span")));
        Assert.assertNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[3]/span")));
        Assert.assertNull(_globalDriver.findElement(By.xpath("/html/body/div/h3[4]/span")));
    }

}
