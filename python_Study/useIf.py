money = True
if money:
    print("ㅇㅇ")
else:
    print("ㄴㄴ")
    
money = 2000
card = True
if (money >= 3000) or card:
    print("ㅇㅇ")
else:
     print("ㄴㄴ")
     
print(1 in [1,2,3])
print(1 not in [1,2,3])
print(1 in ('a','b','c'))
print('j' not in 'python')

pocket = ['wallet','bills','cellphon']
if 'wallet' in pocket: pass # pass는 아무것도 안 하고 그냥 지나갈 때 쓰는 것.
else: print("카드를 꺼낸다")

score = 70
message = "success" if score >=60 else "failure" # 특이하게 참일 때의 출력문이 앞으로 가네
print(message)
