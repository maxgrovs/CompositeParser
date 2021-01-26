package parser;

import by.grovs.task.composite.Component;
import by.grovs.task.composite.Composite;
import by.grovs.task.parser.ParserSentence;
import dataprovider.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParserSentenceTest {
    private String text = "Some _numbers: 35.5, -1,987.";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataLexems")
    public void testParse(int index, String expected) {
        Component composite = (new ParserSentence()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}