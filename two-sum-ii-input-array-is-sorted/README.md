## Turning

Think you are cooking a soup, you need to add salt when taste light or add water if salty.

However, there are two factors. 

`x + y > target`

 * decrease x
 * decrease y


`x + y < target`

 * increase x
 * increase y
 
make `x` the minimum and `y` the maximum, then only one way to solve the problem.

`x + y > target`

 * <s>decrease x</s>
 * decrease y


`x + y < target`

 * increase x
 * <s>increase y</s>
 
 
 code might be like
 
 ```
 
 x = first
 y = last
 
 while num[x] + num[y] != target
  
  if num[x] + num[y] > target
    y = y - 1
  
  if num[x] + num[y] < target
    x = x + 1
  
 ```
 
 Notes:
 
 Q: Why not `x--` when `num[x] + num[y] > target` ?
 
 A: value of `x - 1` and `y` had already tested.
