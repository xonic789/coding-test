# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

## Point ##
# 해당 문제는 "구간합 문제를 얼마나 빠르게 수행하느냐"가 핵심이다.
#1. 각 구간까지의 누적 합을 전부 구한다.
#2. 구간합 = (끝 구간 누적 합) - (시작 구간 누적 합)
#3. 각 구간의 합을 출력한다.

user_input = list(map(int, input().split()))
pay_list = list(map(int, input().split()))

max_day, length = user_input[0], user_input[1]
value_dict = {0 : 0}
tot_price = []

for i in range(1, max_day+1):
	value_dict[i] = pay_list[i-1] if i == 0 else (value_dict[i-1] + pay_list[i-1])
	
for _ in range(length):
	section_list = list(map(int, input().split()))
	tot_price.append(value_dict[section_list[1]] - value_dict[section_list[0]-1])

for i in range(length):
	price = tot_price[i]
	print(price if price < 0 else '+{}'.format(price))

