## Search from the borders

Determine an area is surrounded by `X` is not easy, but, it is easy to know how many `O`s are connected with borders. 

Mark all `O` connected with borders, then swap the `O`s to `X`.


## How to konw if an `O` if it is connected with borders

 * `O` on the borders are connected with borders
 * if an `O` is connected with border, `O`s on its top, bottom, left, right are connected with borders

We can do the DFS/BFS starting from `O` on the border, mark all `O` connected with them.



## Some Notes

I first write a DFS version, but leetcode rejected because of stackoverflow.
