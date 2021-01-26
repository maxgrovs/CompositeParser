package dataprovider;


import org.testng.annotations.DataProvider;

public class DataProviderForTest {
    private String text = "Test (some) \"text\".\n" +
            "Some _numbers: 35.5, -1,987. *Else: 0, 354, 578.\n" +
            "Very-very long sentence a:1 b2 c_3 d-4 e*5.";


    @DataProvider(name = "getDataParagraphs")
    public static Object[][] getDataParagraphs(){
        return new Object[][]{
                {0, "Test (some) \"text\"."},
                {1, "Some _numbers: 35.5, -1,987. *Else: 0, 354, 578."},
                {2, "Very-very long sentence a:1 b2 c_3 d-4 e*5."},
        };
    }

    @DataProvider(name = "getDataSentences")
    public static Object[][] getDataSentences(){
        return new Object[][]{
                {0, "Some _numbers: 35.5, -1,987."},
                {1, "*Else: 0, 354, 578."},
                {2, "Test (some) \"text\"."},
        };
    }

    @DataProvider(name = "getDataLexems")
    public static Object[][] getDataLexems(){
        return new Object[][]{
                {0, "Some"},
                {1, "_numbers:"},
                {2, "35.5,"},
                {3, "-1,987."},
        };
    }

    @DataProvider(name = "getDataLexemaParts")
    public static Object[][] getDataLexemaParts(){
        return new Object[][]{
                {0, "!"},
                {1, "*"},
                {2, "numbers-04"},
                {3, "*"},
                {4, "."},
        };
    }

    @DataProvider(name = "getDataWord")
    public static Object[][] getDataWord(){
        return new Object[][]{
                {0, "t"},
                {1, "a"},
                {2, "s"},
                {3, "k"},
                {4, "-"},
                {5, "2"},
        };
    }

    //"Very long sentence. Shortest. Longer one."
    @DataProvider(name = "getDataSortComponents")
    public static Object[][] getDataSortComponents(){
        return new Object[][]{
                {0, "Shortest."},
                {1, "Longer one."},
                {2, "Very long sentence."},
        };
    }
}
