## Container's area

`area = heigt * width`

A container in this problem has two heights. According to [Liebig's law of the minimum](http://en.wikipedia.org/wiki/Liebig's_law_of_the_minimum), 
the smaller height should be selected to calculate the area.



```
i and j is the index of the input

function area(i, j)
   return MIN(height[i], height[j]) * ABS(i - j)
   
```

## Maximizing the area

Maybe, sometimes, I'd to brute force every pair of `i` and `j`.

```
max = MIN_VALUE

foreach i in heights
   foreach j in heights
     
     max = MAX(area(i,j), max)
```

### Using brain

#### Needless comparing

Instead of brute force each `i` and `j`, we can choose the next `i` or `j` which may cause the area bigger. 

take a look at `MIN(height[i], height[j]) * ABS(i - j)`, when the enumeration is like


```
foreach i = 0 -> end
   foreach j = end -> 0
     
      max = MAX(area(i,j), max)
```

the `i` and `j` are getting closer, so the only factor is `MIN(height[i], height[j])`. 
Attempting to compare the `height`s smaller than `MIN(height[i], height[j])` are needless.


#### Redundant enumeration

After `i` and `j` meet each other, the rest of enumeration are redundant. so improved version should be like


```
foreach i = 0 -> end
   foreach j = end -> i
     
      max = MAX(area(i,j), max)
```

now, lets see what happens when `i` moves to `i + 1` and `j` remains the same.


```
height[i] > height[j] and height[i + 1] < height[j]    
   MIN(height[i], height[j])     = height[j]
   MIN(height[i + 1], height[j]) = height[i + 1]
   
   area's height is getting smaller


height[i] > height[j] and height[i + 1] > height[j]    
   MIN(height[i], height[j])     = height[j]
   MIN(height[i + 1], height[j]) = height[j]
   
   area's height  remains the same
   

height[i] < height[j] and height[i + 1] < height[j]
    MIN(height[i], height[j])     = height[i]
    MIN(height[i + 1], height[j]) = MIN(height[i], height[i + 1])
    
    area's height  is getting smaller
    
    
height[i] < height[j] and height[i + 1] > height[j]
    MIN(height[i], height[j])     = height[i]
    MIN(height[i + 1], height[j]) = height[j]
    
    area's height is getting bigger
    
```

as you can see only `height[i] < height[j]`, then `i` moves to `i + 1` might generate a bigger area.
this also applies to `j` moves to `j - 1`.

Now, our greedy code goes as following


```
i = 0
j = end

while i and j not meet
   
   max = MAX(area(i,j), max)

   if height[i] < height[j]
      i = i + 1
   
   if height[i] > height[j]
      j = j - 1

```
 





