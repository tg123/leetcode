## Neutralization 

Using a stack to store the brackets, when a new bracket comes, test if the new one and the one on the stack's top are pairing.

Remove the top one on the stack if they are pairing, or push the new one into stack inorder to wait further pairing.

After all brackets are processed, there should be an empty stack if all brackets are paired.


```
foreach b in brackets

   if b can pair with stack.top()
     // neutralizate them
     stack.pop()
   else
     // wait for further
     stack.push(b)



check if the stack is empty

```
