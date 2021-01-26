package parser;

import by.grovs.task.composite.Component;
import by.grovs.task.composite.Composite;
import by.grovs.task.parser.ParserWord;
import dataprovider.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ParserWordTest {

    private String text = "task-2";

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataWord")
    public void testParse(int index, String expected) {
        Component composite = (new ParserWord()).parse(text);
        String actual = ((Composite) composite).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }
}