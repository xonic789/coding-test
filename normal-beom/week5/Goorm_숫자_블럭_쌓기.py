# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

## Point ##
#1. "add"의 경우 buf_list.append 수행
#2. "remove"의 경우 buf_list 의 마지막 값이 정리함에 필요한 숫자인지 판단한다.
	#2.1 현재 필요한 숫자가 아닌경우, 정렬이 이루어졌다 가정, count += 1
	#2.2 현재 필요한 숫자가 맞는 경우, 정렬이 필요없다.

number = int(input())
count, now = 0, 1
buf_list = []

for _ in range(number * 2):
	value = list(input().split())
	if value[0] == "add":
		buf_list.append(int(value[1]))
	else:
		length = len(buf_list) - 1
		if length > -1 and buf_list[length] == now:
			buf_list = buf_list[:length]
		elif length > -1:
			count += 1
			buf_list = []
		now += 1

print(count)