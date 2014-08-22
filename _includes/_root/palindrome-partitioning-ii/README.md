## [Longest Palindromic Substring](../longest-palindromic-substring) + [Word Break](../word-break)

After running [Longest Palindromic Substring](../longest-palindromic-substring), 
we got a table `P[len][index]`, that is, we can tell if `s[i..j]` is palindromic

## Apply [Word Break](../word-break)

`M[i]` means the mincut of `s[0..i]`.

When a new char comes, we have 3 choices:
 
 * `M[i + 1] = 0`: if `s[0..i + 1]` is palindromic
 * `M[i + 1] = M[i] + 1`: cut at `i`, between the old string `s[0..i]` and the new char.
 * `M[i + 1] = M[j] + 1`: cut at `j`, `j from 0 -> i`, such that `s[j..i+1]` is palindromic, between the `s[0..j]` and `s[j..i + 1]`.

Our job is to find the minimum value among them.
