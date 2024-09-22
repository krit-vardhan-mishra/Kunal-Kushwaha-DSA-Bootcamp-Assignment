import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Function;

public class CustomHashMap<K, V> implements Iterable<K> {

    private Entity<K, V>[] entities;
    private static final int INITITAL_CAPACITY = 16;
    private int size;

    @SuppressWarnings("unchecked")
    CustomHashMap() {
        entities = new Entity[INITITAL_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    CustomHashMap(CustomHashMap<K, V> obj) {
        this.entities = new Entity[obj.entities.length];

        for (int i = 0; i < obj.entities.length; i++) {
            Entity<K, V> current = obj.entities[i];
            if (current != null) {
                this.entities[i] = new Entity<>(current.key, current.value);
                Entity<K, V> newCurrent = this.entities[i];
                while (current.next != null) {
                    current = current.next;
                    newCurrent.next = new Entity<>(current.key, current.value);
                    newCurrent = newCurrent.next;
                }
            }
        }
    }

    public boolean clear() {
        for (int i=0; i<entities.length; i++) {
            entities[i] = null;
        }
        size = 0;
        return true;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % INITITAL_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        Entity<K, V> current = entities[hash];

        if (current == null) {
            entities[hash] = new Entity<>(key, value);
        } else {
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Entity<>(key, value);
        }
        size++;
    }

    public V get(K key) {
        int hash = hash(key);
        Entity<K, V> current = entities[hash];

        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }

        return null;
    }

    public void remove(K key) {
        int hash = hash(key);
        Entity<K, V> current = entities[hash];
        Entity<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    entities[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void replace(K key, V value) {
        int hash = hash(key);
        Entity<K, V> current = entities[hash];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
    }

    public void putIfAbsent(K key, V value) {
        int hash = hash(key);
        Entity<K, V> current = entities[hash];

        if (current == null) {
            put(key, value);
        } else {
            replace(key, value);
        }
    }

    // This method works same as putIfAbsent() method but unlike that it can have operations as a value.
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        V value = get(key);
        if (value != null) return value;

        V newValue = mappingFunction.apply(key);
        if (newValue != null) {
            put(key, newValue);
        }

        return newValue;
    }

    public V getOrDefault(K key, V defalutValue) {
        return (get(key) == null) ? defalutValue : get(key);
    }

    @Override
    public Iterator<K> iterator() {
        return new CustomHashMapIterator();
    }

    private class CustomHashMapIterator implements Iterator<K> {
        private int index = 0;
        private Entity<K, V> current = null;

        private void moveToNextEntity() {
            while (index < entities.length && entities[index] == null) {
                index++;
            }

            if (index < entities.length) current = entities[index];
            else current = null;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            K key = current.key;

            if (current.next != null) {
                current = current.next;
            } else {
                index++;
                moveToNextEntity();
            }

            return key;
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> res = new HashSet<>();
        return entrySet(res);
    }

    private Set<Map.Entry<K, V>> entrySet(Set<Map.Entry<K, V>> res) {
        
        for (int i=0; i<entities.length; i++) {
            Entity<K, V> current = entities[i];
            if (current != null) {
                while (current != null) {
                    res.add(new SimpleEntry<>(current.key, current.value));
                    current = current.next;
                }
            }
        }
        return res;
    }

    public String print() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean isFirst = true;

        for (int i=0; i<entities.length; i++) {
            Entity<K, V> current = entities[i];
            if (current != null) {
                while (current != null) {
                    if (!isFirst) sb.append(", ");

                    sb.append((current.key + " = " + current.value));
                    isFirst = false;
                    current = current.next;
                }
            }
        }
        sb.append("}");

        return sb.toString();
    }

    private static class Entity<K, V> {
        final K key;
        V value;
        Entity<K, V> next;

        Entity(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Seven");
        map.put(68, "Sixty-Eight");

        System.out.println("\nFirst Print :");
        System.out.println(map.print());
        System.out.println("Map Size : " + map.size());
        System.out.println("Map Contains Key 7 : " + map.containsKey(7));
        System.out.println("Map Is Empty : " + map.isEmpty());
        System.out.println("Map Get 4 : " + map.get(4));
        System.out.println("Map Get 5 : " + map.get(5));
        map.replace(4, "Four");
        map.putIfAbsent(5, "Five");
        map.remove(68);
        System.out.println("\nSecond Print :");
        System.out.println(map.print());
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        map.clear();
        System.out.println("Map Is Empty : " + map.isEmpty());
        System.out.println("\nThird Print :");
        System.out.println(map.print());
        System.out.println("\nList Iterator : ");
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        System.out.println("Entry Set : " + set);
        System.out.println(map.getOrDefault(4, "Nine"));
    }

}

