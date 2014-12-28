## Two Lists with same length


```

A:    a1 → a2
               ↘
                 c1 → c2 → c3
               ↗            
B:    b1 → b2


```

Use two `iter`s go through the list, and compare each `val`. It is easy to find out the intersection point.

## What if the length is not the same

Make them the same.

 * find out two lists' length
 * trim the longer one and remove the `overhead`
