#!/bin/zsh

txt='''the day is sunny sss the       the
       the sunny is is'''
# outputs the text with adjacent identical lines collapsed to one, unique line of text.
# echo $txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2 " " $1}'
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{print $2 " " $1}'
