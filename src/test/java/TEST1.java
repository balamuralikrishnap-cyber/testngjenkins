import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TEST1 {

    @Parameters("testData1")
    @Test
    public void firstTest(@Optional("Defaultdata1") String testDataFromXML) {
        // 1. Check Maven -D parameter first
        String finalTestData = System.getProperty("testData1");
        // 2. If not set, use TestNG XML parameter
        if (finalTestData == null || finalTestData.isEmpty()) {
            finalTestData = testDataFromXML;
        }
        System.out.println("first test: " + finalTestData);
    }

    @Parameters("testData2")
    @Test
    public void secondTest(@Optional("Defaultdata2") String testDataFromXML) {

        String finalTestData = System.getProperty("testData2");
        if (finalTestData == null || finalTestData.trim().isEmpty()) {
            finalTestData = testDataFromXML;
        }
        System.out.println("second test: " + finalTestData);

    }
}
