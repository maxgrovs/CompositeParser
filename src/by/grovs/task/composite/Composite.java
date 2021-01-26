package by.grovs.task.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    private ComponentType type;

    //enum с типами Composite и регулярками:
    public enum ComponentType {
        WORD(".*[A-z0-9_]"),
        LEXEMA("[^ \n\t]+"),
        SENTENSE("(.+?[.!?\\u2026][ \n\t])|(.+?[.!?\u2026])"),
        PARAGRAPH("[^\n\r]+"),
        TEXT(".*");

        private String REGEXP;

        ComponentType(String REGEXP) {
            this.REGEXP = REGEXP;
        }

        public String getREGEXP() {
            return REGEXP;
        }
    }


    public Composite(ComponentType type) {
        this.type = type;
    }


    @Override
    public boolean add(Component component) {
        return components.add(component);
    }

    @Override
    public boolean remove(Component component) {
        return components.remove(component);
    }

    @Override
    public String toString() {
        String result = restoreTextFromChain(new StringBuilder(), this).trim();
        return result;
    }


    private String restoreTextFromChain(StringBuilder restoredText, Component composite) {
        //если символ то возвращаем его значение
        if (composite instanceof Symbol) {
            return (String.valueOf(((Symbol) composite).getValue()));
        }
        //рекурсия по композиту
        List<Component> components = ((Composite) composite).getComponents();
        for (Component component : components) {
            restoredText.append(restoreTextFromChain(new StringBuilder(), component));
        }
        //добавляем пробелы и абзацы
        ComponentType type = ((Composite) composite).getType();
        switch (type) {
            case LEXEMA:
                restoredText.append(" ");
                break;
            case PARAGRAPH:
                //меняю лишний пробел после последнего предложения в абзаце (он появляется при сборке после лексемы):
                restoredText = restoredText.replace(restoredText.length() - 1, restoredText.length(), "\n");
        }
        return restoredText.toString();
    }


    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(getComponents(), composite.getComponents()) &&
                getType() == composite.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComponents(), getType());
    }
}

