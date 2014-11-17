## Constant time means to remember the min value

Update the min value when `push` and `pop`. 

 * push: easy! just update the min value if the new number is less than the current `min value`
 * pop : bad ! need to rollback to a former min value if the current `min value` is poped

what we need is a non-ascending container for backing up the numbers.

```
MinStack = { 
  non_ascending_stack_for_rollback
  stack_for_all
}
```

### The stack

[LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html) is a good one.
And it is easy to build your own stack.

Note: at first, I use array to build my stack, but `Arrays.copyOf` caused time limited.

