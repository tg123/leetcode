#!/bin/bash

for f in `ls -d */`;do 
    if [ -f $f/Solution.java ];then
        /bin/cp -r $f/Solution.java _includes/_root/$f/Solution.java
        /bin/cp -r $f/README.md _includes/_root/$f/README.md
    fi
done
