## Looks like [Trapping Rain Water](../trapping-rain-water)

```
[2, 1, 5, 6, 2, 3]

            +---+        
            |   |        
        +---+---+        
        |   |   |        
        +---+---+        
        |   |   |        
        +---+---+   +---+
        |   |   |   |   |
+---+   +---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+

  2   1   5   6   2   3    [ Height ]
  0   1   2   3   4   5    [ Index  ]

```

[Loop invariant](http://en.wikipedia.org/wiki/Loop_invariant) with Stack/Queue

In this case, we store the bars in non-descending order.
If any new bar breaks the order, we are sure that the heights of rectangles formed by the non-descending order bars have nothing to do with the new bar.

In another words, we can now count the rectangles' area and update the max.

Then, pack all saved bar into a dwarf but long one. 
Imagine that there would be a dwarf but long one which could win the max rectangle prize.

e.g.

```
[5, 6, 2, 3] 


    +---+
    |   |
+---+---+
|   |   |
+---+---+
|   |   |
+---+---+   +---+
|   |   |   |   |
+---+---+---+---+
|   |   |   |   |
+---+---+---+---+
|   |   |   |   |
+---+---+---+---+

  0   1   2   3    [ Index  ]


```

No matter what the height the bar `3` is, rectangles formed by bar `0..3` can not benefit form the height of bar `3`.

Meanwhile, It is time to calculate the rectangles' area formed bar `0..2`.


## Animation

a `bar` is like


```
Bar { height, width }
```

new bar's height is `2` put it into storage

```
Storage:

[{height=2, width=1}]









+---+
|   |
+---+
|   |
+---+
```

new bar's height is `1`, less than `2`, so count rectangles now.

```









+---+
|   |
+---+---+
|   |   |
+---+---+
  0   1    [Index]
```

2 rectangles formed by bar `0..1`, the max area is `2`

Then, pack those bars into one. 

```
Storage: 
[{height=1, width=2}]










+-------+
|       |
+-------+

    0      [ Index  ]

```

new bars with height `5` and `6`

```
Storage:
[{height=1, width=2}, {height=5, width=1}, {height=5, width=1}]

            +---+
            |   |
        +---+---+
        |   |   |
        +---+---+
        |   |   |
        +---+---+
        |   |   |
        +---+---+
        |   |   |
+-------+---+---+
|       |   |   |
+-------+---+---+

    0     1   2     [ Index  ]

```

new bar with height `2`, it is time to update max.

```
Storage:
[{height=1, width=2}, {height=5, width=1}, {height=5, width=1}]

            +---+
            |   |
        +---+---+
        |   |   |
        +---+---+
        |   |   |
        +---+---+
        |   |   |
        +---+---+---+
        |   |   |   |
+-------+---+---+---+
|       |   |   |   |
+-------+---+---+---+

    0     1   2   3   [ Index  ]
```

rectangles are `6 * 1`, `5 * 2` , `1 * 4`.

Pack them again.

```
Storage:
[{height=1, width=2}, {height=2, width=3}]









        +-----------+
        |           |
+-------+-----------+
|       |           |
+-------+-----------+

    0        1           [ Index  ]
```

new bar with height `3`


```
Storage:
[{height=1, width=2}, {height=2, width=3}, {height=3, width=1}]







                    +---+
                    |   |
        +-----------+---+
        |           |   |
+-------+-----------+---+
|       |           |   |
+-------+-----------+---+

    0        1        2      [ Index  ]
```

### Deal with left-overs

Fire another area calculating is ok. 
But, a more elegant method is that you can add a fake bar with height `0`.


`Simple is better than complex.  -- Zen of Python`





