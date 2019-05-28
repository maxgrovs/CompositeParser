package test.composite;

import by.anelkin.task2.composite.Component;
import by.anelkin.task2.composite.Composite;
import by.anelkin.task2.composite.Symbol;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static by.anelkin.task2.composite.Composite.ComponentType.*;
import static org.testng.Assert.*;

public class CompositeTest {
    Composite lexema;

    @BeforeMethod
    public void setUp() {
        lexema = new Composite(LEXEMA);
        lexema.add(new Composite(WORD));
        lexema.add(new Symbol('!'));
    }

    @Test
    public void testAdd() {
        int expected = 2;
        int actual = lexema.getComponents().size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testRemove() {
        lexema.remove(new Symbol('!'));
        lexema.remove(new Composite(WORD));

        int expected = 0;
        int actual = lexema.getComponents().size();

        Assert.assertEquals(actual, expected);
    }

}