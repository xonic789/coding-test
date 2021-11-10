# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import math

user_input = list(map(int, input().split()))
a = user_input[0] # 정수 a, start number
b = user_input[1] # 정수 b, end number
answer = 0

if a != b: # 구간 길이가 2 이상인 경우, 답은 항상 2 출력
	print(2)
else: # 구간 길이가 1인 경우, a의 최소 약수 출력
	for i in range(2, int(math.sqrt(a)+1)):
		if a % i == 0:
			answer = i
			break
			
	if answer == 0:
		print(a)
	else:
		print(answer)
		
## Point ##
#1. `a ≠ b` 인 경우, 답은 항상 `2`이다. ( 구간 길이가 2 이상일 경우 )
#2. `a == b` 인 경우, 최소 약수가 답이 된다. ( 구간 길이가 1인 경우 )
#3. 최소 약수가 없다면, `a` 또는 `b`가 답이 된다.