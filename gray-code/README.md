## Formula

Shamelessly, I copied it from [Gray Code on Wikipedia](http://en.wikipedia.org/wiki/Gray_code#Converting_to_and_from_Gray_code).

```
Gray(N) = (n >> 1) XOR n
```

Tricky bit manipulation just change only 1 bit of `n`
