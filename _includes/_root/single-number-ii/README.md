## Improved version of [Single Number](../single-number)

`xor` can not work if the number appears 3 times.

### Yet another tricky bit manipulation

[1,2,3,5,1,2,3,1,2,3] in binary form of

```
0 0 0 1
0 0 1 0
0 0 1 1
0 1 1 0
0 0 0 1
0 0 1 0
0 0 1 1
0 0 0 1
0 0 1 0
0 0 1 1

count 0 and 1

0 1 7 6
```
then remove the number which `mod 3 == 0` in 0 1 7 6 to 0. the number becomes 0 1 1 0 in decimal form (5).

use an array to count how many `1` appears, the final bit depends on the count number.
