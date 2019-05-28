package by.anelkin.task2.parser;

import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.reader.TextReader;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.anelkin.task2.composite.Composite.ComponentType.*;


public class ParserSentence implements ParserComposite {
    private ParserComposite nextParser = new ParserLexema();
    private static final Logger logger = Logger.getLogger(TextReader.class);

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite(SENTENSE);
        if (text == null) {
            logger.warn("Incorrect text value (null)!");
            return composite;
        }
        Pattern pattern = Pattern.compile(LEXEMA.getREGEXP());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String lexema = matcher.group();
            Composite compositeLexema = nextParser.parse(lexema);
            composite.add(compositeLexema);
        }
        return composite;
    }

    public ParserComposite getNextParser() {
        return nextParser;
    }

    public void setNextParser(ParserComposite nextParser) {
        this.nextParser = nextParser;
    }
}
