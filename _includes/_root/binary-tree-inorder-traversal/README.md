## Definition  

 * inorder(node.left)
 * visit node
 * inorder(node.right)

It is easy to write a recursive version. 

## Convert to an iterative version

There are a lot of articles about how to do this using a stack, but, I have no enough memory to understand why they are using stack like that. 
As a result, I am going to write a `function call` simulating verison.


### What happens when call to a function and return from a function

Call

 * save all local vars
 * save current code address (continue executing after callee returned)
 * put params somewhere
 * jump to the function

Return

 * retore all local vars
 * jump to saved caller code address
 

### Simulating address

`switch` is a good idea.

```
(function entrance)
  
  // return or new call start
  
  take params from somewhere
  take saved address from somewhere

  switch saved address
    Line 1:
      
      do something
     
    Line 100:
    
      do someting
      
      // making call
      save some var
      save next address 250
      
      put some param for new call
      jump to (function entrance)
      
    
    Line 250:
    
      do something

```

### Back to the problem

  * Use a stack to save `state`, a `state` contains a `param TreeNode` and a `return address`.
  * Use a loop to execute all `state` (simulating recursive function call)
  * whenever there need a new call to function
    * push current `state` to stack
    * create and push a new `state` with param to stack
    * jump to loop begin

```
while stack is not empty

   current = stack.pop()

   switch current.returnAddress
   
   PRE:
      stack.push current
      
      new state { returnAddress = IN, param = current.left }
      stack.push new state
   
   IN:
      visit current.param
      
      
   POST:
      
      stack.push current
      
      new state { returnAddress = DONOTHING, param = current.right }
      stack.push new state
      ...

```

