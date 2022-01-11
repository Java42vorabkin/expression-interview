package xcom.expressions;

public interface Expression {
	String compute();
	String compute(String op1, String op2);
}
