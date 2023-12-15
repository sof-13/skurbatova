import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class map<K, V> implements IMap<K, V> {
    ArrayList<KeyValue> kv = new ArrayList<>();
    int size = kv.size();

    @Override
    public void add(K key, V value) {
        boolean keyExists = false;
        for (KeyValue i: kv) {
            if (i.getKey().equals(key)) {
                i.setValue(value);
                keyExists = true;
            }
        }
        if (!keyExists) {
            kv.add(new KeyValue<K, V>(key, value));
            size++; }
    }

    @Override
    public V get(K key) {
        ArrayList<V> values = new ArrayList<>();
        for (KeyValue i: kv) {
            if (i.getKey().equals(key)) {
                values.add((V) i.getValue());
            }
        }
        return (V) values;
    }

    @Override
    public Set<K> getAll() {
        Set<K> keys = new HashSet<>();
        for (KeyValue i: kv) {
            keys.add((K) i.getKey());
        }
        return keys;
    }

    @Override
    public boolean remove(K key) {
        Iterator<KeyValue> iterator = kv.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            KeyValue kv = iterator.next();
            if (kv.getKey().equals(key)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean removeAll(V value) {
        Iterator<KeyValue> iterator = kv.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            KeyValue kv = iterator.next();
            if (kv.getValue() == value) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public int getSize() {
        return size;
    }
}
