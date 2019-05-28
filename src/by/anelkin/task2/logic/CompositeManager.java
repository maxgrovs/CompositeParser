package by.anelkin.task2.logic;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static by.anelkin.task2.composite.Composite.*;


public class CompositeManager {
    private static final Logger logger = Logger.getLogger(CompositeManager.class);

    //все случаи кроме сортировки слов по длине проходят тут:
    public void sortComponents(Composite composite) {
        if (composite != null) {
            composite.getComponents().sort(Comparator.comparing(component -> ((Composite) component).getComponents().size()));
        }else {
            logger.warn("Attempt to sort composite = null!");
        }
    }

    // метод вернет сортированный список слов из композита любого уровня:
    public List<Component> sortWordsByLength(Composite composite) {
        List<Component> words = new ArrayList<>();
        if (composite == null) {
            logger.warn("Attempt to sort words in composite = null!");
            return words;
        }

        ComponentType type = composite.getType();
        List<Component> lexems = new ArrayList<>();

        // заполняем список всех лексем внутри композита:
        switch (type) {
            case WORD:
                //если word  то его и вернем
                words.add(composite);
                break;
            case LEXEMA:
                lexems.add(composite);
                break;
            case SENTENSE:
                lexems.addAll(composite.getComponents());
                break;
            case PARAGRAPH:
                composite.getComponents().forEach(sentence -> lexems.addAll(((Composite) sentence).getComponents()));
                break;
            case TEXT:
                composite.getComponents().forEach(paragraph -> ((Composite) paragraph).getComponents()
                        .forEach(sentence -> lexems.addAll(((Composite) sentence).getComponents())));
        }

        //добавляем в список words только слова изнутри лексем:
        lexems.forEach(lexema -> words.addAll(((Composite) lexema).getComponents().stream()
                .filter(part -> part instanceof Composite)
                .collect(Collectors.toList())));

        //сортируем слова по длине
        words.sort(Comparator.comparing(word -> ((Composite) word).getComponents().size()));
        return words;
    }
}