package test.reader;

import by.anelkin.task2.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextReaderTest {
    private TextReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new TextReader();
    }

    @Test
    public void testRead() {
        int expected= 715;
        int actual = reader.read("data/task_example").length();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDefaultRead() {
        int expected= 114;
        int actual = reader.read("wrong path").length();

        Assert.assertEquals(actual, expected);
    }


}