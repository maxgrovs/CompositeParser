package test.parser;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.parser.ParserSentence;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.dataprovider.DataProviderForTest;


public class ParserSentenceTest {
    private String text = "Some _numbers: 35.5, -1,987.";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataLexems")
    public void testParse(int index, String expected) {
        Component composite = (new ParserSentence()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}