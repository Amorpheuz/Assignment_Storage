#!/usr/bin/python3
# Program that takes a dictionary of student ids with their room no.s as values and coverts into a
# dictionary of rooms with student ids as it's values.
#Created by:Yash Dave
#PRN: 19030142011
#GitHub: Amorpheuz
#Date: 21-JUL-2019
#Last Updated: 05-AUG-2019

def main():
    stud_dict = {}
    print('Input data in format \'student_id:room_no\', eg: 101:5\nInput e to exit')
    try:
        iterator = ''
        while iterator is not 'e':
            try:
                iterator = input("Enter Data: ")
                if iterator is not 'e' and iterator.find(':') is not -1:
                    stud_dict[iterator[:iterator.find(':')]] = iterator[iterator.find(':')+1:]
            except UnicodeError:
                print('Unsupported character entered, please only enter unicode characters.')
            except EOFError:
                print('Please provide an input, enter \'e\' to exit')
    except KeyboardInterrupt:
        print('\nProgram Terminated.')
        exit()
    room_dic = get_room_dic(stud_dict)    
    print(room_dic)

def get_room_dic(alloc_dic):
    temp_dic = {}
    for i in alloc_dic:
        if(alloc_dic[i] not in temp_dic):
            temp_dic[alloc_dic[i]]=[i]
        else:
            temp_dic[alloc_dic[i]].append(i)
    return temp_dic

main()