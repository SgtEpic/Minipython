package CBuilder.conditions;


import CBuilder.Expression;
import CBuilder.Statement;
import CBuilder.objects.AttributeReference;
import CBuilder.objects.Call;

import java.util.List;

/**
 * A MiniPython Ternary operator (If Expression).
 */
public class IfExpression implements Expression {
    private Expression condition;
    private Expression thenStmt;
    private Expression elseStmt;


    /**
     * Create a new ternary operator.
     *
     * Using statements instead of expressions to support assignments in the ternary operator.
     * Unfortunately, assignments are not implementing the expression interface.
     *
     * @param condition The condition of the representing conditional statement.
     * @param thenStmt Then Statement of the conditional statement.
     * @param elseStmt Else Statement of the conditional statement.
     */
    public IfExpression(Expression condition, Expression thenStmt, Expression elseStmt) {
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    /**
     * Generate the c-code of the ternary operator.
     *
     * @return A string which containing the c-code representation of the else block.
     */
    public String build() {
        StringBuilder string = new StringBuilder();

        AttributeReference boolMethod = new AttributeReference("__bool__", condition);
        Call boolCall = new Call(boolMethod, List.of());

        string.append("(__mpy_boolean_raw(" + boolCall.buildExpression() + "))");
        string.append(" ? ");
        string.append("(" + thenStmt.buildExpression() + ")");
        string.append(" : ");
        string.append("(" + elseStmt.buildExpression() + ")");

        return string.toString();
    };

    @Override
    public String buildExpression() {
        return build();
    }

    @Override
    public String buildStatement() {
        return buildExpression() + ";\n";
    }

}
