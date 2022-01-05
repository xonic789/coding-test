## Point ##
#1. priorities의 0 인덱스를 pop()
#2. 해당 값과 나머지 값을 비교하여 해당 값보다 더 큰 값이 존재한다면 append()
#3. 존재하지 않는다면 그대로 진행
#4. 위 과정을 반복하며, location 또한 맞춰서 이동
#5. location이 0일 때, pop() 값이 나머지보다 크다면, 해당 값 return
#6. 마지막에 출력되는 경우를 대비하여 while문 밖에 return 추가

def solution(priorities, location):
    answer = 0
    while priorities:
        value = priorities.pop(0)
        print_flag = True
        for v in priorities:
            if value < v:
                print_flag = False
                priorities.append(value)
                if location == 0:
                    location = len(priorities) - 1
                else:
                    location -= 1
                break
        if print_flag:
            answer += 1
            if location == 0:
                return answer
            else:
                location -= 1

    return answer