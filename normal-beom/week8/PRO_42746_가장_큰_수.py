## Point ##
#1. 자릿수 계산 편의를 위해 문자열 변환
#2. 최대 4자리를 맞춰 비교하기 위해 x*4 기준으로 비교
    #2.1. [0]~[3]까지 순서대로 우선순위를 두고 비교
        # ( (x*4)[0], (x*4)[1], (x*4)[2], (x*4)[3] )
#3.1. 최종 값을 정수 변환( int() )하여 0일 경우 "0" 출력
#3.2 0이 아닌경우 정상출력
def solution(numbers):    
    numbers = map(str, numbers)
    answer = ''.join(
        sorted(numbers, key = lambda x : x*4, reverse=True)
    )
    return "0" if int(answer) == 0 else answer