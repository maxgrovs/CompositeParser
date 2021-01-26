package parser;

import by.grovs.task.composite.Component;
import by.grovs.task.composite.Composite;
import by.grovs.task.parser.ParserParagraph;
import dataprovider.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParserParagraphTest {
    private String text = "Some _numbers: 35.5, -1,987. *Else: 0, 354, 578. Test (some) \"text\".\n";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataSentences")
    public void testParse(int index, String expected) {
        Component composite = (new ParserParagraph()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}