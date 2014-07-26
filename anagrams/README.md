## Mapping many to one 

Strings that are [anagrams](http://en.wikipedia.org/wiki/Anagram) can transform to the same string.

`mary` and `army` are anagrams. and `amry` and them are also anagrams.
so just put all strings into a `HashMap` with key of same mapping rule, then find out all the values `count > 1`.

