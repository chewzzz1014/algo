class TicTacToe:
    def __init__(self):
        self._board = [[' '] * 3 for i in range(3)]
        self._player = 'X'

    def mark(self, i, j):
        if not (0<=i<=2 and 0<=j<=2):
            raise ValueError('Invalid board position')
        if self._board[i][j] != ' ':
            raise ValueError('Board position occupied')
        if self.winner() is not None:
            raise ValueError('Game is already completed')
        self._board[i][j] = self._player
        self._player = 'O' if self._player == 'X' else 'O'

    def _is_win(self, mark):
        board = self._board
        return (
                mark == board[0][0] == board[0][1] == board[0][2] or  # row 0
                mark == board[1][0] == board[1][1] == board[1][2] or  # row 1
                mark == board[2][0] == board[2][1] == board[2][2] or  # row 2
                mark == board[0][0] == board[1][0] == board[2][0] or  # column 0
                mark == board[0][1] == board[1][1] == board[2][1] or  # column 1
                mark == board[0][2] == board[1][2] == board[2][2] or  # column 2
                mark == board[0][0] == board[1][1] == board[2][2] or  # diagonal
                mark == board[0][2] == board[1][1] == board[2][0]
        )

    def winner(self):
        for mark in 'XO':
            if self._is_win(mark):
                return mark
        return None

    def __str__(self):
        rows = ['|'.join(self._board[r]) for r in range(3)]
        return '\n-----\n'.join(rows)