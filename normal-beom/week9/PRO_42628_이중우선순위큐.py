def solution(operations):
    buf = []
    for v in operations:
        array = v.split()
        operator, value = array[0], int(array[1])
        if operator == 'I': # Input Value
            buf.append(value)
        elif len(buf) > 0:
            if operator == 'D' and value == 1: # Delete Maximum
                buf.pop(buf.index(max(buf)))
            else: # Delete Minimum
                buf.pop(buf.index(min(buf)))
    
    return [0,0] if len(buf) == 0 else [max(buf), min(buf)]