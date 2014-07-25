## Each element is either in the subset or not

 * `*`: element is in subset
 * `-`: element NOT in subset

so subsets of `[1,2,3]` are


```
[-,-,*] = [3]
[*,-,-] = [1]
[-,*,-] = [2]
[*,*,*] = [1,2,3]
[*,-,*] = [1,3]
[-,*,*] = [2,3]
[*,*,-] = [1,2]
[-,-,-] = []

```

some brute force codes may look like a DFS


```

search(pos)
     
    if found
        output
    
    for state in IN, NOT_IN
       if IN
          subset[pos] = current element
       else
          subset[pos] = nothing
          
       search(pos + 1)
          

```

## Binary

use binary to repsent only two states


```
001 = [3]
100 = [1]
010 = [2]
111 = [1,2,3]
101 = [1,3]
011 = [2,3]
110 = [1,2]
000 = []
```

binary => decimal (000 .. 111 => 0 .. 7)


```
for i 0 .. 2^n - 1
    b = convert i to binary
    
    subset = select elements using b
    
    yield subset
```



