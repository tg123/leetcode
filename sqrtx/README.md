## [Newton's Method](http://en.wikipedia.org/wiki/Newton%27s_method)

This is copied from my friend Newton.

Then I wrote this code:

```
public int sqrt(int x) {
    if(x < 0) return -1;
    if(x == 0) return 0;

    // x/t + t = 2t
    double t = (double)x;
    double tt = 0;
    while( (int)tt - (int)t != 0 ){
        tt = t;
        t = (x/t + t) /2;
        
    }
    
    return (int)tt;
}
```

## Programming Way

Well, I replaced the mathematical way finally, maybe, I think I should do this in programming way.

### Brute Force

Search through `1..x`, find the `i`, such that `i^2 == x` or  `i^2 < x < (i + 1)^2`.


### Binary Search

As we can brute force, and `1..x` is obviously ordered, we can do it by applying binary search pattern.


```
treat 1..x as the content of an array[0..x-1]


while s < e
  
  m = (s + e) / 2
  
  if (m + 1)^2 == x
    return m + 1
  
  if (m + 1)^2 < x < (m + 1 + 1)^2
    return m + 1
  
  if x < (m + 1)^2
    e = m
  else
    s = m + 1
```

#### Overflow

The testcases contain some large numbers like `Integer.MAX_VALUE`, code will fail due to overflow.

To avoid this, change any `+` and `*` to `-` and `/`
  
  * `m = (s + e) / 2` -> `m = (e - s) / 2 + s`
  * `(m + 1)^2 == x`  -> `x / (m + 1) == (m + 1)`


## [0x5f3759df](http://en.wikipedia.org/wiki/Fast_inverse_square_root)

```
float Q_rsqrt( float number )
{
	long i;
	float x2, y;
	const float threehalfs = 1.5F;
 
	x2 = number * 0.5F;
	y  = number;
	i  = * ( long * ) &y;                       // evil floating point bit level hacking
	i  = 0x5f3759df - ( i >> 1 );               // what the fuck?
	y  = * ( float * ) &i;
	y  = y * ( threehalfs - ( x2 * y * y ) );   // 1st iteration
//      y  = y * ( threehalfs - ( x2 * y * y ) );   // 2nd iteration, this can be removed
 
	return y;
}
```

