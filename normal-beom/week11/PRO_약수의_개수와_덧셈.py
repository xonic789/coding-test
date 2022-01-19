def solution(left, right):
    answer = 0
    for v in range(left, right+1):
        count = 0
        for i in range(1, v+1):
            if v % i == 0:
                count += 1
        if count % 2 == 0:
            answer += v
        else:
            answer -= v
    
    return answer