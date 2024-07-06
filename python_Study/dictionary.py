# 딕셔너리는 키워드와 내용으로 나뉨 / 키가 중복이면 하나는 무시됨
dic = {'name' : 'pey', 'phone' : '010-9999-1234', 'birth' : '1118'}
a = {'1' : 'hi'}
a = {'a' : [1,2,3]}

a = {1:'a'}
a[2] = 'b'
print(a)

a[3] = [1,2,3] # a = {키 : 값}으로 하면 전체 덮어쓰기고, a[키] = '값'으로 하면 값 추가
print(a)

del a[1] # 해당 키값을 가진 것들 삭제
print(a)

print(a[3]) # 키로 해당 키를 가진 값만 추출

print(dic.keys()) # 이렇게 하면 키값을 추출
print(list(dic.keys()))

print(dic.values()) # 값만 추출
print(dic.items()) # 전부 추출

a.clear() # 전부 지우기
print(a) 

print(dic.get('name')) # 그냥 dic['name']하면 되는 거 아닌가?
print(dic.get('guys', 'No one here')) # 이렇게 하면 get으로 찾는 값이 없을 경우 출력값 설정 가능
print(dic['name']) # 그러네 똑같네. 근데 찾는 값이 없을 경우, ['name']은 오류가 나지만 get(name)은 none이 뜸

print('name' in dic) # 해당 키가 존재하는지 확인
print('guys' in dic)
