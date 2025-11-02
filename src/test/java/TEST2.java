import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TEST2 {

    @Parameters("testData3")
    @Test
    public void thirdTest(@Optional("Defaultdata3") String testDataFromXML) {
        String finalTestData = System.getProperty("testData3");
        if (finalTestData == null || finalTestData.isEmpty()) {
            finalTestData = testDataFromXML;
        }
        System.out.println("third test: " + finalTestData);
    }

    @Parameters("testData4")
    @Test
    public void fourthTest(@Optional("Defaultdata4") String testDataFromXML) {
        String finalTestData = System.getProperty("testData4");
        if (finalTestData == null || finalTestData.isEmpty()) {
            finalTestData = testDataFromXML;
        }
        System.out.println("fourth test: " + finalTestData);
    }
}
