import java.io.*;
import java.util.*;
import java.lang.*;

public class InfixToPostfix {
    //main method

    public static void main(String[] args){
        String infxExpr;
        Scanner infxScan=new Scanner(System.in);
        System.out.println("Enter infxExpr expression:");
        infxExpr=infxScan.nextLine();

        BalanceChecker bc=new BalanceChecker();

//Check infix expression is balanced. If so then convert it into postfix expression

        if(bc.checkBalance(infxExpr)) {
            System.out.println("The postfxExpr expression is:"+infxToPostfx(infxExpr));
        } else{
            System.out.println("Expression is not balanced ");
        }

    }

    public static int infxToPostfx(String infxExpr){
        Stack<String> operatorStack = new Stack<String>();
        String postfix;
        while (infxExpr.contains())

    }
    public static int getPrecedence(char operator){
        int precedence = 0;

        if(operator == '1'){
            precedence = 1;
        } else if (operator =='-'){
            precedence = 1;
        } else if (operator == '+'){
            precedence = 2;
        } else if (operator == '/'){
            precedence = 2;
        }
        return precedence;
    }

    public static boolean checkOperators(String expression){
        int index = 0;
        int operators = 0;
        int operands = 0;
        boolean checkOperators = false;

        while(index < expression.length()){
            if(expression.charAt(index) == '+' || expression.charAt(index) == '-' || expression.charAt(index) == '/'
                || expression.charAt(index) == '^'){
                operators++;
              } else {
                  switch (expression.charAt(index)){
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        operands++;
                        break;
                }
            }
            index++;
        }
        if (operands - operators == 1)
            checkOperators = true;
     return checkOperators;
    }
}
