## [Transpose](http://en.wikipedia.org/wiki/Transpose) then Reverse

You must know this method, or it is difficult.

```
+---+---+
| 1 | 2 |
+---+---+
| 3 | 4 |
+---+---+
```

Transpose: reflect the matrix over the main diagonal.


```
Before

+          
 +---+---+
 | + | 2 |
 +---+---+
 | 3 | + |
 +---+---+
          +

After

+          
 +---+---+
 | 1 | 3 |
 +---+---+
 | 2 | 4 |
 +---+---+
          +
```

Reverse: exchange each number along the vertical line in the middle

```
Before

    |
+---+---+
| 1 | 3 |
+---+---+
| 2 | 4 |
+---+---+
    |


After

    |
+---+---+
| 3 | 1 |
+---+---+
| 4 | 2 |
+---+---+
    |

```
