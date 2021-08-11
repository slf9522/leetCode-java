## 思路1
先排序，保留原有的(num -> list(index)) 映射关系，然后双指针找target
OnLog(n) + On复杂度

## 思路2
遍历，构建hashmap，若target-num不在map中，则加入 O(n)