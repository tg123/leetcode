## All break

Brute force is my favourite. However, `2 ^ n` seems a huge number.


## Something like [Jump Game II](../jump-game-ii)

That `s[0..i]` can be `break` indicates `s[i + each d in dict]` can be `break`.

Make a table `P`, such that, `P[i]` means if `s[0..i]` can be `break`.

```
dict { leet, code }

Table:

 0 1 2 3 4 5 6 7 8 Index
 * l e e t c o d e
 1 0 0 0 1 0 0 0 1

```

Calculating `P[i]`

```
dict { leet, code }

Table:

 0 1 2 3 4 5 6 7 8 Index
 * l e e t c o d e
 1 0 0 0 1 ? ? ? ?
           ^
           i
```
  
here if `P[i]` wants to be true, either `s[0..i]` `(leetc)` or `s[4..i]` `(c)` must be in the dict.

So,

`P[i] = P[0..j] && s[j..i] in dict, j = 0..i`
