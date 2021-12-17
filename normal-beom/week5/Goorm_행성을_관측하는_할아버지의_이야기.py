# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

## Point ##
#1. 각각 planet_dict[n]에 M만큼 반복하며 제공된 값을 채운다.
#2. 나타난 대소 비교 정보 외의 정보를 채워 넣는다.
	#2.1 "n보다 작은 것들보다 작은 것들"을 planet_big[n]에 추가한다.
	#2.2 "n보다 큰 것들보다 큰 것들"을 planet_small[n]에 추가한다.

first_line = list(map(int, input().split()))
N, M = first_line[0], first_line[1]
planet_big = {i : [] for i in range(1, N+1)}
planet_small = {i : [] for i in range(1, N+1)}

for _ in range(M):
	other_line = list(map(int, input().split()))
	a, b = other_line[0], other_line[1]
	if b not in planet_big[a]:
		planet_big[a].append(b)
	if a not in planet_small[b]:
		planet_small[b].append(a)

for i in range(1, N+1):
	for v in planet_big[i]:
		for val in planet_big[v]:
			if val not in planet_big[i]:
				planet_big[i].append(val)
	for v in planet_small[i]:
		for val in planet_small[v]:
			if val not in planet_small[i]:
				planet_small[i].append(val)

for i in range(1, N+1):
	print(len(planet_small[i]), len(planet_big[i]))
	