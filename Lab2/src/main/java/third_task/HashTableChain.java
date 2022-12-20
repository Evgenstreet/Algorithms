package third_task;

public class HashTableChain{
    private static final int START_CAPACITY = 18;
    private Chain[] table;
    private int capacity;

    public double constOfKnut = 0.6180339887;

    public HashTableChain() {
        capacity = START_CAPACITY;
        table = new Chain[capacity];
        for (int i = 0; i < capacity; ++i) {
            table[i] = null;
        }
    }

    public HashTableChain(int capacity) {
        table = new Chain[capacity];
        this.capacity = capacity;
        for (int i = 0; i < this.capacity; i++) {
            table[i] = null;
        }
    }

    public void add(int key, int value) {
        final int hash = getHashKey(key);
        if (table[hash] == null) {
            table[hash] = new Chain(key, value);
        } else {
            Chain entry = table[hash];
            while (entry.getNext() != null && entry.getElement() != key) {
                entry = entry.getNext();
            }
            if (entry.getElement() == key) {
                entry.setValue(value);
            } else {
                entry.setNext(new Chain(key, value));
            }
        }
    }

    public void delete(int element) {
        final int hash = getHashKey(element);
        if (table[hash] != null) {
            Chain prevEntry = null;
            Chain entry = table[hash];
            while (entry.getNext() != null && entry.getElement() != element) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getElement() == element) {
                if (prevEntry == null) {
                    table[hash] = entry.getNext();
                } else {
                    prevEntry.setNext(entry.getNext());
                }
            }
        }
    }

    public Integer search(int element) {
        final int hash = getHashKey(element);
        if (table[hash] == null)
            return null;
        else {
            Chain entry = table[hash];
            while (entry != null && entry.getElement() != element) {
                entry = entry.getNext();
            }
            if (entry == null) {
                return null;
            } else {
                return entry.getValue();
            }
        }
    }
    public boolean isEmpty() {
        for (int i = 0; i < capacity; ++i) {
            final Chain entry = table[i];
            if (entry != null) {
                return false;
            }
        }
        return true;
    }

    public int getHashKey(int element){
        return (int)(START_CAPACITY*((constOfKnut*element)%1));
    }


    public String print() {
        final StringBuilder description = new StringBuilder("Hash table: [ ");
        for (int i = 0; i < capacity; i++) {
            description.append("{  ");
            if (table[i] != null) {
                Chain entry = table[i];
                do {
                    description.append(String.format("%d  ", entry.getValue()));
                    entry = entry.getNext();
                } while (entry != null);
            }
            description.append("} ");
        }
        description.append(']');
        return description.toString();
    }

    public void printNumOfCollision(){
        int count = 0;
        for (Chain chain : table) {
            int num = 1;
            if (chain != null) {
                Chain next = chain;
                while (next.getNext() != null) {
                    num++;
                    next = next.getNext();
                }
                if (num > 1) count++;
            }
        }
        System.out.println("Collision: " +count);
    }
    public void printMaxOfCollision(){
        int count = 0;
        for (Chain chain : table) {
            int num = 1;
            if (chain != null) {
                Chain next = chain;
                while (next.getNext() != null) {
                    num++;
                    next = next.getNext();
                }
                if (num > count) count = num;
            }
        }
        System.out.println("Max of Collision: " + count);
    }
}
