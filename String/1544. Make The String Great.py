class Solution:
    def makeGood(self, s: str) -> str:
        def check(s):
            i = 0
            while(i < len(s) - 1):
                if (s[i+1] == s[i].upper() and s[i] == s[i+1].lower()) or (s[i+1] == s[i].lower() and s[i] == s[i+1].upper()):
                    s = s[:i] + s[i+2:] 
                    i += 2
                i+=1
            return s
        for _ in range(int(len(s)/2)):
            s = check(s)
        return s