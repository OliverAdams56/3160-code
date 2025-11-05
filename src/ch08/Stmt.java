package ch08;

sealed interface Stmt {
}

record Expression(/* to add!!!! */) implements Stmt {}

record Print(/* to add!!!! */) implements Stmt {}