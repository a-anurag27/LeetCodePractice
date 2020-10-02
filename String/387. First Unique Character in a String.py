from collections import defaultdict
class Solution:
    def firstUniqChar(self, s: str) -> int:
        d = defaultdict(lambda: 0)
        l = list(s)
        for i in l:
            d[i] += 1
        for key, val in d.items():
            if val == 1:
                return l.index(key)
        return -1
        