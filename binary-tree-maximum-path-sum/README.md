## What will the maximum path look like

Though paths can be starting from any node and end at any node, the appearances only can be:

 * Appearance 1

```
      *
     / \
    *   *
   /     \ 
  *       *
 /         \ 
S           *
             \
              E
```

 * Appearance 2

```
      E
     / 
    * 
   / 
  * 
 / 
S           
```

* Appearance 3

```
S
 \
  *
   \
    *
     \
      *
       \
        E         
```

### Note

Appearances above are only talking about `TRUNK`.

Treat the path below as Appearance 1

```
      *
     / \
    *   *
   /     \
  *       *
    S   *
          E
```


## Tree Version of [Maximum Subarray](../maximum-subarray)


