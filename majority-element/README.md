## [A Linear Time Majority Vote Algorithm](http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html)

## Game: How to find 10 IPs which are flooding your server

Imagine that there is an arena which can on only contains 10 people.
Every people is holding an IP. 

Now, throw the accessing IPs into the arena to hit the people with rule below:
  
  * a people is holding the same IP will get health `+1`
  * if no people is holding the IP, the IP will hit a people randomly, that people's health `-1`
  * people with health 0 will be kicked out of the arena and replace by new people hold current IP.

at the end, people left in the arena with high health value are obviously the attackers.




