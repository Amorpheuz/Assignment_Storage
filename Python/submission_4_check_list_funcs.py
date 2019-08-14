#!/usr/bin/python3
#Program to divide a given sentence into n-grams specified by the user
#Created by:Yash Dave
#PRN: 19030142011
#GitHub: Amorpheuz
#Date: 13-AUG-2019
#Last Updated: 14-AUG-2019

def check_list_func(func_name):
    if func_name in list_of_list_funcs():
        return True
    return False

def run_list_func(func_name):
    li1 = ['1','2','3','4','5','6','7','8','9']
    li2 = ['2','4','6','8','10']
    print(f'The 2 test lists to be used:\n\t{li1}\n\t{li2}\n')
    func_ops_dict = {
        "append" :
            (
                "temp = input('Enter value to append with list: ')\n"
                "print(f'Appending {temp} value with li1:')\n"
                "li1.append(temp)"
            ),
        "extend" :
            (
                "print('Extending li1 with li2:')\n"
                "li1.extend(li2)"
            ),
        "insert" :
            (
                "position = int(input('Enter the position : '))\n"
                "value = input('Enter the value to be inserted : ')\n"
                "li1.insert(position,value)"
            ),
        "remove" :
            (
                "val = input('Enter a value to remove:')\n"
                "li1.remove(val)"
            ),
        "index" :
            (
                "value=input('Enter the value whose index you want to know in li1: ')\n"
                "index = li1.index(value)\n"
                "print(f'Index of {value} is {index}')"
            ),
        "count" :
            (
                "value=input('Enter the value whose count you want to know in li1: ')\n"
                "count = li1.count(value)\n"
                "print(f'{value} occurs {count} times in li1')"
            ),
        "pop" :
            (
                "popvalue = li1.pop()\n"
                "print(f'Popped value: {popvalue}')"
            ),
        "reverse" :
            (
                "li1.reverse()\n"
                "print('li1 reversed.')"
            ),
        "sort" :
            (
                "li1.sort()\n"
                "print('Sorted li1.')"
            ),
        "copy" :
            (
                "print('Creating a shallow copy of li1:')\n"
                "new_list = li1.copy()\n"
                "print(f'Shallow copy: {new_list}')"
            ),
        "clear" :
            (
                "print('Clearing li1.')\n"
                "li1.clear()"
            ),
        "contains" : 
            (
                "ele = input('Enter element to check whether it's present in li1 or not: )\n"
                "print(f'{ele} is present in li1') if li1.__contains__(ele) else print(f'{ele} is not present in li1')"
            ),
        "add" : 
            (
                "print('Adding li1 and li2 to new_list:')\n"
                "new_list = li1.__add__(li2)\n"
                "print(new_list)"
            ),
        "delitem" :
            (
                "d_item = int(input('Enter index to delete in li1: '))\n"
                "li1.__delitem__(d_item) if d_item < len(li1) else print('Invalid Index.')"
            ),
        "dir" : 
            (
                "print('Printing methods and attributes of a list: ')\n"
                "print(li1.__dir__())"
            ),
        "doc" :
            (
                "print('Printing docs a of a list: ')\n"
                "print(li1.__doc__)"
            ),
        "eq" :
            (
                "print('Checking if li1 and li2 are equal, i.e. same values and have the same hash..')\n"
                "print(li1.__eq__(li2))"
            ),
        "getitem" :
            (
                "g_item = int(input('Enter index to get in li1: '))\n"
                "print(li1.__getitem__(g_item)) if g_item < len(li1) else print('Invalid Index.')"
            ),
        "iadd" :
            (
                "print('Adding li2 to li1...')\n"
                "li1.__iadd__(li2)"
            ),
        "imul" :
            (
                "i_mul = int(input('Enter number of times to repeat content in li1: '))\n"
                "print(li1.__imul__(i_mul))"
            ),
        "init" : 
            (
                "print('Initializing new list, called li3 via list() which fires __init__() in background.')\n"
                "li3 = list()\n"
                "print(f'li3: {li3}')"
            ),
        "iter" :
            (
                "print('Initializes an iterator that iterates through the list.\\nIterating through li2 via iterator li2_iter.')\n"
                "li2_iter = li2.__iter__()\n"
                "while True:\n"
                "\ttry:\n"
                "\t\tprint(next(li2_iter))\n"
                "\texcept StopIteration:\n"
                "\t\tbreak"
            ),
        "len" : 
            (
                "print(f'Length of li1: {li1.__len__()}')\n"
            ),
        "mul" :
            (
                "n_mul = int(input('Enter number of times to repeat content of li1 done as li1 * r, where r is given value: '))\n"
                "print(li1.__mul__(n_mul))"
            ),
        "new" :
            (
                "print('Initializing new list, called li3 via list.__new().')\n"
                "li3 = list.__new__(list)\n"
                "print(f'li3: {li3}')"
            ),
        "repr" :
            (
                "print(f'Printing official string representation of li1: {li1.__repr__()}')"
            ),
        "str" :
            (
                "print(f'Printing informal string representation of li1: {li1.__str__()}')"
            ),
        "reversed" :
            (
                "print('Initializes an iterator that iterates through the list in reverse.\\nIterating through li2 via iterator li2_revr.')\n"
                "li2_revr = li2.__reversed__()\n"
                "while True:\n"
                "\ttry:\n"
                "\t\tprint(next(li2_revr))\n"
                "\texcept StopIteration:\n"
                "\t\tbreak"
            ),
        "rmul" :
            (
                "n_mul = int(input('Enter number of times to repeat content of li1 done as r * li1, where r is given value: '))\n"
                "print(li1.__mul__(n_mul))"
            ),
        "setitem" :
            (
                "s_index = int(input('Enter index to set value in li1: '))\n"
                "s_item = int(input('Enter value to set in li1: '))\n"
                "li1.__setitem__(s_index,s_item) if s_index < len(li1) and s_index >= 0 else print('Invalid Index.')"
            ),
        "sizeof" :
            (
                "print(f'Printing size of li1 in bytes: {li1.__sizeof__()}')"
            )
    }
    exec(func_ops_dict.get(func_name))
    print(f'\nThe 2 test lists now are:\n\t{li1}\n\t{li2} ')
    
    #temp code - prints remaining methods
    # temp_list = list_of_list_funcs()
    # for i in func_ops_dict.keys():
    #     try:
    #         temp_list.remove(i)
    #     except ValueError:
    #         pass
    # print(temp_list)
    #end

    pass

def list_of_list_funcs():    
    list_of_list_func = []
    for i in dir(list):
        list_of_list_func.append(i.strip('_'))
    return list_of_list_func

def main():
    loop_runner = True
    while loop_runner:
        func_name = input('Enter name of function to execute, enter e to exit: ')
        if func_name.strip() is 'e':
            loop_runner = False
        else:    
            if check_list_func(func_name.strip().strip('_').lower()):
                run_list_func(func_name.strip().strip('_').lower())
            else:
                print('Invalid function name!')

main()