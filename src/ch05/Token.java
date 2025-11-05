package ch05;

// no changes from ch04

record Token(TokenType type, String lexeme, Object literal, int line) {
    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
