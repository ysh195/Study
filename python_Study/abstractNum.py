from copy import copy # 카피 기능 쓰려면 이거 있어야 함


x = 10
print(type(x)) # 자료형 변수의 참조 타입을 확인하는 함수

a = [1,2,3]
b = a
c = a[:]
print(id(a))
print(id(b))
print("a = b ?", a is b) # equals의 느낌인가
print(c)
print(id(c))
print("a = c ?", a is c) # 값은 같지만 주소값이 다름

a[1] = 4
print(a) 
print(b) # 이건 좀 신기하네 b를 다시 수정하지 않았는데 저절로 a랑 같아짐.
print(c) # 그리고 c는 저절로 같아지지 않음

d = copy(a)
print("d = a ? ", d is a) # 그대로 복사한 것이지만 값을 복사한 것이라서 그런지 동일하지 않은 것으로 취급

e,f = ('python','life')
print(e , ", ", f) # 이렇게 각자 다른 변수에 한 번에 값을 넣을 수도 있음

e, f = f, e
print(e , ", ", f) # 값을 서로 교환. temp 없이도 되는 건 신기하네

e = f = 'pyt'
print(e , ", ", f)


