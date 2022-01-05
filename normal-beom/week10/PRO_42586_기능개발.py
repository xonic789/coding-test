## Point ##
#1. progresses와 speeds 각 값을 더한다
#2. 통과되지 않은 기능부터 연속으로 100 이상 기준을 넘긴 수를 저장한다.
#3. 해당 수를 answer에 추가하고, 전역변수에 더해준다.
#4. 전역변수(누적 값) 값이 progresses의 길이가 될때까지 반복한다.

def solution(progresses, speeds):
    length = len(progresses)
    cnt = 0
    answer = []

    while cnt < length:
        count = 0
        keep = True
        for i in range(cnt, length):
            progresses[i] += speeds[i]
            if keep:
                if progresses[i] >= 100:
                    count += 1
                else:
                    keep = False
        if count > 0:
            answer.append(count)
            cnt += count
                
    return answer