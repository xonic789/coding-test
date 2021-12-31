## Point ##
#1. Stack을 이용한 풀이
#2. number를 반복하며 값을 비교하며 stack의 마지막 값이 해당 값보다 작으면, pop(), k = k - 1
#3. 위 과정이 끝나면, append(반복 값)
#4. 결과 반환시 k가 남아있는 경우(TestCase 12)를 생각하여 반환
def solution(number, k):
    stack = [number[0]]
    for num in number[1:]:
        while stack and stack[-1] < num and k > 0:
            stack.pop()
            k -= 1
        stack.append(num)
    return ''.join(stack[:len(stack) - k])
    
    
    
## Solution - 1 (Result: 10/12)(효율성 실패) ##
#1. 가장 앞 자리 수 부터 차례대로 큰 수를 찾는다.
#2. 해당 인덱스 앞을 제거하고 k = k - 1
#3. k가 0이 될때까지 반복 후 결과 출력

# def solution(number, k):
#     start = 0
#     while k != 0:
#         _number = number[start:start+k+1]
#         index = _number.find(max(_number))
#         _number = _number[index:]
#         last = number[:start] if start > 0 else ''
#         number = last + _number + number[start+k+1:]
#         start += 1
#         k -= index
#     return number