package by.anelkin.task2.parser;

import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.composite.Symbol;
import by.anelkin.task2.reader.TextReader;
import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.anelkin.task2.composite.Composite.ComponentType.*;


public class ParserLexema implements ParserComposite {
    private final static String REGEXP_PUNCTUATION_BEGINNING = "^[^A-z0-9_]+";
    private ParserComposite nextParser = new ParserWord();
    private static final Logger logger = Logger.getLogger(TextReader.class);

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite(LEXEMA);
        if (text == null) {
            logger.warn("Incorrect text value (null)!");
            return composite;
        }
        // проверка пунктуации в начале (например: **example):
        Matcher punctuationStart = Pattern.compile(REGEXP_PUNCTUATION_BEGINNING).matcher(text);
        if (punctuationStart.find()) {
            String lexemaStart = punctuationStart.group();
            for (char symbol : lexemaStart.toCharArray()) {
                composite.add(new Symbol(symbol));
            }
            text = text.substring(lexemaStart.length());
        }
        //тут все символы, кроме пунктуации в конце лексемы:
        Matcher matcher = Pattern.compile(WORD.getREGEXP()).matcher(text);
        if (matcher.find()) {
            String word = matcher.group();
            Composite compositeWord = nextParser.parse(word);
            composite.add(compositeWord);
            text = text.substring(word.length());
        } else {
            //если лексема - это отдельностоящий знак/знаки
            return composite;
        }

        // внутри text остается пунктуация в конце лексемы (например: example". ):
        if (text.length() > 0) {
            for (char symbol : text.toCharArray()) {
                composite.add(new Symbol(symbol));
            }
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
