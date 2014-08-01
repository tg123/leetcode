## [Breadth-first search](http://en.wikipedia.org/wiki/Breadth-first_search)

BSF has its common pattern.

Pattern for problems with many steps and each step has many ways to next step:

```
a queue stores [step0, step1, step2, ...]

queue.add(first step)

while queue is not empty

  current_step = queue.poll()
  
  // do something here with current_step
  // like counting
  
  foreah step in current_step can jump to
    queue.add(step)
    


```

## Apply the pattern

It is easy to search through a binary tree using BSF.

```
queue.add(root)

while queue is not empty

  current_node = queue.poll()
 
  add current_node.value to current level collections
 
  queue.add(current_node.left)
  queue.add(current_node.right)

```

### How to know which level current node should be added to


use a dummy node as a `separator` into the queue, whenever polling a `separator` from the queue, we know that a level is end.

codes may be like below

```
queue.add(root)
queue.add(SEP)


while queue is not empty

  current_node = queue.poll()
 
  if current_node is SEP
    
    // new level is start
    reset current_level collection
    
    queue.add(SEP) // here is added to the end of current level
    
    stop if only SEP in the queue
    
  else
    
    add current_node.value to current_level collection
  
    queue.add(current_node.left)
    queue.add(current_node.right)

```

