## Yet another [Maximum Subarray](../maximum-subarray)

We cannot just drop negative histories this time, instead,
They may grow into bigger positive numbers in the future.

To make [Maximum Subarray](../maximum-subarray) works on this problem,
just add a variable to remember the negative histories. 


When a negative number comes, 
the negative history may trun into a number greater than positive history.
Swap the positive and negative histories.
