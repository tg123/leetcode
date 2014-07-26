## Tricky bit manipulation

I have no idea at first, and search for the answer. The solution is using a tricky bit manipulation of `XOR`.

`XOR` will set same bit to `0`, otherwise `1`. so if a number appear even number times, `XOR` will erase it.

e.g.

`[1,2,3,4,1,2,3]` in binary form of


```
0 0 0 1
0 0 1 0 
0 0 1 1 
0 1 0 0
0 0 0 1
0 0 1 0
0 0 1 1

count 0 and 1

0 1 4 4 

```

then remove the even number in `0 1 4 4` to `0`. the number becomes `0 1 0 0` in decimal form (4).

