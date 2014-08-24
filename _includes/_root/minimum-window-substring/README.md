## What is window substring like

```
S = "ADOBECODEBANC"
T = "ABC"
```

Minimum window is "BANC". A string with 1 `A`, 1 `B` and 1 `C`.

Something you shuold notice:
 
 * if a substring is a window string, it plus any string is also a window string.

  `ADOBEC` is a window string, so `ADOBECODE` is a window string too.

 * if a window string's left most or right most character, lets say `c`, is in `T` and the window string has more character `c` than `T` has, removing the `c` from the window string will not break that the remaining string is a window string.

  `ADOBECODEBA` has 2 `A`, and more than `T` has (1 `A`). so, after remove `A` from left or right, the string remains a window string (`ADOBECODEB` is a window string).
  

## Loop invariant to find all possiable window string

Assume that we had found a window string, `W`.

Then

 1. When a new char comes, `W` + new char = `WN`  is also a window. (Rule 1)
 1. Trim the new window string, `WN`, from the left part, remove any char that is redundant to have a window string. (Rule 2)

Code looks like

```

W = a window string in S

foreach c after W in S
  
  WN = W + c
  
  // Trim left
  
  foreach _c in WN
  
    if _c can be remove from WN
      remove _c from the left part of WN
    else
      break
   
  W = WN

```

### Finding the first `W`

the `W` should have any char in `T`, this problem is like the `Check concatenation using count sum` in [Substring with Concatenation of All Words](../substring-with-concatenation-of-all-words).

Use a map `need`, stores how many chars are needed.

Use a map `seen`, stores how many chars are seen.

Those maps are not only used in finding `W`, but also in triming redundant from `WN`.


This last problem is when the `W` is found.
Like [Substring with Concatenation of All Words](../substring-with-concatenation-of-all-words), just use a `counter`,
When `seen` is added, just add 1 to the counter.

The time `counter == T.length` is the time we first found `W`.



_Note_: 
a char in `seen[c]` can contribute at most `need[c]` count to the `counter`.






