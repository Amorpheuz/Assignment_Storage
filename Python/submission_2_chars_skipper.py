#!/usr/bin/python3
#Program to read an int x from User and then skip x characters on every line 
# and write o/p to a output.txt from input.txt
#Created by:Yash Dave
#PRN: 19030142011
#GitHub: Amorpheuz
#Date: 28-JUL-2019
#Last Updated: 05-AUG-2019

skipper = None
while type(skipper) is not int:
    try:
        skipper = int(input('Enter the position of char whose multiples will be skipped in Output File: '))
        if skipper<=0:
            raise ZeroDivisionError
    except ValueError:
        print('Please enter an Integer!')
    except KeyboardInterrupt:
        print('\nProgram Terminated.')
        exit()
    except EOFError:
        print('Please provide an input')
    except ZeroDivisionError:
        print('Skip char position can\'t be zero or lower. Terminating program.')
        exit()

flag = True
fn = None
while flag:
    try:
        fn = open(input('Enter name of file to open, Enter full path if in different directory: '),'r')
    except KeyboardInterrupt:
        print('\nProgram Terminated.')
        exit()
    except FileNotFoundError:
        print('Invalid Path, File not found. Please try again!')
        continue
    except IsADirectoryError:
        print('Provided Path is a Directory. Please try again!')
        continue
    except UnicodeError:
        print('Unsupported character entered, please only enter unicode characters.')
        continue
    except EOFError:
        print('Please provide an input')
        continue
    except PermissionError:
        print('Required Read Permission not available. Please provide a different file or edit permissions and restart the program.')
        exit()
    flag = False

fn_read_lines = fn.readlines()
fn.close()

print('Writing output to "output.txt" in program\'s directory.')
op = None
try:
    op = open('output.txt','w')
except PermissionError:
    print('Required write Permission not available. Please edit permissions and restart the program.')
    exit()

#Checks last char of file, if no \n is found, makes line-ends consistent
try:
    last_line = fn_read_lines[-1]
    if last_line[-1:] is not '\n':
        fn_read_lines[-1]+='\n'
except IndexError:
    print('Empty file provided, terminating program.')
    exit()

try:
    for temp in fn_read_lines:
        str_no = len(temp) // skipper # Finds no. of times the char has to be skipped
        if str_no<1: #If no skippable chars in line, print line directly
            op.write(temp[:-1])
        else:
            #Starts from 1 since I want to start truncating at first skipable char 
            #+1 since range(i,j) always stops at j-1
            str_range = range(1,str_no+1)
            for sizer in str_range:
                op.write(temp[((sizer*skipper)-skipper):((sizer*skipper)-1)])
            extra = len(temp) % skipper
            if extra is not 0: #If any extra chars are left after last skippable char, write them
                op.write(temp[-extra:-1])
        if fn_read_lines[-1] is not temp: #Change line after every line unless its last line
            op.write('\n')
except ZeroDivisionError:
    print('Skip char position can\'t be zero. Terminating program.')
    exit()

op.close()