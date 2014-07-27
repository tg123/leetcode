#!/bin/bash


TODOMD5='1b7cc92ada7cecdded67a15363474845'

for f in `ls -d */`;do 
    if [ -f $f/Solution.java ];then

        MD5=`md5sum $f/README.md | cut -f 1 -d ' '` 
        if [ "$MD5" != "$TODOMD5" ];then
            e=`grep 'eaten:' $f/index.md`

            if [ -z "$e" ];then
                sed -i '/4/a\eaten: true' $f/index.md
            fi

        fi

    fi
done
