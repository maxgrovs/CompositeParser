package test.parser;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.parser.ParserParagraph;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.dataprovider.DataProviderForTest;


public class ParserParagraphTest {
    private String text = "Some _numbers: 35.5, -1,987. *Else: 0, 354, 578. Test (some) \"text\".\n";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataSentences")
    public void testParse(int index, String expected) {
        Component composite = (new ParserParagraph()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}