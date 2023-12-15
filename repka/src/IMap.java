import java.util.Set;

public interface IMap<K, V> {
    void add(K key, V value);

    V get(K key);

    Set<K> getAll();

    boolean remove(K key);

    boolean removeAll(V value);

    int getSize();
}

