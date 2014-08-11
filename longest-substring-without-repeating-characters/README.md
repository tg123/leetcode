## Loop invariant

Set a `barrier`, such that, `s[barrier..current]` contains no repeating characters.
when a new char comes, update the `barrier` if needed.

the `current - barrier + 1` is the length of the substring.


```

barrier = 0
foreach i in s

  while s[barrier .. i] contains characters
    
    barrier = barrier + 1
  
  max = MAX(max, current - barrier + 1)

```

