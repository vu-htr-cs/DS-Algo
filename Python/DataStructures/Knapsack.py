#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'unboundedKnapsack' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY arr
#

def unboundedKnapsack(k, arr)->int:
    # Write your code here
    n=len(arr)
    dp=[ [0]*(k+1)]*(n+1)
    for i in range(1,n+1 ):
        for j in range(1,k+1):
            if(arr[i-1]<=j):
                dp[i][j]= max(dp[i-1][j],dp[i-1][j-arr[i-1]]+arr[i-1])
            else:
                dp[i][j]=dp[i-1][j]
    return dp[n][k]
            
            
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())
    for _ in range(t):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        k = int(first_multiple_input[1])

        arr = list(map(int, input().rstrip().split()))

        result = unboundedKnapsack(k, arr)

        fptr.write(str(result) + '\n')

    fptr.close()
