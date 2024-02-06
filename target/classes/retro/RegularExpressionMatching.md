## 思路解析
如果某个模式能够匹配，则子串一定能匹配
```text 
//dp[i][j] 表示 input.subString(0,i) 能够匹配 pattern.subString(0,j)
    0 1 2 3 4 5 6
      c * a * b
0   y 
1 a y n y y
2 a y n y n
3 b y n y n

```


dp[i][j] = dp[i-1][j-1]

1. dp[i-1][j-1] ==false
    patter[j] == "*"    dp[][j] = dp[][j-2]
    else false
1. dp[i-1][j-1] == true
    pattern[j] == "."   
    pattern[j] == "*" && input[i]==pattern[j-1]  
    pattern[j] == alpha && input[i] == patter[j]

dp[i][j] = dp[i-1][j]
    true:
        pattern[j] == "*" 


dp[i][j] = dp[i][j-1]
    pattern[j-1] == "*" && input[i]==pattern[j-1]
    
dp[i][j] = dp[i-1][j-1]

