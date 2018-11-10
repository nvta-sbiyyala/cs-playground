#!/usr/bin/env python

import sys

def factorial(n):
    num = int(n)
    x = 1
    while (num > 0):
        x = x*num
        num = num-1
    return x

def main(argv):
    print(factorial(0))
    print(factorial(1))
    print(factorial(10))

if __name__ == '__main__':
    exit(main(sys.argv))


