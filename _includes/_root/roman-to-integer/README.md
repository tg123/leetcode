## [Roman numerals](http://en.wikipedia.org/wiki/Roman_numerals)

Loop invariant. Numerals should be in non-ascending order. The value is the sum of the numerals.
if some of numerals break the order, rollback their values added to the sum.

e.g.

```
s = 'IIV'

sum = 0
for i in s
  if s[i - 1] < s[i]
    j = i
    until s[j - 1] > s[j]
      sum = sum - s[j]'s value * 2 // rollback
  else  
    sum = sum + s[i]'s value
    
```
