def add(x,y):
    return x+y

a = 3
b = 4

c = add(a,b)
print(c)

def say():
    return 'hi'

print(say())

result = add(x=1,y=6) # 매개변수로 들어가는 문자도 처음 설정한대로 맞춰야 함.

def add_many(*args): # 갯수가 정해지지 않은 여러 개의 매개변수를 넣을 때는 *args
    result1=0
    for i in args:
        result1 += i
    return result1

result2 = add_many(1,2,3)
print(result2)

def print_kwargs(**kwargs): # 자동으로 딕셔너리로 정렬해서 출력
    print(kwargs)

print_kwargs(a=1)
print_kwargs(name='foo', age=3)

def add_and_mul(x,y):
    return x+y, x*y

result3 = add_and_mul(5,3) # 함수의 리턴값은 언제나 하나이고, 이번에는 2개의 값이 포함된 "하나의 튜플"을 리턴한 것
print(result3)

# 여기서도 아무것도 리턴하지 않을 경우 프로그램 종료로 인식함

def say_myself(name, age, man=True): # 이런 식으로 디폴트값 설정 가능. man 부분은 뭘 넣어도 되고, 안 넣어도 되는데, 안 넣으면 true로 함
    print("이름 : %s" %name) # 단, 선택사항으로 하는 변수는 맨 뒤에 배치해야 함
    print("나이 : %s" %age)
    if man: # switch에 값 넣는 것마냥 그냥 man이라는 변수 자체가 boolean타입이네
        print("남성")
    else:
        print("여성")
        
d = 1
def vartest(x):
    x = x+1
    
vartest(d) # 괄호 안에 들어가는 것은 그저 안에 담긴 값을 전달하는 용도에 불과하고, 실제 그 값은 함수 내에서 x에 저장되어 x의 계산에 쓰임. 그리고 x+1이라는 결과도 x에 저장되는 것이기 때문에
print(d) # 함수 안에서 발생한 변동 사항이 반영되지 않음 반드시 무언가를 리턴해서 그 값을 저장해야 할 듯

r=1
def vartestR():
    global r # 글로벌을 쓰면 자바의 static처럼 그거 하나로 고정됨. 그리고 함수 밖의 값을 가져올 수 있음.
    r = r + 1

vartestR()
print(r)

lambAdd = lambda a, b: a+b
result4 = lambAdd(3,4)
print(result4)
