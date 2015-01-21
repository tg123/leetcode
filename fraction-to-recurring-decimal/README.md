## Simulating division on paper

Pic from [Wikipedia](http://en.wikipedia.org/wiki/Repeating_decimal#Decimal_expansion_and_recurrence_sequence)

```
           .  .
        0.0675
        _______
   74 ) 5.00000
        4.44
        _______
          560
          518
          _____
           420
           370
           ____
            500
```

### When to stop?

Have a look at at the pic above, when we see `500` we are sure that the next `quotient` is `6`.
Because we had calculated `500 / 74` before.

What we need is to remember and check if the `quotient` has been done once before.
