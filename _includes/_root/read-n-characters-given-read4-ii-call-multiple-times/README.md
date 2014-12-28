## EAGAIN and read

This is a common problem in real world. 
when client read some data from server, data will not always be available to be read.
`read` might return an error like `EAGAIN` in order to tell client that you can do something else now,
call me later.

## difference from [Read N Characters Given Read4](../read-n-characters-given-read4)

when you call `read4`, it might return 4 `char`s.
however, the `read` only ask you for 1 `char`. 
you cannot throw the 3 `char`s away, because `read` may ask you for that 3 `char` when next call.

to solve this, just to add a `localbuff` to store all `char` got from `read4`, and send them one by one to `read`.

```
                  | just store these two chars for coming read call
                  V
 .... .... .... ..** .... .. 
[++++ ++++ ++++ ++][ ++++ +]

```

