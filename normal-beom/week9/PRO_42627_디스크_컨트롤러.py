## Point ##
#1. 요청 시간이 짧은 순서대로 정렬
#2. 작업 수행중 발생한 요청을 따로 모으기
    #2.1. 해당 리스트가 존재한다면
        #해당 리스트를 작업 시간이 짧은 순서대로 정렬
        #작업 시간이 가장 짧은 작업 수행 및 나머지 작업 기존 리스트에 추가
    #2.2. 해당 리스트가 존재하지 않는다면
        # 현재 시점(time)에서 가장 가까운 작업까지의 시간을 더해준다.
#3. 요청부터 종료까지 소요된 시간을 구하여 누적한다.( acc += 현재 시점 - 작업의 시작 시점 )

import heapq

def solution(jobs):
    length = len(jobs)
    jobs = sorted(jobs, key=lambda x: x[0]) #1
    
    heap = []
    heapq.heapify(jobs)
    heapq.heapify(heap)
    time = 0
    acc = 0
    
    while True:
        if len(jobs) == 0:
            return acc // length
        for _ in range(len(jobs)):
            if time >= jobs[0][0]:
                array = heapq.heappop(jobs)
                heapq.heappush(heap, array) #2
            else:
                break
        #2.2
        if len(heap) == 0:
            time += jobs[0][0] - time
            continue
        #2.1
        heap = sorted(heap, key=lambda x: x[1])
        if len(heap) > 1:
            for i in range(1, len(heap)):
                heapq.heappush(jobs, heap[i])
        time += heap[0][1]
        acc += time - heap[0][0]
        heap = []