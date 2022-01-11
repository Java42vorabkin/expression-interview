package xcom.expressions;

public class ExpressionTree {
	ExpressionNode root;
	static class ExpressionNode {
		Expression expression;
		ExpressionNode left;
		ExpressionNode right;
		ExpressionNode(Expression expression) {
			this.expression = expression;
		}
	}
	public String computeExpression() {
		return computeExpressionFromNode(root);
	}
	private String computeExpressionFromNode(ExpressionNode node) {
		if(node == null) {
			return null;
		}
		if(node.expression instanceof OperandValue) {
			return node.expression.compute();
		}
		return node.expression.compute(computeExpressionFromNode(node.left), 
				computeExpressionFromNode(node.right));
	}

}
