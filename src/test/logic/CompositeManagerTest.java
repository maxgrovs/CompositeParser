package test.logic;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.logic.CompositeManager;
import by.anelkin.task2.parser.ParserParagraph;
import by.anelkin.task2.parser.ParserText;
import by.anelkin.task2.parser.ParserWord;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.dataprovider.DataProviderForTest;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CompositeManagerTest {
    private String text = "Very long sentence. Shortest. Longer one.";
    private CompositeManager manager = new CompositeManager();

    @Test(dataProviderClass = DataProviderForTest.class, dataProvider = "getDataSortComponents")
    public void testSortComponents(int index, String expected) {
        Component paragraph = (new ParserParagraph()).parse(text);
        manager.sortComponents((Composite) paragraph);

        String actual = ((Composite) paragraph).getComponents().get(index).toString();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortWordsByLength() {
        Component textComposite = (new ParserText()).parse(text);
        ParserWord parserWord = new ParserWord();

        List<Component> expected = new ArrayList<>();
        expected.add(parserWord.parse("one"));
        expected.add(parserWord.parse("Very"));
        expected.add(parserWord.parse("long"));
        expected.add(parserWord.parse("Longer"));
        expected.add(parserWord.parse("sentence"));
        expected.add(parserWord.parse("Shortest"));

        List<Component> actual = manager.sortWordsByLength((Composite) textComposite);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortWordsInWord() {
        ParserWord parserWord = new ParserWord();
        Component wordComposite = parserWord.parse("something");

        List<Component> expected = new ArrayList<>();
        expected.add(parserWord.parse("something"));

        List<Component> actual = manager.sortWordsByLength((Composite) wordComposite);

        Assert.assertEquals(actual, expected);
    }
}