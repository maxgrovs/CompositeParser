package by.grovs.task.parser;

import by.grovs.task.composite.Composite;
import by.grovs.task.composite.Symbol;
import by.grovs.task.reader.TextReader;
import org.apache.log4j.Logger;

import static by.grovs.task.composite.Composite.ComponentType.*;


public class ParserWord implements ParserComposite {
    private static final Logger logger = Logger.getLogger(TextReader.class);

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite(WORD);
        if (text == null){
            logger.warn("Incorrect text value (null)!");
            return composite;
        }
        char[] chars = text.toCharArray();
        for (char symbol : chars) {
            composite.add(new Symbol(symbol));
        }
        return composite;
    }
}
