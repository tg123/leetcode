## Make Pow(x, n) lg(n)

`lg(n)` is telling us just `/2`.

`Pow(x, n) = Pow(x, n / 2) * Pow(x, n / 2)`

so, if we remember the result of `Pow(x, n / 2)`, we can save up half of the cost.


