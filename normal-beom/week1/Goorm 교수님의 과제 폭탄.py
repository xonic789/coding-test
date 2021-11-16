# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
user_input = int(input())
buf_array = []
buf_dict = []
stack = []
result = "Yes"

for i in range(user_input):
	buf_array.append(input().replace('/','0'))

for i, v in enumerate(sorted(buf_array)):
	value = v.split()
	buf_dict.append([int(value[0]), i+1])
	buf_dict.append([int(value[1]), -(i+1)])

for arr in sorted(buf_dict):
	key = arr[1]
	length = len(stack)
	if key >= 0:
		stack.append(key)
	elif length > 0 and -key == stack[length-1]:
		stack.pop()
	else:
		result = "No"
		break

print(result)

## Point ##
#1. 해당 문제는 "올바른 괄호 문자열 판별" 문제이다.
#2. 쉬운 풀이를 위해 '/'문자를 '0'으로 바꿔 진행한다.
#3. start number 기준으로 정렬 후
	# [start_number, +index], [end_number, -index] 형태로 변환시킨다.
#4. 다시 정렬하면 "올바른 괄호 문자열 판별 문제"와 동일한 형태를 갖춘다.


## Now Problem 75/100 ##
# 5, 7, 10 번 테스트케이스 FAIL
# 각 케이스는 모두 "YES"가 정답
# 반례를 찾지 못한 상태