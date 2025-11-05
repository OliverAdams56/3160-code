package ch05;

import java.util.Objects;

class AstStringifier { // renamed from AstPrinter in the book
    // demo
    static void main() {
        Expr expr = new Binary(
                new Unary(new Token(TokenType.MINUS, "-", null, 1), new Literal(123)),
                new Token(TokenType.STAR, "*", null, 1),
                new Grouping(new Literal(45.67)));

        IO.println(new AstStringifier().stringify(expr));
    }

    String stringify(Expr expr) { // renamed from print in the book
        return switch (expr) {
            case Binary(Expr left, Token operator, Expr right) -> "(" + operator.lexeme() + " " + stringify(left) + " " + stringify(right) + ")";
            case Grouping(Expr expression) -> "(group " + stringify(expression) + ")";
            case Literal(Object value) -> Objects.toString(value, "nil");
            case Unary(Token operator, Expr right) -> "(" + operator.lexeme() + " " + stringify(right) + ")";
        };
    }
}
