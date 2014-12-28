## Forward to `read`'s `buf` until `read4` reach its end or `read`'s `buf` full


```
.... .... .... ...E    <-  data read4
++++ ++++ ++++ ++     <-  data pipe to read
```

code should be like below

```
while not EOF or buf not full
  append read4 to buf
```
