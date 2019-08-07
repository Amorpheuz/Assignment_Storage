#!/usr/bin/python3
#Program to read users from /etc/passwd and print them.
#Created by:Yash Dave
#PRN: 19030142011
#GitHub: Amorpheuz
#Date: 28-JUL-2019
#Last Updated: 05-AUG-2019

print('Opening \'/etc/passwd\'...')
try:    
    fn = open('/etc/passwd','r')
    fn_read_lines = fn.readlines()
    fn.close()
except FileNotFoundError:
    print('\'/etc/passwd\' not found. Terminating program!')
    exit()
except PermissionError:
    print('Permission to read \'/etc/passwd\' not available. Terminating program!')
    exit()

users=[]
print('Writing output in \'list_of_users.txt\' in program\' directory.')
try:
    op = open('list_of_users.txt','w')
    op.write('List of users:\n\t')
except PermissionError:
    print('Write permission not available in program\'s folder. Please provide the required permission and restart the program.')
    exit()
counter = 1

for temp in fn_read_lines:
    user = temp[:temp.find(':')]
    op.write(str(counter)+': '+user+'\n\t')
    users.append(user)
    counter+=1

op.close()
print(users)
