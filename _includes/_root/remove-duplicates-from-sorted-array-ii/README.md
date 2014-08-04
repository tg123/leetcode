## Improved version of [Remove Duplicates from Sorted Array](../remove-duplicates-from-sorted-array)

The difference is that how much the wall should be increased.

if the number is not seen before, the wall should be increased `1` in size.
if the number is seen more than 1 time, the wall should be increased `2` in size.

As all the numbers are sorted, one variable is enough to count the number ever seen before.

And the wall should be increased `MIN(lastseencount, 1) + 1`
