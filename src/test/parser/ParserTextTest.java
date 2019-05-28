package test.parser;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.parser.ParserText;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.dataprovider.DataProviderForTest;

import static org.testng.Assert.*;

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