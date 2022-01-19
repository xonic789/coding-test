## Point ##
#1. stages 값 중에서 현재 스테이지(now_stage)보다 작거나 같은 값을 리스트(fail)에 저장한다.
#2. (fail 리스트의 길이 / stages의 길이)와 해당 스테이지(now_stage)를 전역 리스트(failer)에 저장한다.
#3. fail 리스트의 값들을 역순으로 stages.pop(value)를 수행한다.
#4. 만약 stages의 길이가 0일 경우, 해당 스테이지의 실패율을 0으로 저장한다.
#5. 실패율이 높은 스테이지부터 내림차순으로 출력한다.

def solution(N, stages):
    failer = []
    answer = []
    now_stage = 1

    while now_stage != N+1:
        fail = []
        length = len(stages)

        if length == 0: #4
            failer.append([now_stage, 0])
            now_stage += 1
            continue
        
        for i, v in enumerate(stages): #1
            if v <= now_stage:
                fail.append(i)
        
        failer.append([now_stage, len(fail) / length]) #2
        now_stage += 1

        for i in reversed(fail): #3
            stages.pop(i)
            
    for v in sorted(failer, key=lambda x: -x[1]): #5
        answer.append(v[0])
    
    return answer