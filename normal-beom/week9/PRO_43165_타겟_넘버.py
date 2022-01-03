## Point ##
#1. 재귀를 통해서 모든 경우의 수 풀이
#2. 문제 조건에 만족할 경우 count 리스트에 누적
#3. 결과로 count 길이 반환

def solution(numbers, target):
    length = len(numbers)
    count = []

    def dfs(tot, index):
        if index == length:
            if tot == target:
                count.append(True)
            return
        num = numbers[index]
        dfs(tot + num, index + 1)
        dfs(tot - num, index + 1)
    dfs(0, 0)
    return len(count)



## 다른 사람 풀이 ##
#1. solution 자체를 재귀
#2. 매개변수
	# numbers[1:] = leftpop() 을 수행하기 위함
	# target +- numbers[0] = 최초 목표(target)과 맞아 떨어지는 경우를 파악하기 위함
#3. 매개별수로 제공된 numbers 리스트가 종료되며, 최종 목표에 맞아 떨어지는 경우 1을 더한다.
#4. 하지만 매개별수로 제공된 numbers 리스트가 종료되며, 최종 목표와 다른 경우 0을 더한다.
#5. 결과로 최종 합을 반환한다.

# def solution(numbers, target):
# 	if not numbers and target == 0 :
#     return 1
# 	elif not numbers:
#     return 0
#   else:
# 		return solution(numbers[1:], target + numbers[0]) + solution(numbers[1:], target - numbers[0])