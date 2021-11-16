# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import re

n = int(input()) # N
array = [] 
regex = re.compile('[aeiou]', re.I) # re.IGNORECASE: 대소문자 구분X

for _ in range(n):
	array.append(input()) # 입력 문장 저장

for value in array:
	answer = ''.join(regex.findall(value)) # 정규 표현식
	if len(answer) == 0: # 모음이 없으면 "???" 출력
		print('???')
	else:
		print(answer)