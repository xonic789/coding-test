## Point ##
#1. 2명이 탈 수 있는 조건이 갖춰진 리스트와 무조건 1명만 탈 수 있는 리스트를 나눈다.
#2. 앞의 리스트를 오름차순 정렬
#3. 효율성을 위한 deque 선언 - 효율성 1번
#4. 아래 과정을 해당 리스트의 길이가 2 이상일 때까지 반복한다.
    #4.1. 가장 작은 두 수를 더해서 limit 보다 크면 반복문 종료
    #4.2. 가장 작은 수와 가장 큰 수를 더해서 limit와 비교한다.
        #1). limit 보다 작으면, 처음과 끝 인덱스를 pop() 한다.
        #2). limit 보다 크면, 끝 인덱스만 pop() 한다.
    #4.3. 위 과정이 끝나면 하나의 구명보트로 특정 인원수를 구출한 것으로 판단한다.(answer++)
#5. 각 리스트에서 구출 횟수를 더하여 출력한다.

from collections import deque
def solution(people, limit):
    answer = 0
    people_down = [v for v in people if limit - 40 >= v] #1
    people_down.sort() #2
    people_down = deque(people_down) #3
    people_over = len(people) - len(people_down) #1
    while len(people_down) > 1: #4
        length = len(people_down)
        if people_down[0] + people_down[1] > limit: #4.1
            break
        if people_down[0] + people_down[length - 1] <= limit: #1)
            people_down.popleft()
            people_down.pop()
        else: #2)
            people_down.pop() 
        answer += 1 #4.3
    return answer + people_over + len(people_down) #5



## 효율성 1번 탈락 ##
# deque 처리 부족
# pop(0) = O(n)

# def solution(people, limit):
#     answer = 0
#     people_down = [v for v in people if limit - 40 >= v]
#     people_down.sort()
#     people_over = len(people) - len(people_down)
#     while len(people_down) > 1:
#         length = len(people_down)
#         if people_down[0] + people_down[1] > limit:
#             break
#         if people_down[0] + people_down[length - 1] <= limit:
#             people_down.pop(0)
#             people_down.pop()
#         else:
#             people_down.pop()
#         answer += 1
#     return answer + people_over + len(people_down)
        

    
## 시간 초과 ##
# 문제에서 요구한 순서대로 풀이

# def solution(people, limit):
#     case = list(itertools.combinations(people, 2))
#     answer = []

#     for value in case:
#         if limit >= value[0] + value[1]:
#             answer.append(value)
    
#     for value in answer:
#         for v in value:
#             people.pop(people.index(v))

#     for v in people:
#         if limit >= v:
#             answer.append(v)

#     return len(answer)