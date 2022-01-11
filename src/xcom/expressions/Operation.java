package xcom.expressions;

public interface Operation extends Expression {
	default String compute() {
		throw new RuntimeException("Operation has to have at least one parameter");
	}
}
