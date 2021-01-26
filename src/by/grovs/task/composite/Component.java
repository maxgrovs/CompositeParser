package by.grovs.task.composite;

public interface Component {

    boolean add(Component component);

    boolean remove(Component component);

    //восстановление текста из композита:
    String toString();
}
