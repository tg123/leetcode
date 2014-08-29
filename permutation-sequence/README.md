## [Factorial number system](http://en.wikipedia.org/wiki/Factorial_number_system#Permutations)

It has to master this technology to find `kth` permutation or time limited.

## Detail steps

using wikipedia example

2982th permutation of `[1, 2, 3, 4, 5, 6, 7]`.

### Convert `k` to factorial based number

```
k = 2982
n = 7
```

start form `n - 1`

```
2982 / 6! = 4 and remainder 102     |  4
102  / 5! = 0 and remainder 102     |  0
102  / 4! = 4 and remainder 6       |  4
6    / 3! = 1 and remainder 0       |  1
0    / 2! = 0 and remainder 0       |  0
0    / 1! = 0 and remainder 0       |  0
0    / 0! = 0 and remainder 0       |  0
```

So, `2982(10base) = 4041000(!base)`

### Recover factorial based number to permutation.

```



index:  0  1  2  3  4  5  6
chars: [1, 2, 3, 4, 5, 6, 7]
final: []


number: 4041000
        ^
        |

Move chars[4] to the end of final


chars: [1, 2, 3, 4, 5, 6, 7]  BEFORE
index:  0  1  2  3  4  5, 6
final: [5]
chars: [1, 2, 3, 4, 6, 7]     AFTER


number: 4041000
         ^
         |

Move chars[0] to the end of final

chars: [1, 2, 3, 4, 6, 7]     BEFORE
index:  0  1  2  3  4  5
final: [5, 1]
chars: [2, 3, 4, 6, 7]        AFTER

number: 4041000
          ^
          |

Move chars[4] to the end of final

chars: [2, 3, 4, 6, 7]       BEFORE
index:  0  1  2  3  4
final: [5, 1, 7]
chars: [2, 3, 4, 6]          AFTER



number: 4041000
           ^
           |

Move chars[1] to the end of final

chars: [2, 3, 4, 6]          BEFORE
index:  0  1  2  3
final: [5, 1, 7, 3]
chars: [2, 4, 6]             AFTER



number: 4041000
            ^
            |

Move chars[0] to the end of final

chars: [2, 4, 6]             BEFORE
index:  0  1  2
final: [5, 1, 7, 3, 2]
chars: [4, 6]                AFTER



number: 4041000
             ^
             |

Move chars[0] to the end of final

chars: [4, 6]                BEFORE
index:  0  1
final: [5, 1, 7, 3, 2, 4]
chars: [6]                   AFTER


number: 4041000
              ^
              |

Move chars[0] to the end of final

chars: [6]                   BEFORE
index:  0
final: [5, 1, 7, 3, 2, 4, 6]
chars: []                    AFTER


```

The 2982th permutation of `[1, 2, 3, 4, 5, 6, 7]` is `[5, 1, 7, 3, 2, 4, 6]`
