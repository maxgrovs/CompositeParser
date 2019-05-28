package test.parser;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.parser.ParserLexema;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.dataprovider.DataProviderForTest;


public class ParserLexemaTest {

    private String text = "!*numbers-04*.";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataLexemaParts")
    public void testParse(int index, String expected) {
        Component composite = (new ParserLexema()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}