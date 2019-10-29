#!/bin/bash

mkdir tmp 2> /dev/null
problems=$(ls *.{java,py} | sed -E -e 's/([^.]*)\.(java|py)/\1/g' | uniq)
for base in $problems; do

    DIFF=""
    if [ -e ${base}IN.txt -a ${base}OUT.txt ]
    then
        cp ${base}IN.txt tmp/        
        src=$base.java
        if [ -e $src ]
        then
            cp $src tmp/$src
            javac tmp/$src -d tmp/ 2> /dev/null
            if [ $? -eq 0 ]
            then               

                DIFF=$(java -classpath tmp/ ${base} | diff ${base}OUT.txt -)
                if [ "$DIFF" = "" ]
                then
                    echo "Passed: Java: $base"
                else
                    echo "Failed: Java: $base"
                    echo $DIFF            
                fi
            else
                echo "Compilation failed: Java: $base"
            fi
        else
            echo "Missing Java: $base"
        fi
        if [ -e ${base}.py ]
        then
            cp ${base}.py tmp/${base}.py
            PYDIFF=$(python tmp/${base}.py | diff ${base}OUT.txt -)
            if [ "$PYDIFF" = "" ]
            then
                echo "Passed: Python: $base"
            else
                echo "Failed: Python: $base"
                echo $PYDIFF
            fi
        else
            echo "Missing Python: $base"
        fi
    else
        echo "Missing IO files: $base"
    fi
done
rm -r tmp/
