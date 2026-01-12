package Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DataPool<T> {
    private List<T> items;

    public DataPool() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public T getById(int id) {
        return items.stream()
                .filter(item -> {
                    try {
                        var idField = item.getClass().getMethod("getId");
                        return (int)idField.invoke(item) == id;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .findFirst()
                .orElse(null);
    }


    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }


    public T search(Predicate<T> predicate) {
        return items.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}