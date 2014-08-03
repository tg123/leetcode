## Guessing

```
1 1 1 1 1 1 1
0 0 0 0 1 0 0
1 1 0 1 0 1 0
1 1 0 1 1 1 0
1 1 1 1 0 1 0
1 0 0 1 0 1 0

```

I do not where to start and I can not even count how many rectangles are there.

The title reminds me that there is a problem called [Largest Rectangle in Histogram](../largest-rectangle-in-histogram).


## Histogram in the matrix

from the top to bottom, we can build histograms like below

```
1 1 1 1 1 1 1   a
0 0 0 0 2 0 0   b 
1 1 0 1 0 1 0   c
2 2 0 2 1 2 0   d
3 3 1 3 0 3 0   e
4 0 0 4 0 4 0   f

```

here means

 * `line a` has a set histograms with heights `1 1 1 1 1 1 1`
 * `line b` has a set histograms with heights `0 0 0 0 2 0 0`
 * `line c` has a set histograms with heights `1 1 0 1 0 1 0`
 * ...
 * `line f` has a set histograms with heights `4 0 0 4 0 4 0`

so we can call [Largest Rectangle in Histogram](../largest-rectangle-in-histogram) and update the max.


Similarly, from the left to right, we can also build  histograms like below


```
1 2 3 4 5 6 7
0 0 0 0 1 0 0
1 2 0 1 0 1 0
1 2 0 1 2 3 0
1 2 3 4 0 1 0
1 0 0 1 0 1 0

a b c d e f g
```


code may be like 


```

convert martix into histograms 

foreach h in histograms

  max = MAX(largestRectangleArea(h), max)


```
