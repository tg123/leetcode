## Wheel

Java do have LRU Cache in JDK,
we used to call it `LinkedHashMap`

code from JDK 1.6

```    
    /**
     * Constructs an empty <tt>LinkedHashMap</tt> instance with the
     * specified initial capacity, load factor and ordering mode.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @param  accessOrder     the ordering mode - <tt>true</tt> for
     *         access-order, <tt>false</tt> for insertion-order
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public LinkedHashMap(int initialCapacity,
			 float loadFactor,
                         boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }
```

here the parameter `accessOrder` can be used to refresh newly accessed value

and

override

```
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return false;
    }
```
to remove old entry


## DIY

I'd not do this at work. but it is a good chance to learn and practice writing a `HashMap`

### HashMap 

 * Storing data

   1. use an array Entry[] to store the data
   1. `put` Entry[hash(key)] = value
   1. `get` return Entry[hash(key)]


 * Dealing with hash conflict
     
   1. add next pointer to Entry in order to store key with same hash
   1. `put` add to Entry.next
   1. `get` search through the linked list and if equals then retun Entry.value
   
 * Good news: no need to expand space if no enough space

### Remember the order

 * Move any element to the top (`get`, `put`) 
 * Remove the element on the tail (`put`)

To achieve above, just threading each Entry to a doubly linked list.


## Put them together

```
Entry { key, value, hashnext, linknext, linkprev }
```

### GET(k)

```

foreach E linked list Entry[hash(k)]
    if E.key == k
        moveToLinkTop(E)
        return E.value

not found

```

### PUT(k, v)

```

if over capacity
    E = tail of doubly linked list
    remove E from linked list Entry[hash(E.key)] 

E = E(k,v)

add E to linked list Entry[hash(E.key)] 
moveToLinkTop(E)

```


