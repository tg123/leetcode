## Aggregating consecutive numbers

Before

```
[100, 4, 200, 1, 3, 2]
```

After

```
[(100), (4, 1, 3, 2), (200)]
```

### One way to achieve

Two collections one is for input, the other is for aggregated nums

 * take a number away from input
 * create a tuple to contain the aggregated nums
 * search all possiable nums and take them away from input
 * loop until the input array is empty
 


```
nums : [100, 4, 200, 1, 3, 2]

aggr : []
```

move `100` into `aggr`


```
nums : [4, 200, 1, 3, 2]

aggr : [(100)]
```

`99` and `101` is not in the `nums`, so go to next


move `4` into `aggr`


```
nums : [200, 1, 3, 2]

aggr : [(100), (4)]
```

`5` is not in the `nums`

`3` is in the `nums`, so move `3` into `aggr`


```
nums : [200, 1, 2]

aggr : [(100), (4, 3)]
```

`2` is in the `nums`, so move `2` into `aggr`

```
nums : [200, 1]

aggr : [(100), (4, 3, 2)]
```

`1` is in the `nums`, so move `1` into `aggr`

```
nums : [200]

aggr : [(100), (4, 3, 2, 1)]
```

`0` is not in the `nums`, so go to next

move `200` into `aggr`

```
nums : []

aggr : [(100), (4, 3, 2, 1), (200)]
```

In this problem, the sequence is no need to be stored, update the longest length is enough.

so, code may be like

```

while nums is not emtpy
  
  len = 1
  
  n = nums.poll()
  
  // search forward
  for i in n .. INFINITE
    
    if i in nums
      remove i from nums
      len = len + 1

  // search backward
  for i in n .. -INFINITE
    
    if i in nums
      remove i from nums
      len = len + 1

  longest = MAX(longest, len)
```
