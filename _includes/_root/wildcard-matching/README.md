## Convert to [Regular Expression Matching](../regular-expression-matching)

 * `?` -> `.`
 * `*` -> `.*`

This should work, yet, it exceeds the time limited. 

## Checkpoint / Timemachine

On modern OS, you can go back to some time you saved if your OS meets some problem.
such technology also can be used to solve this problem.

```
    S
 
[ a a b ]
 
[ a * b * ]
 
    P
 
 
P is *, save current state. 
```

`P` goes on to next

```

This state means * matches nothing

    S
 
[ a a b ]
 
[ a * b * ]
 
      P

```

a mismatch found, `P != S`, so rollback to checkpoint.

```
This state means * matches a

      S
 
[ a a b ]
 
[ a * b * ]
 
      P
```

Each `*` will save to a checkpoint, and retry from nothing until a match is found.


### Remaining tail

Sometimes, `S` meets the end, but the `P` not. 
In this case, just to check remaining chars in `P` are all `*`.
