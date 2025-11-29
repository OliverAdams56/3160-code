//AST
package ch05;

import java.util.Objects;

class AstStringifier { // named AstPrinter in the book
    // demo
    static void main() {
        Expr expr = new Binary(
            new Unary(new Token(TokenType.MINUS, "-", null, 1), new Literal(123)),
            new Token(TokenType.STAR, "*", null, 1),
            new Grouping(new Literal(45.67)));

        IO.println(new AstStringifier().stringify(expr));

        Expr2 expr2 = new Multiplication(
            new Multiplication(
                new Constant(3), 
                new Constant(1)),
            new Negation(
                new Addition(
                    new Constant(2), 
                    new Constant(4))));

        System.out.println(new AstStringifier().parenthesize(expr2));
    }

    String stringify(Expr expr) { // renamed from print in the book
        return switch (expr) {
        case Binary(Expr left, Token operator, Expr right) -> "(" + operator.lexeme() + " " + stringify(left) + " " + stringify(right) + ")";
        case Grouping(Expr expression) -> "(group " + stringify(expression) + ")";
        case Literal(Object value) -> Objects.toString(value, "nil");
        case Unary(Token operator, Expr right) -> "(" + operator.lexeme() + " " + stringify(right) + ")";
        };
    }

    String parenthesize(Expr2 expr) {
        return switch (expr) {
            case Constant(int val) -> String.valueOf(val);
            case Multiplication(Expr2 left, Expr2 right) -> "(" + parenthesize(left) + " * " + parenthesize(right) + ")";
            case Addition(Expr2 left, Expr2 right) -> "(" + parenthesize(left) + " + " + parenthesize(right) + ")";
            case Negation(Expr2 e) -> "(-" + parenthesize(e) + ")";
        };
    }
}