#!/bin/bash

function gittime(){
    git log --pretty=format:%ad --name-only --date=iso8601 $1 | head -n 1
}


for f in `ls -d */`;do 
    if [ -f $f/Solution.java ];then
        t=`cat <(gittime $f/Solution.java) <(gittime $f/README.md) | sort -r | head -n 1`
        sed -i "s/date: .*\$/date: $t/g" $f/index.md
    fi
done
