#!/bin/bash

# Given a text file file.txt, transpose its content.
# Assume that each row has the same number of columns, and each field is separated by the ' ' character.

# Example:
# If file.txt has the following content:
# name age
# alice 21
# ryan 30

# The output should be:
# name alice ryan
# age 21 30

# Using awk to transpose the content of file.txt:
awk '{
    # Loop through each field in the current line
    for(i=1;i<=NF;i++) 
        # Append the current field to the corresponding index in the array "a"
        # The value at a[i] will build the transposed columns
        a[i] = a[i]" "$i
    } 
    END {
        # After processing all lines, print each transposed row
        # substr(a[i], 2) removes the leading space added during concatenation
        for(i=1;i<=length(a);i++) 
            print substr(a[i], 2)
    }' file.txt
