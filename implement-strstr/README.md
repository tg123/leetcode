## Brute force

I'd not to be brainfucked and I write first brute force version. No surprisingly, Time Limit Exceeded.

```

foreach i in haystack
  foreach j in needle
    if haystack[i + j] != needle[j]
      i = i + 1
      retry  

   found
   
```

simple and easy but slow.

## KMP Step by Step

I only heard the KMP method, but I have no idea about how it goes.
now, I will show how do I understand KMP step by step.


### Needless Comparing 

lets say

```
0 1 2 3 4 5 6
A B C D E F G
A B C E

when
      
i = 0
j = 3


if haystack[i + j] != needle[j]
  i = i + 1
  retry  

```

`i` jump from `0` to `1`. but wait, why not jump to `3 (i + j) `? comparing `1` and `2` are obviously needless.

### Where should `i` jump to on earth?

e.g.

```
0 1 2 3 4 5 6
A B A B A C G
A B A C
      A B A C
    A B A C

i = 0
j = 3

```

retry from `i = 3`? Wrong. it seems `i` should jump to `2` instead of `3`

```
0 1 2 3
A B A C
    A B A C
    
i = 0
j = 3
```

mismatch at `3` indicates that `haystack[3 - 1] == needle[3 - 1]`. 
In additional, `needle[3 - 1] == needle[0]`, so `i` jumps to `3` and then goes back `1` char to `2`, in the formula: `0 + 3 - 1 (i + j - 1)`


more complex example

```
0 1 2 3 4 5
A B C A B C
      A B C A B C   

i = 0
j = 5
```

mismatch at `5` indicates that `haystack[5 - 1] == needle[5 - 1]`. 
In additional, `needle[5 - 2] == needle[0]` and `needle[5 - 1] == needle[1]`, so `i` jumps to `5 (i + j)` and then goes back `2` chars to `3`, in the formula: `0 + 5 - 2 (i + j - 2)`



### How many chars does `needle[i]` go back?

From above, `needle[i]` should go back `P` chars

such that

```
needle[i - P] == needle[0] and needle[i - (P - 1)] == needle[1] and ...

for n = 0 .. P - 1
    needle[i - P + n] == needle[0 + n]
```

the `P` here DO have name. In wikipedia or some other places, it was known as [needle's longest proper suffix which is a proper prefix](http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm#.22Partial_match.22_table_.28also_known_as_.22failure_function.22.29). I do not understand why they like brainfucking ppl :(.


now we can write some easy code to find all `P` of `needle[i]` to `P[i]`, `P[i]` here means how many chars should needle[i] go back.


The first brute force `P` finding version. Because I do not know how to calculate the `P`, I search from max possible value to zero. I hope codes below would help you understand what the `P` is

```

here S.substring(i, j) == S[i] + S[i + 1] + ... S[j - 1]


for i in needle
  Possible_P = i - 1
    
  while Possible_P > 0 and needle.substring(0, Possible_P) != needle.substring(i - Possible_P, i)
    Possible_P = Possible_P - 1

  P[i] = Possible_P


```

as you can see

`needle.substring(0, Possible_P)` is the prefix and `needle.substring(i - Possible_P, i)` is the suffix



### Put them together (First working version KMP)

```

for i in needle
  Possible_P = i - 1
    
  while Possible_P > 0 and needle.substring(0, Possible_P) != needle.substring(i - Possible_P, i)
    Possible_P = Possible_P - 1

  P[i] = Possible_P



foreach i in haystack
  foreach j in needle
    if haystack[i + j] != needle[j]
      i = i + j - P[i]
      
      i = MAX(i, 1) // at least jump 1 char, think j = 0, infinite looping
      
      retry  

   found

```

### Optimizing P finding

Time limited again, last P finding method is silly and takes a long time to run.

Each loop in needle only add `1` char, so the maximum value of `P[i]` is `P[i - 1] + 1`

```
for i in needle
  Possible_P = P[i - 1] + 1
    
  while Possible_P > 0 and needle.substring(0, Possible_P) != needle.substring(i - Possible_P, i)
    Possible_P = Possible_P - 1

  P[i] = Possible_P
```

and think can the case like `P[i - 1] = 10 and P[i] = 6` happens?

No, becasue `P[i]` depends on `P[i - 1]`. 

`P[i - 1] = 10` means that in the string of `needle[0 .. i - 1 - 1]`, that the fist `10 chars(prefix) of needle[0 .. i - 1 - 1] = last 10 chars(suffix) of needle[0 .. i - 1 - 1]`. 

`P[i] = 6` means that in the string of `needle[0 .. i - 1]`, that the fist `6 chars(prefix) of needle[0 .. i - 1] = last 6 chars(suffix) of needle[0 .. i - 1]`. 


So, `P[i]` should be `P[i - 1] + 1` or `0`


```
for i in needle
  Possible_P = P[i - 1] + 1
    
  if needle.substring(0, Possible_P) != needle.substring(i - Possible_P, i)
    Possible_P = 0

  P[i] = Possible_P
```

Now, substring is also needless. `P[i - 1]` indicates that `needle.substring(0, P[i - 1 - 1]) == needle.substring(i - P[i - 1 - 1], i)`. 
if any new char(`needle[i - 1]`) comes, checking `needle[0 + P[i - 1]] == needle[i - 1]` is enough.


e.g.

```
0 1 2 3 4 5
A B C A B C
      A B C A B C
  ^     ^
  m     n
  
when i = 5   
P[5 - 1] = 1 (needle[0] == needle[3])

if needle[0 + 1] == needle[5 - 1]
    P[5] = P[4] + 1

```

here we can see `m = 0 + P[i - 1]` and `n = i - 1`


### P finding Final version


```
for i in needle
  Possible_P = P[i - 1] + 1
    
  if needle[0 + P[i - 1]] != needle[i - 1]
    Possible_P = 0

  P[i] = Possible_P
```



