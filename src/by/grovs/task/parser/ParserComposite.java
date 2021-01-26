package by.grovs.task.parser;

import by.grovs.task.composite.Composite;

public interface ParserComposite {
    Composite parse(String text);
}
