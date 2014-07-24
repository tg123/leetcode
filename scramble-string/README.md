## Guessing

First time I meet this problem, an idea come to my mind is that

```
s1 = s1_left + s1_right
s2 = s2_left + s2_right

isScramble(s1, s2) = isScramble(s1_left, s2_left) && isScramble(s1_right, s2_right)
                     || isScramble(s1_left, s2_right) && isScramble(s1_right, s2_left)
             
isScramble(s1, s2) = s1 == s2 if s1.length == s2.length == 1         
```

brute force every left and right of s, will find the anwser.

```
foreach cutpoint in s1
  cut s1 into s1_left + s1_right
  cut s2 into s2_left + s2_right
  
  if isScramble(....)
    return True

return False
```


## Time Limited Optimizing

Brute force code can't pass testcases on leetcode.
I try to use the method like `fib(n)` to generate all the `Scramble String`, I just want to make a cache at first.

```
let s = '0123' 

scramble(s) = [scramble(0) * scramble(123)] + [scramble(123) * scramble(0)]
             +[scramble(01) * scramble(23)] + [scramble(23) * scramble(01)]
             +[scramble(012) * scramble(3)] + [scramble(3) * scramble(012)]

scramble return a two_part_set and * here means cartesian product
```

after write down things above, 
I found only half of the results `scramble string` could have its first letter to be `0`

e.g. 
```
[scramble(0) * scramble(123)] + [scramble(01) * scramble(23)] + [scramble(012) * scramble(3)]
```
will yield a `scramble string` in form of `0XXX` 

that means we can make a filter to remove all `set` must not take `0` as its first letter
and `1` as it second and so on...

so we build a methd
```
check_has_char(pos, letter, two_part_set)
    set = pos -> left_set or right_set depends on the two_part_set pivot
    
    return set contains letter
```

isScramble should be like

```
all_result_list = scramble(s1) 

foreach letter and pos in s2
    foreach result in all_result_list
        if not check_has_char(pos, letter, result)
            remove result from all_result_list
        
    if all_result_list is empty
        return False

```

`scramble(s1)` here compute only one level, which means 
`all_result_list` contains objects like `[0|123] [01|23] ...`

### What to do with survival objects in `all_result_list`

A survial object, lets say `[0|123]`, what we need to do is that
check `isScramble(s1_left, s2_left) && isScramble(s1_right, s2_right)`

here
```
s1_left  (gerated `set[0]`) 
s1_right (gerated `set[123]`) 
```

if checking passed, then isScramble(s1, s2) = True

## Deal with duplicated elements

above method will fail if there are duplicated elements. because we use a set to store left and right part of string.

```
scramble(1122) = [1|12] + [12|1]
                +[1|2]  + [1|2]
                +[12|2] + [2|12]
``` 

to make that case work, chage the `set` to `set_with_count`


```
scramble(1122) = [1(2)|1(1)2(1)] + [1(1)2(1)|1(2)]
                +[1(2)|2(2)]     + [1(2)|2(2)]
                +[1(2)2(1)|2(1)] + [2(1)|1(2)2(1)]
``` 

we have to make some change to `check_has_char`

```
check_has_char(pos, letter, need_count, two_part_set)
    pos -> left_set or right_set depends on the two_part_set pivot
    
    if pos on the left_set
        return left_set contains letter count >= need_count
        
    if pos on the right_set
        return left_set contains letter count + right_set contains letter count >= need_count
```


