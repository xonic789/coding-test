# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
user_input = input()

def func(text, num1, num2):
	idx = text.find(num1)
	text = list(text)
	text[idx] = '_'
	text[idx+1] = '_'
	text = ''.join(text)

	if text.find(num2) == -1:
		return(False)
	else:
		return(True)
	
flag_1 = func(user_input, '12', '21') #1. 12를 먼저 제거한 경우
flag_2 = func(user_input, '21', '12') #2. 21를 먼저 제거한 경우

print('Yes' if flag_1 or flag_2 else 'No')

## Point ##
#1. 12를 먼저 제거한 경우 확인
#2. 21를 먼저 제거한 경우 확인
#3. 1번과 2번 중, 하나라도 True가 나오면 'Yes' 나오지 않으면 'No'