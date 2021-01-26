package parser;

import by.grovs.task.composite.Component;
import by.grovs.task.composite.Composite;
import by.grovs.task.parser.ParserLexema;
import dataprovider.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ParserLexemaTest {

    private String text = "!*numbers-04*.";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataLexemaParts")
    public void testParse(int index, String expected) {
        Component composite = (new ParserLexema()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}