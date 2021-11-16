# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

#1. 각 순서에서 선택지는 총 2가지가 있다.(단, 순서는 0이 아닌 1부터 시작)
#1.1. 기존 값을 더한 것이 현재 값보다 더 큰 경우 >> 기존 값을 더해서 저장한다.(연속)
#1.2. 현재 값만 존재하는 것이 더 큰 경우 >> 현재 값을 저장한다.(시작 + 기존 연속 종료)
#2. 각 구간에서 나타날 수 있는 최댓값이 저장된 배열에서 최댓값을 출력한다.

user_input = int(input())
data = list(map(int, input().split()))

for i in range(1, user_input):
	data[i] = max(data[i-1] + data[i], data[i])	

print(max(data))
