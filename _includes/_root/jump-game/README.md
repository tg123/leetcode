## Simulating

```
  0 1 2 3 4
A[2,3,1,1,4]
```

from A[0], can jump to every pos between `0` and `0 + A[0]`
from A[1], can jump to every pos between `1` and `1 + A[1]`

so..
from A[i], can jump to every pos between `i` and `i + A[i]`

C[i] is a paper that help us to remember if we can jump to pos `i`

```
  0 1 2 3 4
A[2,3,1,1,4]
C[0,0,0,0,0]
```

```
for A[0] C[0 .. 0 + A[0]] = 1 
for A[1] C[1 .. 1 + A[1]] = 1 

for A[i] C[i .. i + A[i]] = 1
```

thus, code should be like below

```
C[0] = 1
foreach i in A
  if C[i] == 1 then
      C[i .. i + A[i]] = 1

return C[last i of A]
```


## Array C is not needed

when we set
```
C[i .. i + A[i]] = 1
```

is equals

```
foreach i in A
    C[0 .. max of i + A[i]] = 1
```

is equals

```
maxjump = 0
foreach i in A
    maxjump = max(maxjump, i + A[i])

```

so `C[i]` can be replaced by `i < maxjump`


Removing C would save memory and the time used for setting them to 1
