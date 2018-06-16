package eu.mihau.randomlist.viewmodel;

import eu.mihau.randomlist.model.Element;

public class RandomEvent {

    public Type type;
    public Integer index;
    public Element element;

    public RandomEvent(Type type, Integer index, Element element) {
        this.type = type;
        this.index = index;
        this.element = element;
    }

    public enum Type {
        CREATE, UPDATE, DELETE, CLEAR
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) return false;

        RandomEvent searchEvent = (RandomEvent) o;
        return type.equals(searchEvent.type) &&
                index.equals(searchEvent.index) &&
                element.equals(searchEvent.element);
    }

    @Override
    public int hashCode() {
        return 6 * type.hashCode() +
                6 * index.hashCode() +
                6 * element.hashCode();
    }
}
