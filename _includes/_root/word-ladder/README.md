## [Breadth-first search](http://en.wikipedia.org/wiki/Breadth-first_search)

Finding the shortest path via BFS.

 * a level counter, plus one when level ends
 * find a word in `dict` that can be jumped to, add it into queue
 * using something like a set to keep the visited path away.

## Time Limited Note:

At first, I use an `isConnected` function to check if every word in `dict` connected to current word,
obviously, it will take `O(len(dict))` time.

Some testcases on leetcode have a very large dict, my code fail.

Then, I change to an `O(len(word))` time method, that is to replace each char in the current word and check if it is in the `dict`.
This way help me pass the testcases.
