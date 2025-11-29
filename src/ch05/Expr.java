package ch05;

sealed interface Expr {}

record Binary(Expr left, Token operator, Expr right) implements Expr {}

record Grouping(Expr expression) implements Expr {}

record Literal(Object value) implements Expr {}

record Unary(Token operator, Expr right) implements Expr {}

sealed interface Expr2 {}
record Multiplication(Expr2 left, Expr2 right) implements Expr2 {}
record Constant(int value) implements Expr2 {}
record Addition(Expr2 left, Expr2 right) implements Expr2 {}
record Negation(Expr2 expr2) implements Expr2 {}