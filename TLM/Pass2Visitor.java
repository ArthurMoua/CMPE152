import java.io.PrintWriter;
import java.lang.String;
import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;

public class Pass2Visitor extends TLMBaseVisitor<Integer> 
{
    String programName;
    private PrintWriter jFile;
    int labelcount = 0;
    
    public Pass2Visitor(PrintWriter jFile)
    {
        this.jFile = jFile;
    }
    
    @Override 
    public Integer visitProgram(TLMParser.ProgramContext ctx) 
    { 
        Integer value = visitChildren(ctx); 
        jFile.close();
        return value;
    }
    
    @Override 
    public Integer visitHeader(TLMParser.HeaderContext ctx) 
    { 
        programName = ctx.IDENTIFIER().toString();       
        return visitChildren(ctx); 
    }
    
    @Override 
    public Integer visitMainBlock(TLMParser.MainBlockContext ctx) 
    { 
        // Emit the main program header.
        jFile.println();
        jFile.println(".method public static main([Ljava/lang/String;)V");
        jFile.println();
        
        jFile.println("\tnew javax/swing/JFrame");
        jFile.println("\tdup");
        jFile.println("\tldc \"Team Last Minute - Best Object drawing ever!\"");
        jFile.println("\tinvokespecial javax/swing/JFrame/<init>(Ljava/lang/String;)V");
        jFile.println("\tastore_1");
        jFile.println();

        jFile.println("\taload_1");
        jFile.println("\tsipush 640");
        jFile.println("\tsipush 480");
        jFile.println("\tinvokevirtual javax/swing/JFrame/setSize(II)V");
        jFile.println();        
        
        jFile.println("\taload_1");
        jFile.println("\ticonst_3");
        jFile.println("\tinvokevirtual javax/swing/JFrame/setDefaultCloseOperation(I)V");
        jFile.println();

        jFile.println("\taload_1");
        jFile.println("\ticonst_1");
        jFile.println("\tinvokevirtual javax/swing/JFrame/setVisible(Z)V");
        jFile.println();

        
        //jFile.println("\tnew RunTimer");
        //jFile.println("\tdup");
        //jFile.println("\tinvokenonvirtual RunTimer/<init>()V");
        //jFile.println("\tputstatic        " + programName + "/_runTimer LRunTimer;");
        //jFile.println("\tnew PascalTextIn");
        //jFile.println("\tdup");
        //jFile.println("\tinvokenonvirtual PascalTextIn/<init>()V");
        //jFile.println("\tputstatic        " + programName + "/_standardIn LPascalTextIn;");
        
        Integer value = visitChildren(ctx);
        
        // Emit the main program epilogue.
        jFile.println();
        //jFile.println("\tgetstatic     " + programName + "/_runTimer LRunTimer;");
        //jFile.println("\tinvokevirtual RunTimer.printElapsedTime()V");
        jFile.println();
        jFile.println("\treturn");
        jFile.println();
        jFile.println(".limit locals 16");
        jFile.println(".limit stack 16");
        jFile.println(".end method");
        
        return value;
    }

    @Override 
    public Integer visitStmt(TLMParser.StmtContext ctx) 
    { 
        jFile.println("\n; " + ctx.getText() + "\n");
        
        return visitChildren(ctx); 
    }
    
    @Override 
    public Integer visitAssignmentStmt(TLMParser.AssignmentStmtContext ctx)
    {
        Integer value = visit(ctx.expr());
        
        String typeIndicator = (ctx.expr().type == Predefined.integerType) ? "I"
                             : (ctx.expr().type == Predefined.realType)    ? "F"
                             :                                    "?";
        
        // Emit a field put instruction.
        jFile.println("\tputstatic\t" + programName
                           +  "/" + ctx.variable().IDENTIFIER().toString() 
                           + " " + typeIndicator);

        return value; 
    }
    
    @Override
    public Integer visitIfStmt(TLMParser.IfStmtContext ctx)
    {
    	visit(ctx.expr());
    	int temp;		//Two labels are created with ifstmt
    					// 
    	if (ctx.getChild(1).getText().contains(">"))
    	{
    		if (ctx.getChild(1).getText().contains(">="))
    		{
    			jFile.println("\tif_icmpge" + "\tLabel000"+labelcount);
    		}
    		else
    		{
    			jFile.println("\tif_icmpgt" + "\tLabel000"+labelcount);
    		}
    		
    		labelcount++;   		//Increments label
    		visit(ctx.getChild(6));
    		/*
    		Paste the following code to check values of assignment statements in ifstmt after visit(ctx.getChild(3)); or visit(ctx.getChild(6)); 
    		
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/i I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/j I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");
    		*/
    		jFile.println("\tgoto\tLabel000"+labelcount);
    		temp = labelcount -1;	//to print previous label in jump
    		jFile.println("\n\tLabel000"+temp+":");
    		visit(ctx.getChild(3));
    		
    		jFile.println("\n\tLabel000"+labelcount+":");
    		labelcount++;			//count for next label
    		
    	}
    	else if (ctx.getChild(1).getText().contains("<"))
    	{
    		if (ctx.getChild(1).getText().contains("<="))
    		{
    			jFile.println("\tif_icmple" + "\tLabel000"+labelcount);
    		}
    		else if (ctx.getChild(1).getText().contains("<>"))
    		{
    			jFile.println("\tif_icmpne" + "\tLabel000"+labelcount);
    		}
    		else
    		{
    			jFile.println("\tif_icmplt" + "\tLabel000"+labelcount);
    		}
    		
    		labelcount++;
    		visit(ctx.getChild(6));
    		
    		jFile.println("\tgoto\tLabel000"+labelcount);
    		temp = labelcount -1;
    		jFile.println("\n\tLabel000"+temp+":");
    		visit(ctx.getChild(3));
    		
    		jFile.println("\n\tLabel000"+labelcount+":");    	
    		labelcount++;
		}
    	else if (ctx.getChild(1).getText().contains("="))
    	{
    		jFile.println("\tif_icmpeq" + "\tLabel000"+labelcount);
    		labelcount++;
    		visit(ctx.getChild(6));
    		
    		jFile.println("\tgoto\tLabel000"+labelcount);
    		temp = labelcount -1;
    		jFile.println("\n\tLabel000"+temp+":");
    		visit(ctx.getChild(3));
    		
    		jFile.println("\n\tLabel000"+labelcount+":");
    		labelcount++;
    	}
    	
    	
    	return 0;
    }

    @Override 
    public Integer visitAddSubExpr(TLMParser.AddSubExprContext ctx)
    {
        Integer value = visitChildren(ctx);
                        
        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;
        
        boolean integerMode =    (type1 == Predefined.integerType)
                              && (type2 == Predefined.integerType);
        boolean realMode    =    (type1 == Predefined.realType)
                              && (type2 == Predefined.realType);
        
        String op = ctx.addSubOp().getText();
        String opcode;

        if (op.equals("+")) {
            opcode = integerMode ? "iadd"
                   : realMode    ? "fadd"
                   :               "????";
        }
        else {
            opcode = integerMode ? "isub"
                   : realMode    ? "fsub"
                   :               "????";
        }
        
        // Emit an add or subtract instruction.
        jFile.println("\t" + opcode);
        
        return value; 
    }
    
    @Override
    public Integer visitWhileStmt(TLMParser.WhileStmtContext ctx)
    {
    	int temp, temp2, temp3;		//Two labels are created with ifstmt
		 
    	labelcount++;   		//Increments label
    	temp = labelcount;		//Store original starting label
		jFile.println("\tLabel000"+temp+":");
    	
    	visit(ctx.expr());

    	if (ctx.getChild(1).getText().contains(">"))
    	{
    		labelcount++; 
    		temp2 = labelcount;
    		
    		if (ctx.getChild(1).getText().contains(">="))
    		{
    			jFile.println("\tif_icmpge" + "\tLabel000"+temp2);
    		}
    		else
    		{
    			jFile.println("\tif_icmpgt" + "\tLabel000"+temp2);
    		}
    		labelcount++; 
    		temp3 = labelcount;
    		jFile.println("\tgoto\tLabel000"+temp3);
    		
    		jFile.println("\tLabel000"+temp2+":");
    		
    		visit(ctx.getChild(3));
    		
    		
    		/*Paste the following code to check values of assignment statements in ifstmt after visit(ctx.getChild(3)); or visit(ctx.getChild(6)); 
    		
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/i I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/j I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");*/
    		
    		
    		jFile.println("\tgoto\tLabel000"+temp);
    		
    		jFile.println("\tLabel000"+temp3+":");
    		
    		labelcount++;			//count for next label
    		
    	}
    	else if (ctx.getChild(1).getText().contains("<"))
    	{
    		labelcount++; 
    		temp2 = labelcount;
    		if (ctx.getChild(1).getText().contains("<="))
    		{
    			jFile.println("\tif_icmple" + "\tLabel000"+temp2);
    		}
    		else if (ctx.getChild(1).getText().contains("<>"))
    		{
    			jFile.println("\tif_icmpne" + "\tLabel000"+temp2);
    		}
    		else
    		{
    			jFile.println("\tif_icmplt" + "\tLabel000"+temp2);
    		}
    		labelcount++; 
    		temp3 = labelcount;
    		jFile.println("\tgoto\tLabel000"+temp3);
    		
    		jFile.println("\tLabel000"+temp2+":");
    		
    		visit(ctx.getChild(3));
    		
    		
    		/*Paste the following code to check values of assignment statements in ifstmt after visit(ctx.getChild(3)); or visit(ctx.getChild(6)); 
    		
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/i I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/j I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");*/
    		
    		
    		jFile.println("\tgoto\tLabel000"+temp);
    		
    		jFile.println("\tLabel000"+temp3+":");
    		
    		labelcount++;			//count for next label
		}
    	else if (ctx.getChild(1).getText().contains("="))
    	{
    		labelcount++; 
    		temp2 = labelcount;
    		
    		jFile.println("\tif_icmpeq" + "\tLabel000"+temp2);
    		
    		labelcount++; 
    		temp3 = labelcount;
    		jFile.println("\tgoto\tLabel000"+temp3);
    		
    		jFile.println("\tLabel000"+temp2+":");
    		
    		visit(ctx.getChild(3));
    		
    		
    		/*Paste the following code to check values of assignment statements in ifstmt after visit(ctx.getChild(3)); or visit(ctx.getChild(6)); 
    		
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/i I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");
    		jFile.println("\tgetstatic   java/lang/System/out Ljava/io/PrintStream;	;calling the print function");
    		jFile.println("\tgetstatic   sample/j I");
    		jFile.println("\tinvokevirtual java/io/PrintStream/println(I)V			;printing the value");*/
    		
    		
    		jFile.println("\tgoto\tLabel000"+temp);
    		
    		jFile.println("\tLabel000"+temp3+":");
    		
    		labelcount++;			//count for next label
    	}
    	
    	
    	return 0;
    }
    

    @Override 
    public Integer visitMulDivExpr(TLMParser.MulDivExprContext ctx)
    {
        Integer value = visitChildren(ctx);
                
        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;
        
        boolean integerMode =    (type1 == Predefined.integerType)
                              && (type2 == Predefined.integerType);
        boolean realMode    =    (type1 == Predefined.realType)
                              && (type2 == Predefined.realType);
        
        String op = ctx.mulDivOp().getText();
        String opcode;

        if (op.equals("*")) {
            opcode = integerMode ? "imul"
                   : realMode    ? "fmul"
                   :               "f???";
        }
        else {
            opcode = integerMode ? "idiv"
                   : realMode    ? "fdiv"
                   :               "????";
        }
        
        // Emit a multiply or divide instruction.
        jFile.println("\t" + opcode);
        
        return value; 
    }
    
    
    
    @Override 
    public Integer visitINEQExpr(TLMParser.INEQExprContext ctx) 
    { 
        Integer value = visitChildren(ctx);
        
        TypeSpec type1 = ctx.expr(0).type;
        TypeSpec type2 = ctx.expr(1).type;
        
        boolean integerMode =    (type1 == Predefined.integerType)
                              && (type2 == Predefined.integerType);
        boolean realMode    =    (type1 == Predefined.realType)
                              && (type2 == Predefined.realType);
        
        String op = ctx.INEQ().getText();
        String opcode;
        
        

/*        if (op.equals("=")) {
            opcode = integerMode ? "iload_1" + "\n" + "iload_2" + "\n" + "if_icmpeq Lable1"
                   : realMode    ? "fload_1" + "\n" + "fload_2" + "\n" + "fcmpl Lable1"
                   :               "f???";
        }
        else if ( op.equals("<>")) {
        	opcode = integerMode ? "iload_1" + "\n" + "iload_2" + "\n" + "if_icmpne Lable1"
                    : realMode   ? "fload_1" + "\n" + "fload_2" + "\n" + "fcmpl Lable1"
                    :               "f???";
        }
        else if ( op.equals("<")) {
        	opcode = integerMode ? "iload_1" + "\n" + "iload_2" + "\n" + "if_icmplt Lable1"
                    : realMode   ? "fload_1" + "\n" + "fload_2" + "\n" + "fcmpl Lable1"
                    :               "f???";
        }
        else if ( op.equals(">")) {
        	opcode = integerMode ? "iload_1" + "\n" + "iload_2" + "\n" + "if_icmpgt Lable1"
                    : realMode   ? "fload_1" + "\n" + "fload_2" + "\n" + "fcmpl Lable1"
                    :               "f???";
        }
        else if ( op.equals("<=")) {
        	opcode = integerMode ? "iload_1" + "\n" + "iload_2" + "\n" + "if_icmple Lable1"
                    : realMode   ? "fload_1" + "\n" + "fload_2" + "\n" + "fcmpl Lable1"
                    :               "f???";
        }
        else if ( op.equals(">=")) {
        	opcode = integerMode ? "iload_1" + "\n" + "iload_2" + "\n" + "if_icmpge Lable1"
                    : realMode   ? "fload_1" + "\n" + "fload_2" + "\n" + "fcmpl Lable1"
                    :               "f???";
        }*/
        
        // Emit a comparison instruction.
        //jFile.println("\t" + opcode);
        
        return value; 
    }

    @Override 
    public Integer visitVariableExpr(TLMParser.VariableExprContext ctx)
    {
        String variableName = ctx.variable().IDENTIFIER().toString();
        TypeSpec type = ctx.type;
        
        String typeIndicator = (type == Predefined.integerType) ? "I"
                             : (type == Predefined.realType)    ? "F"
                             :                                    "?";
        
        // Emit a field get instruction.
        jFile.println("\tgetstatic\t" + programName +
                      "/" + variableName + " " + typeIndicator);
        
        return visitChildren(ctx); 
    }
    
    @Override 
    public Integer visitSignedNumber(TLMParser.SignedNumberContext ctx)
    {
        Integer value = visitChildren(ctx);         
        TypeSpec type = ctx.number().type;
        
        if (ctx.sign().getChild(0) == ctx.sign().SUB_OP()) {
            String opcode = (type == Predefined.integerType) ? "ineg"
                          : (type == Predefined.realType)    ? "fneg"
                          :                                    "?neg";
            
            // Emit a negate instruction.
            jFile.println("\t" + opcode);
        }
        
        return value;
    }

    @Override 
    public Integer visitIntegerConst(TLMParser.IntegerConstContext ctx)
    {
        // Emit a load constant instruction.
        jFile.println("\tldc\t" + ctx.getText());
        
        return visitChildren(ctx); 
    }

    @Override 
    public Integer visitFloatConst(TLMParser.FloatConstContext ctx)
    {
        // Emit a load constant instruction.
        jFile.println("\tldc\t" + ctx.getText());
        
        return visitChildren(ctx); 
    }
    
    @Override
    public Integer visitDrawObjExpr(TLMParser.DrawObjExprContext ctx)
    {
    	
    	String variableName1 = ctx.getChild(2).getText();
    	String variableName2 = ctx.getChild(4).getText();
    	String variableName3 = ctx.getChild(6).getText();
    	String variableName4 = ctx.getChild(8).getText();
    	
    	//String s = ctx.getChild(0).getText();
    	if(ctx.getChild(0).getText().equals("square"))
    	{		
    		jFile.println("\tnew drawRec");
    		jFile.println("\tdup");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName1 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName2 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName3 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName4 + " " + "I");
    	    jFile.println("\tinvokespecial drawRec/<init>(IIII)V");
    	    jFile.println("\tastore_2");
    	    jFile.println();    	    
    	    
    	    jFile.println("\taload_1");
    	    jFile.println("\taload_2");
    	    jFile.println("\tinvokevirtual javax/swing/JFrame/add(Ljava/awt/Component;)Ljava/awt/Component;");
    	    jFile.println("\tpop");
    	}
    	else if(ctx.getChild(0).getText().equals("circle"))
    	{
    		jFile.println("\tnew drawCir");
    		jFile.println("\tdup");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName1 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName2 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName3 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName4 + " " + "I");
    	    jFile.println("\tinvokespecial drawCir/<init>(IIII)V");
    	    jFile.println("\tastore_2");
    	    jFile.println();    	    
    	    
    	    jFile.println("\taload_1");
    	    jFile.println("\taload_2");
    	    jFile.println("\tinvokevirtual javax/swing/JFrame/add(Ljava/awt/Component;)Ljava/awt/Component;");
    	    jFile.println("\tpop");
    	}
    	else if(ctx.getChild(0).getText().equals("line"))
    	{
    		jFile.println("\tnew drawLine");
    		jFile.println("\tdup");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName1 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName2 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName3 + " " + "I");
    		jFile.println("\tgetstatic\t" + programName + "/" + variableName4 + " " + "I");
    	    jFile.println("\tinvokespecial drawLine/<init>(IIII)V");
    	    jFile.println("\tastore_2");
    	    jFile.println();
    	    
    	    jFile.println("\taload_1");
    	    jFile.println("\taload_2");
    	    jFile.println("\tinvokevirtual javax/swing/JFrame/add(Ljava/awt/Component;)Ljava/awt/Component;");
    	    jFile.println("\tpop");
    	}
    	
    	return 0;
    }
}