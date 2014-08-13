## Nightmare version of [Word Ladder](../word-ladder)

 * Trace back

  In this case you need to output the path, so we need to rememeber the path using something like linked list.
 
 * Break after first meet the end

  I did not notice that the prolem is asking that `find all shortest transformation sequence(s) from start to end`. 
  I try to ouput all the transformation, and I got a time limited.
  
 * Duplicates blocking
   
  Since we need to output all the transformations, we can NOT block the connected words as soon as we meet them.
  The blocked words would take effect at next level.


  Bad case
  
```
"red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]


Queue Item

[
"red" -> "ted",
"red" -> "rex"
]

```

The first item `"red" -> "ted"` poll from queue and became `"red" -> "ted" -> "tex"`, If we block `"tex"` immediately, the `"red" -> "rex" -> "tex"` will be lost.

As a result, we should delay blocking `"tex"` until next level.
