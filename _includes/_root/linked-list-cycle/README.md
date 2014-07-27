## Fast slow pointer

A linked list with cycle. 


```
1----->-----2----->-------3
            |             |
            |             |
            ^             V
            |             |
            |             |
            5------<------4
                 
```

let two people run in it, one take 1 step each time, the other take 2 steps each time. 
They will meet at a point after some time running. 

imagine month and week, the first day of month and the first day of week will meet sometimes.


So, let a fast runner and a slow runner run in the linked list
  
  * they will collide if the linked list has a cycle.
  * the faster one will find the exit if there is no cycle.
