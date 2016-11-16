import sys

def get_fibonacci():
    yield 0
    a, b = 0, 1

    while True:
        yield b
        b = b + a
        a = b - a
        
def main():
    for num in get_fibonacci():
        if num > 100:
            break
        print num

if __name__ == '__main__':
    sys.exit(main())
