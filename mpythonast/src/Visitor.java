public class Visitor extends minipythonBaseVisitor<Node> {

     public Node visitStmtsLabel(minipythonParser.StmtsLabelContext ctx) {
            Node n = new Program(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
            for (minipythonParser.StmtContext stmt : ctx.stmt()) {
                n.children.add(visit(stmt));
            }
            return n;
     }

     public Node visitFuncdef(minipythonParser.FuncdefContext ctx) {
            Node n = new FunctionDefinition(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
            Node name = new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME().getText());
            Node arg_list = visit(ctx.arg_list());
            Node stmt_block = visit(ctx.stmt_block());
            n.children.add(name);
            n.children.add(arg_list);
            n.children.add(stmt_block);
            return n;
     }

     public Node visitClassdef(minipythonParser.ClassdefContext ctx) {
            Node n = new ClassDefinition(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
            if (ctx.NAME().size() == 1) {
                n.children.add(new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(0).getText()));
            }
             if (ctx.NAME().size() == 2) {
                 n.children.add(new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(0).getText()));
                 n.children.add(new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(1).getText()));
             }
            Node stmt_block = visit(ctx.stmt_block());
            n.children.add(stmt_block);
            return n;
     }

    @Override
    public Node visitReturn_stmt(minipythonParser.Return_stmtContext ctx) {
         Node n = new ReturnStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
         n.children.add(visit(ctx.expr()));
         return n;
    }

    @Override
    public Node visitWhile_stmt(minipythonParser.While_stmtContext ctx) {
         Node n = new WhileStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
         n.children.add(visit(ctx.expr()));
         n.children.add(visit(ctx.stmt_block()));
         return n;
    }

    @Override
    public Node visitBranch_stmt(minipythonParser.Branch_stmtContext ctx) {
         Node n = new BranchStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
         n.children.add(visit(ctx.if_stmt()));
         for (minipythonParser.Elif_stmtContext elif : ctx.elif_stmt()) {
             n.children.add(visit(elif));
         }
         if (ctx.else_stmt() != null) {
             n.children.add(visit(ctx.else_stmt()));
         }
         return n;
    }

    @Override
    public Node visitIf_stmt(minipythonParser.If_stmtContext ctx) {
         Node n = new IfStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
         n.children.add(visit(ctx.expr()));
         n.children.add(visit(ctx.stmt_block()));
         return n;
    }

    @Override
    public Node visitElif_stmt(minipythonParser.Elif_stmtContext ctx) {
        Node n = new ElifStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
        n.children.add(visit(ctx.expr()));
        n.children.add(visit(ctx.stmt_block()));
        return n;
    }
    @Override
    public Node visitElse_stmt(minipythonParser.Else_stmtContext ctx) {
        Node n = new ElseStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
        n.children.add(visit(ctx.stmt_block()));
        return n;
    }

    @Override
    public Node visitStmt_blockLabel(minipythonParser.Stmt_blockLabelContext ctx) {
        Node n = new StatementBlock(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
        for (minipythonParser.StmtContext stmt : ctx.stmt()) {
            n.children.add(visit(stmt));
        }
        return n;
    }

    public Node visitArg_list(minipythonParser.Arg_listContext ctx) {
            Node n = new ArgList(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
            for (int i = 0; i < ctx.NAME().size(); i++) {
                Node name = new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(i).getText());
                n.children.add(name);
            }
            return n;
     }

     public Node visitAssign_stmt(minipythonParser.Assign_stmtContext ctx) {
           Node n = new AssignmentStatement(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
           Node name;
           if (ctx.NAME().size() > 1) {
               StringBuilder str = new StringBuilder();
               for (int i = 0; i < ctx.NAME().size()-1; i++) {
                     str.append(ctx.NAME(i).getText());
                     str.append(".");
               }
               str.append(ctx.NAME(ctx.NAME().size() - 1).getText());
               name = new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), str.toString());
           } else {
               name = new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(0).getText());
           }
           n.children.add(name);
           n.children.add(visit(ctx.expr()));
           return n;
     }

     public Node visitExprLabel(minipythonParser.ExprLabelContext ctx) {
            return visitChildren(ctx);
     }

     public Node visitUnaryplusminusopLabel(minipythonParser.UnaryplusminusopLabelContext ctx) {
            Node n = visit(ctx.plusminusop());
            n.children.add(new ZeroNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine())));
            n.children.add(visit(ctx.expr()));
            return n;
     }

    public Node visitMuldivopLabel(minipythonParser.MuldivopLabelContext ctx) {
        Node n = visit(ctx.muldivop());
        for (minipythonParser.ExprContext expr : ctx.expr()) {
            n.children.add(visit(expr));
        }
        return n;

    }

    public Node visitPlusminusopLabel(minipythonParser.PlusminusopLabelContext ctx) {
        Node n = visit(ctx.plusminusop());
        for (minipythonParser.ExprContext expr : ctx.expr()) {
            n.children.add(visit(expr));
        }
        return n;
    }

    public Node visitComopLabel(minipythonParser.ComopLabelContext ctx) {
        Node n = visit(ctx.comop());
        for (minipythonParser.ExprContext expr : ctx.expr()) {
            n.children.add(visit(expr));
        }
        return n;
    }

    public Node visitNotopLabel(minipythonParser.NotopLabelContext ctx) {
        Node n = new NotNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));
        n.children.add(visit(ctx.expr()));
        return n;
    }

    @Override
    public Node visitAndopLabel(minipythonParser.AndopLabelContext ctx) {
        Node n = new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "and");
        for (minipythonParser.ExprContext expr : ctx.expr()) {
            n.children.add(visit(expr));
        }
        return n;
    }

    @Override
    public Node visitOroplabel(minipythonParser.OroplabelContext ctx) {
        Node n = new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()),"or");
        for (minipythonParser.ExprContext expr : ctx.expr()) {
            n.children.add(visit(expr));
        }
        return n;
    }
    public Node visitCallLabel(minipythonParser.CallLabelContext ctx) {
        Node n = new FunctionCall(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()));

        if (ctx.NAME().size() > 1) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < ctx.NAME().size()-1; i++) {
                str.append(ctx.NAME(i).getText());
                str.append(".");
            }
            str.append(ctx.NAME(ctx.NAME().size() - 1).getText());
            n.children.add(new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), str.toString()));
        } else {
            n.children.add(new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(0).getText()));
        }
        for (minipythonParser.ExprContext expr : ctx.expr()) {
            n.children.add(visit(expr));
        }
        return n;
    }

    public Node visitAttrLabel(minipythonParser.AttrLabelContext ctx) {
        Node n;
        if (ctx.NAME().size() > 1) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < ctx.NAME().size()-1; i++) {
                str.append(ctx.NAME(i).getText());
                str.append(".");
            }
            str.append(ctx.NAME(ctx.NAME().size() - 1).getText());
            n = new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), str.toString());
        } else {
            n = new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME(0).getText());
        }
        return n;
    }

    public Node visitMulLabel(minipythonParser.MulLabelContext ctx) {
         return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "*");
    }
    public Node visitDivLabel(minipythonParser.DivLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "/");
    }
    public Node visitPlusLabel(minipythonParser.PlusLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "+");
    }
    public Node visitMinusLabel(minipythonParser.MinusLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "-");
    }

    public Node visitLtLabel(minipythonParser.LtLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "<");
    }
    public Node visitLteLabel(minipythonParser.LteLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()),  "<=");
    }
    public Node visitGtLabel(minipythonParser.GtLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ">");
    }
    public Node visitGteLabel(minipythonParser.GteLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "=>");
    }
    public Node visitNeqLabel(minipythonParser.NeqLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "!=");
     }
    public Node visitEqLabel(minipythonParser.EqLabelContext ctx) {
        return new BinaryOperator(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), "!=");
     }

    public Node visitNumberLabel(minipythonParser.NumberLabelContext ctx) {
        return new NumberNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.INTEGER().toString());
    }
    public Node visitNameLabel(minipythonParser.NameLabelContext ctx) {
        return new NameNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.NAME().toString());
    }
    public Node visitStringLabel(minipythonParser.StringLabelContext ctx) {
        return new StringNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.STRING().toString());
    }
    public Node visitBooleanLabel(minipythonParser.BooleanLabelContext ctx) {
        return new BooleanNode(new Position(ctx.start.getLine(), ctx.start.getCharPositionInLine()), ctx.BOOLEAN().toString());
    }
}
