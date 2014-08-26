## [Levenshtein distance](http://en.wikipedia.org/wiki/Levenshtein_distance)

This is a well known problem.


Illustrating this problem using wikipedia's example

Making a table like [Interleaving String](../interleaving-string)

```
+---+---+---+---+---+---+---+---+
|   | * | k | i | t | t | e | n |
+---+---+---+---+---+---+---+---+
| * |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| s |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| n |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| g |   |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+

```

`*` here is representing an empty string

each gird is the `edit distance` of `string[0..x]` and `string[0..y]`

First row and column girds are easy to be filled:

 * `edit distance` of an empty string to an empty string is `0`
 * `edit distance` of an empty string to any string is the length of that string

So the table should be filled like:

```
+---+---+---+---+---+---+---+---+
|   | * | k | i | t | t | e | n |
+---+---+---+---+---+---+---+---+
| * | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+
| s | 1 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 2 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 3 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 4 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 5 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| n | 6 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| g | 7 |   |   |   |   |   |   |
+---+---+---+---+---+---+---+---+

```

### what's about `k` and `s` 

in `k`'s view

 * Insert: cant transform to `s`
 * Delete: cant transform to `s`
 * Replace: replace `k` to `s` use `1` `edit distance`

in `s`'s view

 * Insert: cant transform to `k`
 * Delete: cant transform to `k`
 * Replace: replace `s` to `k` use `1` `edit distance`

so the number in the gird `k` and `s` should be `1`

### what's about `ki` and `s` (in `ki`'s view)

 * Insert: cant transform to `s`
 * Delete: delete `i` then, transform to the problem `s` and `k` we solved before. 1 + `edit distance` of `s` and `k`.
 * Replace and Delete: replace `k` to `s` use `1` `edit distance`, then delete `k` use `1` `edit distance`. `1 + 1 = 2`
 

`Delete` and `Replace then Delete` are the same thing at last, `Replace` is just the `1` `edit distance` costed by `edit distance` of `s` and `k`.

In this case, we can transform the problem by deleting one char: 1 + `edit distance` of `string deleted one` and `k`

We can fill up the second column and row now:


```
+---+---+---+---+---+---+---+---+
|   | * | k | i | t | t | e | n |
+---+---+---+---+---+---+---+---+
| * | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+
| s | 1 | 1 | 2 | 3 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+
| i | 2 | 2 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 3 | 3 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 4 | 4 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 5 | 5 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| n | 6 | 6 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| g | 7 | 7 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+

```

### What if `si` and `ki`

Obviously, `si` and `ki` equals to the `edit distance` of `s` and `k`, because `i` are both in two strings.

```
+---+---+---+---+---+---+---+---+
|   | * | k | i | t | t | e | n |
+---+---+---+---+---+---+---+---+
| * | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+
| s | 1 | 1 | 2 | 3 | 4 | 5 | 6 |
+---+---+---+---+---+---+---+---+
| i | 2 | 2 | 1 |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 3 | 3 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| t | 4 | 4 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| i | 5 | 5 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| n | 6 | 6 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| g | 7 | 7 |   |   |   |   |   |
+---+---+---+---+---+---+---+---+

```

then we can fill up the table using technology we used before.


### More common case

`P[word1][word2]` is the the table,

so `P[i][j]` have 4 choices:
 
 * `P[i - 1][j] + 1` : by deleting `word1[i]` from `word1` and convert to previous problem.
 * `P[i][j - 1] + 1` : by deleting `word2[j]` from `word2` and convert to previous problem.
 * `P[i - 1][j - 1]` : only if `word1[i] == word2[j]`
 * `P[i - 1][j - 1] + 1` : only if `word1[i] != word2[j]`, then replace one char `word1[i]` to `word2[j]`, then this problem is converted to `P[i - 1][j - 1]`.

Dont worry about `Insertion`, it is just the oppsite to `Deletion`. Just different view.


So the work remaing is easy, find the MIN of those four is ok.
