## Last Solution ##
## Point ##
#1. sort() 사용시 가장 앞자리부터 순서대로 기준을 잡아 정렬된다.
    #ex) 'A', 'AB', 'B', 'BA'
#2. i와 i+1만 비교하면 된다.

def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book)-1):
        length = len(phone_book[i])
        if phone_book[i] == phone_book[i+1][:length]:
            return False
    return True
        
    
    
## Second Solution - 효율성 실패##
#1. 해시 활용 - (key = 길이, value = 값[:길이])
#2. 대상 값의 인덱스보다 뒤에 존재하는 값과 모두 비교

# def solution(phone_book):
#     buf = {}
#     for index, value in enumerate(phone_book):
#         length = len(value)
#         if buf.get(length) is None:
#             buf[length] = [v[:length] for v in phone_book]
#         value_idx = buf[length].index(value)
#         if value in buf[length][value_idx+1:]:
#             return False
#     return True



## First Solution - 효율성 실패 ##
#1. 하나하나 전부 비교

# def solution(phone_book):
#     length = len(phone_book)
#     for i in range(length):
#         for j in range(length):
#             if i != j and phone_book[i] == phone_book[j][:len(phone_book[i])]:
#                 return False
    
#     return True