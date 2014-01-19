package parser;



public class ConditionnalExpression extends Expression {
	protected Expression exp1;
	protected Expression exp2;
	protected Expression exp3;
	
	public ConditionnalExpression(Expression exp1, Expression exp2, Expression exp3) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.exp3 = exp3;
	}
	
	public String toString(String offset) {
		offset += align();
		return this.getClass().getSimpleName() + '(' + exp1.toString(offset) + ", " +
				'\n' + offset + exp2.toString(offset) + ',' +
				'\n' + offset + exp3.toString(offset) + ')';
	}

	@Override
	public int eval(Env<Integer> envVar) throws EvaluationError {
		int cond = exp1.eval(envVar);
		int caseTrue = exp2.eval(envVar);
		int caseFalse = exp3.eval(envVar);
		
		return cond != 0 ? caseTrue : caseFalse;
	}
}
