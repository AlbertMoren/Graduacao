'''Faça um programa que receba dois números e mostre o menor'''

#minha assinatura 
print("=+"*28,"\n"," "*20, "ALB System","\n","=+"*28,"\n")

n1,n2 = input("Insira as 2 números: ").split(" ")
n1 = int(n1)
n2 = int(n2)
if(n1 >= n2):
    print(f"o número {n2} é  menor")
else:
    print(f"O número {n1} é o menor")