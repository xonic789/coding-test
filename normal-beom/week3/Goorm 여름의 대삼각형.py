# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

## Explain ##
#1. 한 점이 (0, 0)좌표가 되도록 평행이동 후 계산

spot = []
for _ in range(3):
	spot.append(list(map(int, input().split())))

x1, y1 = spot[0][0], spot[0][1]
x2, y2 = spot[1][0] - x1, spot[1][1] - y1
x3, y3 = spot[2][0] - x1, spot[2][1] - y1

answer = abs(x2 * y3 - y2 * x3)/2

print(format(answer, ".2f"))