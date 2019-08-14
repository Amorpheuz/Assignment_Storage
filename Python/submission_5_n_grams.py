#!/usr/bin/python3
#Program to divide a given file into n-grams  per line specified by the user
#Created by:Yash Dave
#PRN: 19030142011
#GitHub: Amorpheuz
#Date: 13-AUG-2019
#Last Updated: 14-AUG-2019

def return_n_grams_list(input_string,n_grams):
    input_words = input_string.split()
    str_len = len(input_words)
    result_list = []
    for i in range(0,str_len-n_grams+1):
        result_list.append(' '.join(input_words[i:i+n_grams]))
    return result_list

def main():
    try:
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
        inp_strings = fn.readlines()
        fn.close()
        n_grams = None
        while type(n_grams) is not int:
            try:
                n_grams = int(input('Enter grams: '))
            except ValueError:
                print('Please enter an integer!')
    except (KeyboardInterrupt,EOFError):
                print('\nTerminating Program....')
                exit()
    print('-------------Output-------------')
    for input_string in inp_strings:
        word_count = len(input_string.split())
        if n_grams < word_count:
            result_list = return_n_grams_list(input_string,n_grams)
            for i in result_list:
                print(i)
        else:
            print(f'Given value for n_grams larger than length of string, Output:\n{input_string}')
        print('-------------Next Line-------------')

main()