package xcom.expressions;

public class OperandValue implements Expression {
	String value;
	
	public OperandValue(String value) {
		this.value = value;
	}
	@Override
	public String compute() {
		return value;
	}

	@Override
	public String compute(String op1, String op2) {
		throw new RuntimeException("Operand cannot have any parameters");
	}

}
