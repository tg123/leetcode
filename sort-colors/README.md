## A sad tale

Arrays.sort would be O(nlgn).


## Loop invariant

### Two colors (Red White)

Like insertion sort, there is a wall. Colors on the left side of the wall are sorted, on the right side are unsorted.

In this case, there is also a good news. No need to find the inserting position. 
The sorting process is like that taking all the `red` color out from the colors, and the rest of colors must be `white`.
So just combine `red` and `white`.


#### Use no extra space to put the `red` colors.

In another word, do the sort in place.

let an variable to store the `wall`'s pointer, offset less than the `wall` should be `red` in the input array. When a new `red` color comes, increase the `wall`'s pointer and swap what the `wall` points to (`must be white`) and the new `red` color.

```
[ r w r w r w ] 

  ^   ^
  W   p


red found on p

swap

[ r w r w r w ] 

    ^ ^
    W p


increase wall pointer

[ r w r w r w ] 

    ^ ^
    W p

red found on p

swap

[ r r w w r w ] 

    ^ ^
    W p


loop ...
```

### Three Colors

When `blue` was added, just add a new `wall` for reserving `blue` at the end of the input array.


```
blue found on p

[ r r w b w b r w b] 

    ^   ^         ^
    W   p         B


swap

[ r r w b w b r w b] 

    ^   ^         ^
    W   p         B


increase B's wall

[ r r w b w b r w b] 

    ^   ^       ^
    W   p       B
    
swap

[ r r w w w b r b b] 

    ^   ^       ^
    W   p       B

loop...
```




