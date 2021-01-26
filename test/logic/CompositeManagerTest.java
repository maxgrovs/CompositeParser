package logic;

import by.grovs.task.composite.Component;
import by.grovs.task.composite.Composite;
import by.grovs.task.logic.CompositeManager;
import by.grovs.task.parser.ParserParagraph;
import by.grovs.task.parser.ParserText;
import by.grovs.task.parser.ParserWord;
import dataprovider.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

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