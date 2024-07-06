prompt = """
    1. Add
    2. Del
    3. List
    4. Quit

    Enter number:""" # 설명을 위한 문자열일 뿐임

number = 0
while number != 4:
    print(prompt)
    number = int(input()) # input은 반드시 F5로 디버그 실행해야 함
    print(number, "입력됨")
