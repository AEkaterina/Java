import by.Astapkina.Manufacturer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.*;


public class testManuf {
    Manufacturer manufacturer1 = new Manufacturer(91, "Podarki", "Russia");

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite запускается перед выполнением всех тестов");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite запускается после выполения всех тестовых методов в Suite");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass запускается перед выполнением тестовых методов в текущем классе");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass будет выполнен после вызова всех тестовых методов текущего класса");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest будет выполняться первым перед любым тестом, принадлежащим этой папке");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest будет запущен после запуска всех тестовых методов, принадлежащих классам внутри тега <test>");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("AfterGroups");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Аннотированный метод будет запускаться перед каждым тестовым методом.");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Аннотированный метод будет запускаться после каждого метода тестирования.");
    }

    //тест конструктора
    @Test
    public void tetsObject() {          //метод вполнюящий проверку
        try {
            if(manufacturer1 == null)
                throw new NullPointerException();
            Assert.assertEquals(manufacturer1.getName(), "Podarki");            //assert проверяет правильность работы метода
            Assert.assertEquals(manufacturer1.getCountry(), "Russia");
            Assert.assertEquals(manufacturer1.getRequisites(), 91);
            System.out.println("@Test");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Ex() {
        Assert.fail();
    }

    //timeout
    @Test(timeout = 100)
    public void waitTime() throws Exception {
        Thread.sleep(1001);
        System.out.println("Ignored");
    }

    @Test
    public void testGetRequisites() {
        var res = manufacturer1.getRequisites();
        Assert.assertEquals(91, res);
    }

    @Test(timeout = 100)
    public void testGetName() {
        var res = manufacturer1.getName();
        Assert.assertEquals("Podarki", res);
    }

    @Test(groups={"unit1"})
    public void testExample5() {
        System.out.println("testingMethod5");
    }

    @Test(groups={"unit1", "unit2"})
    public void rtestExample5() {
        System.out.println("testingMethod5");
    }


/*
    @Test(value = {"Group"})
    public void test1Group(){
        System.out.println("method 1 test in group");
    }
    @Test(groups = {"Group"})
    public void test2Group(){
        System.out.println("method 2 test in group");
    }
    @Test(dependsOnGroups = "Group")
    public void testGroup(){
        System.out.println("Group test");
    }
*/
}
