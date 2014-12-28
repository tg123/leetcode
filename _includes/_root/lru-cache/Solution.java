public class LRUCache {
    
    static class Entry {
        int key;
        int value;

        Entry hashnext;
        
        Entry linknext;
        Entry linkprev;
    }
    
    Entry[] data;
    
    int capacity;
    int size;
    
    Entry head;
    Entry tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new Entry[capacity + capacity/2 + 3];
        size = 0;
        
        head = new Entry();
        tail = new Entry();
        
        head.linknext = tail;
        tail.linkprev = head;
    }

    int hash(int key){
        return key % capacity;
    }
    
    void moveToHead(Entry e){
        
        Entry before = e.linkprev;
        Entry after  = e.linknext;
        
        before.linknext = after;
        after.linkprev  = before;
        
        addBeforeHead(e);
    }
    
    void addBeforeHead(Entry e){
        Entry chead = head.linknext;
        chead.linkprev = e;
        head.linknext = e;
        
        e.linkprev = head;
        e.linknext = chead;
    }

    Entry _get(int key){
        int h = hash(key);
        Entry e = data[h];
        
        while(e != null){
            if(e.key == key){
                moveToHead(e);
                return e;
            }
            
            e = e.hashnext;
        }
        
        return null;        
    }

    public int get(int key) {
        Entry e = _get(key);
        
        if(e == null){
            return -1;
        }
        
        return e.value;
    }
    
    void removeOneFromTail(){
        Entry e = tail.linkprev;
        
        tail.linkprev = e.linkprev;
        tail.linkprev.linknext = tail;
        
        int h = hash(e.key);
        
        Entry d = data[h];
        
        if(d == e || d.key == e.key){
            data[h] = e.hashnext;
            return;
        }
        
        Entry p = d;
        d = d.hashnext;
        
        while(d != null){
            
            if(d == e){
                p.hashnext = e.hashnext;
                return;
            }
            p = d;
            d = d.hashnext;
        }
        
    }
    
    public void set(int key, int value) {
        if(capacity == 0) return;
        
        Entry e = _get(key);
        if(e != null){
            e.value = value;
            return;
        } 
        
        if(size >= capacity){
            removeOneFromTail();
            size--;
        }
        
        e = new Entry();
        
        e.key = key;
        e.value = value;
        
        addBeforeHead(e);
        
        int h = hash(e.key);
        Entry d = data[h];
        
        if(d == null){
            data[h] = e;
        } else {
            while(d.hashnext != null){
                d = d.hashnext;
            }
            
            d.hashnext = e;
        }
        
        size++;
        
    }
}