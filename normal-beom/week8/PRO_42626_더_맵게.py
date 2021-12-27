## Point ##
#1. scoville -> heap으로 변환
#2. 반복문 수행 ( 스코빌 지수 공식 적용 )
    #2.1 근노드의 값이 K보다 같거나 크면 count 반환
    #2.2 위 조건이 False 이면서, scoville 길이가 1이하일 경우 '-1' 반환

import heapq

def solution(scoville, K):
    count = 0
    heapq.heapify(scoville)
    while True:
        if scoville[0] >= K:
            return count
        elif len(scoville) < 2:
            return -1

        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        
        new_scoville = first + (second * 2)
        heapq.heappush(scoville, new_scoville)
        count += 1