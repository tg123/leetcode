## Leetcode Blog Version

Here is the [Leetcode Blog Version](http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html). 
This is a classic problem. I write my first leetcode accepted version based on that.


## My own words version

Brute force + isPalindromic will run out of time.

### Recursive

 * `length 1 substring`: all are palindromic
 * `length 2 substring`: only if two char are same

What if `length 3`

```

length 3 = length 1 + two char

0 1 2 3 4
a b c b a
+   ^    
|   |
+---+    


0 1 2 4 4
a b c b a
  +   ^     
  |   |
  +---+    

```

 * `length n` = inner `length n - 2` is palindromic AND (first char == last char)


### Store `length n` into `P[lenght n][start index]`

 * `P[1][3] = true` means that the substring starts from index 3 and 1 char long is palindromic.
 * `P[5][2] = true` means that the substring starts from index 2 and 5 char long is NOT palindromic.


a matrix for `abcba`

```

  0 1 2 3 4
  a b c b a
1 1 1 1 1 1
2 0 0 0 0 -
3 0 1 0 - -
4 0 0 - - -
5 1 - - - -
^
l
e
n

```

With the matrix, we can fill up the martix by `P[len][i] = P[len -2][i + 1] && S[i] == S[i + len -1]`.


Note: the `length 0` is useless, so just using `P[len - 1]` for `len`.
