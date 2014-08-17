## Guessing

This problem is to find a UNIQUE station `i`, such that

 * SUM(gas[0 .. i-1]) - SUM(cost[0 .. i-1]) + SUM(gas[i .. end]) - SUM(cost[i .. end]) >= 0
 * SUM(gas[0 .. i-1]) - SUM(cost[0 .. i-1]) < 0

`SUM(gas[0 .. i-1]) - SUM(cost[0 .. i-1]) < 0` is to guarantee that the `i` is unique.

If `SUM(gas[0 .. i-1]) - SUM(cost[0 .. i-1]) < 0` and `SUM(gas[0 .. i-1]) - SUM(cost[0 .. i-1]) + SUM(gas[i .. end]) - SUM(cost[i .. end]) >= 0`, that is, `0 .. i-1` are all valid stations.

## Brute force

Just search through from `0` to `end`, find the valid `i`.
