package parser;

import by.grovs.task.composite.Component;
import by.grovs.task.composite.Composite;
import by.grovs.task.parser.ParserText;
import dataprovider.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParserTextTest {
        private String text = "Test (some) \"text\".\n" +
                "Some _numbers: 35.5, -1,987. *Else: 0, 354, 578.\n" +
                "Very-very long sentence a:1 b2 c_3 d-4 e*5.";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataParagraphs")
    public void testParse(int index, String expected) {
        Component composite = (new ParserText()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}