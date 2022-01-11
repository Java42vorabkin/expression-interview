package xcom.expressions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpressionTest {
	ExpressionTree tree0;
	ExpressionTree tree1;
	ExpressionTree tree2;
	ExpressionTree tree3;
	Operation plus = (op1,op2) -> Integer.parseInt(op1) + Integer.parseInt(op2) + "";
	Operation minus = (op1,op2) -> Integer.parseInt(op1) - Integer.parseInt(op2) + "";
	Operation multiply = (op1,op2) -> Integer.parseInt(op1) * Integer.parseInt(op2) + "";
	Operation div = (op1,op2) -> Integer.parseInt(op1) / Integer.parseInt(op2) + "";

	@BeforeEach
	void setUp() throws Exception {
		ExpressionTree.ExpressionNode root0 = new ExpressionTree.ExpressionNode(plus);
//		root0.left = new ExpressionTree.ExpressionNode(new OprerandValiable("10", "a1"));
//		root0.right = new ExpressionTree.ExpressionNode(new OprerandValiable("5", "a2"));
		root0.left = new ExpressionTree.ExpressionNode(new OperandValue("10"));
		root0.right = new ExpressionTree.ExpressionNode(new OperandValue("5"));
		tree0 = new ExpressionTree();
		tree0.root = root0;
		// 10 + 5 = 15
		//=================================================================================
		ExpressionTree.ExpressionNode root1 = new ExpressionTree.ExpressionNode(minus);
		root1.left = new ExpressionTree.ExpressionNode(new OperandValue("10"));
		root1.right = new ExpressionTree.ExpressionNode(multiply);
		root1.right.left = new ExpressionTree.ExpressionNode(new OperandValue("5"));
		root1.right.right = new ExpressionTree.ExpressionNode(new OperandValue("3"));
		tree1 = new ExpressionTree();
		tree1.root = root1;
		// 10 - 5*3 = -5
		//==================================================================================
		ExpressionTree.ExpressionNode root2 = new ExpressionTree.ExpressionNode(plus);
		root2.left = new ExpressionTree.ExpressionNode(new OperandValue("10"));
		root2.right = new ExpressionTree.ExpressionNode(div);
		root2.right.left = new ExpressionTree.ExpressionNode(new OperandValue("20"));
		root2.right.right = new ExpressionTree.ExpressionNode(new OperandValue("4"));
		tree2 = new ExpressionTree();
		tree2.root = root2;
		// 10 + 15/3 = 15
		//==================================================================================
		ExpressionTree.ExpressionNode root3 = new ExpressionTree.ExpressionNode(div);
		root3.left = new ExpressionTree.ExpressionNode(new OperandValue("60"));
		root3.right = new ExpressionTree.ExpressionNode(plus);
		root3.right.left = new ExpressionTree.ExpressionNode(new OperandValue("5"));
		root3.right.right = new ExpressionTree.ExpressionNode(new OperandValue("10"));
		tree3 = new ExpressionTree();
		tree3.root = root3;
		// 60/(5 + 10) = 4
	}

	@Test
	void test() {
		assertEquals("15", tree0.computeExpression());
		assertEquals("-5", tree1.computeExpression());
		assertEquals("15", tree2.computeExpression());
		assertEquals("4", tree3.computeExpression());
	}

}
