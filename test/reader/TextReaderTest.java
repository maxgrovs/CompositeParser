package reader;

import by.grovs.task.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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