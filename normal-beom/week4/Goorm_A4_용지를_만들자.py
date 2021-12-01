# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

## Point ##
#1. 가로 20 인 경우 들어갈 수 있는 개수
#2. 가로 40 인 경우 들어갈 수 있는 개수
#3. 겹치는 부분
#4. answer = #1 + #2 - #3

user_input = list(map(int,input().split()))
x, y = user_input[0], user_input[1]

count_x = (x // 20) * (y // 40)
count_y = (x // 40) * (y // 20)
count_xy = (x // 40) * (y // 40) * 2

print (count_x + count_y - count_xy)
