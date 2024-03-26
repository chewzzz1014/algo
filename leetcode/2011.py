class Solution:
    def finalValueAfterOperations(self, operations: List[str]) -> int:
        minus1 = operations.count('X--')
        minus2 = operations.count('--X')
        add1 = operations.count('X++')
        add2 = operations.count('++X')
        return add1+add2-minus1-minus2