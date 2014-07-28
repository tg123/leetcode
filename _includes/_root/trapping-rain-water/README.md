## Art


```
                     +--+            
                     |  |            
         +--+        |  +--+  +--+   
         |  |WW WW WW|  |  |WW|  |   
   +--+  |  +--+  +--+  |  +--+  +--+
   |  |WW|  |  |WW|  |  |  |  |  |  |
+--+--+--+--+--+--+--+--+--+--+--+--+

  0  1  2  3  4  5  6  7  8  9  A  B   [INDEX]
```

## [Loop invariant](http://en.wikipedia.org/wiki/Loop_invariant) with Stack/Queue

Sometimes, there may be an inconclusive result after a loop. you have to wait for one or more loop to merge them all to the final result.

```
loop
  
  if can merge
    merge and commit all pending data to result
    
  else
    save and wait

```

In this case, when a new `bar` comes, if it is greater than or equals to all saved `bar`s, those `bar`s can make up a container. 
The most important thing is that how much water the container can trap has nothing to do with later `bar`s.


### How much water, Bars and stones.




```
            +--+
            |  |
+--+        |  |
|  |WW WW WW|  |
|  +--+  +--+  |
|  |  |WW|  |  |
+--+--+--+--+--+

  3  4  5  6  7   [INDEX]

```

figure above show two bars with heights `2` and `3`. 
so the container can trap `MIN(2,3) * (7 - 3 - 1) = 6`.

but, wait, there are `2` stones (`Bar 4` and `Bar 6`) in the water, we should take them away. `6 - 2 = 4`.


```

// input bars are guaranteed that 
//     * there are more than 2 bars 
//     * first and last bar are the highest

function containWater(bars)
   
   left  = bars.first
   right = bars.last
   
   // container
   water = MIN(left.height, right.height) * (right.pos - left.pos - 1)
   
   // remove stone
   
   foreach bar in bars without first and last
     water = water - bar.height


   return water

```


### Animation

  * Bar `0` height `0`
  * Water = 0


```

Storage: 






+--+
  0  [INDEX]

```


  * Bar `1` height `1`
  * containWater(Bar `0` .. Bar `1`) = 0
  * Remove bars(Bar `0`) no longer needed
  * Water = Water + 0
  * Save Bar `1`


```
Storage:



+--+
|  |
+--+
  1  [INDEX]

```
  
 
  * Bar `2` height `0`
  * Not meet the requirement to call `containWater` (new bar's height `0` < saved bar's height `1`)
  
  * Bar `3` height `2`
  * It is time to call `containWater`
  * containWater(Bar `1` .. Bar `3`) = 1
  * Water = Water + 1


```


      +--+
      |  |
+--+  |  |
|  |WW|  |
+--+--+--+
  1  2  3   [INDEX]

```

  * Save Bar `3`


```
Storage:


+--+
|  |
|  |
|  |
+--+
  3   [INDEX]

```

  * Deal with Bar `3`, `4` , `5` , `6`
  * Not meet the requirement to call `containWater`
  * Save them


```
Storage:

            +--+
            |  |
+--+        |  |
|  |WW WW WW|  |
|  +--+  +--+  |
|  |  |WW|  |  |
+--+--+--+--+--+

  3  4  5  6  7   [INDEX]

```


  * Bar `7` is the higher than any saved `Bar`, so call `containWater`
  * containWater(Bar `3` .. Bar `7`) = 4
  * Water = Water + 4


### Bars left in Storage

After the loop ends, there left some bars in the storage.
From the figure below, there is `1` water in left bars. but, no bar can trigger code to call `containWater`.


```
Storage:

+--+            
|  |            
|  +--+  +--+   
|  |  |WW|  |   
|  |  +--+  +--+
|  |  |  |  |  |
+--+--+--+--+--+

  7  8  9  A  B   [INDEX]
```


How much water these bar can trap has nothing to do with any other bars, so we can convert the storage to a familiar question.

Yes, just reverse it to a new one.


```
            +--+
            |  |
   +--+  +--+  |  
   |  |WW|  |  |  
+--+  +--+  |  |  
|  |  |  |  |  |  
+--+--+--+--+--+

  0  1  2  3  4   [INDEX]
```

Now, add trap( new one ) to water




