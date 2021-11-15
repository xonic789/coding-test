# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

# 자식 노드: (2n+1, 2n+2)
#1. String 형태의 처리를 위해 input() 값을 변수(text)에 누적한다.
#2. 자식 노드(2n +1)가 존재한다면, 해당 index 값과 누적 합 값을 포함해 재귀한다.
#3.1. 자식 노드(2n +1)가 존재하지 않는다면 리프 노드이므로, 최소값 최대값을 비교한다.
#3.2. 리프 노드 최초 도달 경우, 해당 값으로 최소값(minimum) 변경

user_input = int(input())
text = ""
minimum = 0
maximum = 0
eng = {'A':1,'B':2,'C':3,'D':4,'E':5,'F':6,'G':7,'H':8,'I':9,'J':10,'K':11,'L':12,'M':13,'N':14,'O':15,'P':16,'Q':17,'R':18,'S':19,'T':20,'U':21,'V':22,'W':23,'X':24,'Y':25,'Z':26}

for _ in range(user_input):
	text += input()

def func_dfs(now_index=0, value=0):

	global minimum, maximum
	next_index = now_index * 2 + 1
	
	sum_value = value + eng.get(text[now_index])
	
	if next_index < len(text):
		func_dfs(next_index, sum_value)
		func_dfs(next_index+1, sum_value)
	else:
		minimum = min(minimum, sum_value) if minimum != 0 else sum_value
		maximum = max(maximum, sum_value)

func_dfs()
	
print(minimum)
print(maximum)
