## [Generation in lexicographic order](http://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order)

I can not work out this without Google's help.

steps below are copied from Wikipedia:

 1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 1. Find the largest index l greater than k such that a[k] < a[l].
 1. Swap the value of a[k] with that of a[l].
 1. Reverse the sequence from a[k + 1] up to and including the final element a[n].


[Fisherlei's Image](http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html) is a good illustration. 
You can see an image that how this solution goes.
