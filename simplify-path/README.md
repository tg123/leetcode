## eat++

I like eating.

 * `.`  eats itself
 * `..` eats not only itself but also the directory on the its left

So what we need to is 

 1. split path string by `/`
 1. copy each directory's name if it is not eaten by someting
 1. join the copied result

how to split and join are easy, and can be find in [Reverse Words in a String](../reverse-words-in-a-string)


### eat while copying

`eat` is a number indicates how many directories are eaten.

```
eat = 0

foreach dirname in reverse order
  if dirname is '.'
    // eat itself
    // just dont copy to target
  if dirname is '..'
    // eat itself and the left
    // dont copy  
    
    // indicate to eat the left one
    eat = eat + 1
  else
    // real directory
    if eat > 0
      // this one is eaten
      // dont copy
      
      // eaten
      eat = eat - 1
    else
      
      copy directory's name to target collection
      
 
```

## See a [Google version libguava](https://github.com/google/guava/blob/v18.0/guava/src/com/google/common/io/Files.java#L718)

