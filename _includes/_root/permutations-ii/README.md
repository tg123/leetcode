## Variant of [Next Permutation](../next-permutation)

With the help of [Next Permutation](../next-permutation), you can find all unique permutations from the first permutation.

### First and Last

 * First permutation is the numbers in non-descending order
 * Last permutation is the numbers in non-ascending order


so the code is like

```
sort(num) // make it the first


while num is not the last
  call nextPermutation(num)
  
  copy num into result


```
