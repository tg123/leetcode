## Split Reverse and Join
 
 1. split by `' '` into array
 1. reverse the array
 1. join the reversed array using `' '`


Here is my python version

```
class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        return ' '.join(s.split()[::-1])
        
```

just do it in java
