## O(m + n)

A matrix has m rows and n columns.

It is easy to collect all information into `to_zero_row[m]` and `to_zero_col[n]`.

## O(1)

If you can write a O(m + n) code, then you can write O(1).

The idea is tricky, Just treat the first row and first column as `to_zero_row[m]` and `to_zero_col[n]`.

And, you need `2` variables to store if the first row and the first colum were needed to be zeroed.
