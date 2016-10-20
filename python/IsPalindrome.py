#! /usr/bin/env python
# -*- coding: utf-8 -*-
import sys

def isPalindrome(x):
    return x[ : len(x)/2] == x[ : (len(x)-1)/2:-1]

def main(argv):
    st = argv[1]
    if (isPalindrome(st)):
        print "Palindrome"
    else:
        print "Not a Palindrome"
        
if __name__ == '__main__':
    exit(main(sys.argv))

