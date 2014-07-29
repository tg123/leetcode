## Buy low and sell high

 * find the lowest point in the prices
 * find the highest point in the prices
 * most important: the lowest point must not behind the highest point 
 

so walk through the `prices`, see check if there is more profit at current point. (`profit = current - lowest before current`)

```

foreach p in prices

  lowest = MIN(p, lowest)
  
  current_profit = p - lowest
  
  maxprofit = MAX(maxprofit, current_profit)

```
