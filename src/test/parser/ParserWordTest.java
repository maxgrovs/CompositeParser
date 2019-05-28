package test.parser;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.parser.ParserWord;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.dataprovider.DataProviderForTest;


public class ParserWordTest {

    private String text = "task-2";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataWord")
    public void testParse(int index, String expected) {
        Component composite = (new ParserWord()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}