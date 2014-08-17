## Definition


```

permute(num) = empty                                num is empty
               num                                  num has only one element
               n + permute(num - n)    [n in num]   otherwise
               
```



