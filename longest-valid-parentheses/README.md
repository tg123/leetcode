## Counting while [Valid Parentheses](../valid-parentheses)

When a pair of valid parentheses is found, just add `2` to count.

However, the counting method is a bit tricky. Show you using animation

### Animation

This method adds a counting stack.

```
input [ ( ( ) ( ) ) ]

count []
stack []
 
       i

```

No match put `)` and `(` into stack

```
input [ ) ( ) ) ]

count [ 0 0 ]
stack [ ( ( ]
 
          i

```



found matches pop stack and `count[1] =  count[1] + 2`

```
input [ ( ) ) ]

count [ 0 2 ]
stack [ ( ]
 
        i

```

just two steps.

found another matches `(` and `)` pop stack and `count[1] =  count[1] + 2`

```
input [ ]

count [ 0 4 ]
stack [ ]
 
        i

```


found matches, but, this time, `count[0] =  count[0] + 2` is not enough.

It should be `count[0] =  count[0] + 2 + count[1]`, because that here `0` matches parentheses indicates that the current parentheses is enclosing the `1..current`.


Generally, when meets a match,

```
count[stack.size()] =  count[stack.size()] + 2 + count[stack.size() + 1]
```

then reset the `count[stack.size() + 1]` to `0`.

