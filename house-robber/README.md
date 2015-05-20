## Rob or not

assume that there are 9 houses along the street
and you have a `rob` func can tell you the how much money you can get from first 8 houses.


what about the 9th house

```
?  = not sure
*  = must rob
_  = must not rob

rob

[? ? ? ? ? ? ? ?] _ *
[0 1 2 3 4 5 6 7] 8 9

money = rob(0..7) + house_value[9]

or not

[? ? ? ? ? ? ? ? ?] _
[0 1 2 3 4 5 6 7 8] 9

money = rob(0..8)


rob(0..9) = max(rob(0..8), rob(0..7) + house_value[9])
```

then it is easy to write a `rob(0..n)`

