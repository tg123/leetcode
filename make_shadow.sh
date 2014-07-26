#!/bin/bash

for f in `ls -d */`;do 
    if [ -f $f/Solution.java ];then
        /bin/cp -rT $f _includes/_root/$f
    fi
done
