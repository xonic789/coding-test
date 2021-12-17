# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

## Point ##
#1. 해당 문제는 이진 탐색을 이용하여 푼다.
#2. 시작점(start), 끝점(end), 중간점(mid) 지정하고 재귀를 통해 구현

N = int(input())
array = sorted(list(map(int,input().split())))
M = int(input())
second = list(map(int, input().split()))

def binary_search(target, start, end):
	# target이 존재하지 않으면 print(0) 반환
	if start > end:
		return print(0)

	# 중간값(mid)
	mid = (start + end) // 2

	# target을 찾으면 print(1) 반환
	if target == array[mid]:
		return print(1)
	# mid 오른쪽 검색
	elif target > array[mid]:
		return binary_search(target, mid + 1, end)
	# mid 왼쪽 검색
	else:
		return binary_search(target, start, mid - 1)
	
for v in second:
	binary_search(v, 0, N - 1)