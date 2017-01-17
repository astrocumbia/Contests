#!/bin/python

import sys
ans = 0
MOD = 1000000007

def isDiv(x):
	global ans
	if int(x)%8 == 0:
		ans = ((ans%MOD)+1)%MOD;

def paste(head, list):
	isDiv(head)
	result = [head] + list
	for tail in list:
		result.append(head+tail)
		isDiv(head+tail)
	return result

def combina(list):
	l = []
	while(len(list)>0):
		n = len(list)
		tail = list[0:n-1]
		head = list[n-1]
		l = paste(head, l)
		list = tail

n = int(raw_input().strip())
number = raw_input().strip()
# your code goes here
l = list(number)
combina(l)

print( ans )


