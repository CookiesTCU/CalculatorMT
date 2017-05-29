/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatormt.Balan;

import java.util.Arrays;

/**
 *
 * @author HM
 */
public class Balan implements Balaninterface {

    private boolean isError = false;
    private String varString[] = {"ans", "va", "vb", "vc", "vd", "ve", "vf"};
    private String constString[] = {"pi", "π", "e"}; // mang chuoi cac hang
    public double var[] = new double[varString.length];
    private double cons[] = {Math.PI, Math.PI, Math.E};
    private boolean isDegOrRad = true;
    private int radix = 10, sizeRound = 10;
    private ConvertNumber convertNumber = new ConvertNumber();

    @Override
    public boolean isError() {
        return isError;
    }

    @Override
    public void setError(boolean isError) {
        this.isError = isError;
    }

    @Override
    public int getSizeRound() {
        return sizeRound;
    }

    @Override
    public void setSizeRound(int sizeRound) {
        this.sizeRound = sizeRound;
    }

    @Override
    public int getRadix() {
        return radix;
    }

    @Override
    public void setRadix(int radix) {
        this.radix = radix;
    }

    @Override
    public boolean isDegOrRad() {
        return isDegOrRad;
    }

    @Override
    public void setDegOrRad(boolean isDegOrRad) {
        this.isDegOrRad = isDegOrRad;
    }

    @Override
    public boolean isIntegerNumber(double num) {
        long a = (long) num;
        if (a == num) {
            return true;
        }
        return false;
    }

    @Override
    public String myRound(double num, int size) {
        if (isIntegerNumber(num)) {
            return Long.toString((long) num);
        } else {
            int n = size - Long.toString((long) num).length();
            num = Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
            if (isIntegerNumber(num)) {
                return Long.toString((long) num);
            } else {
                return Double.toString(num);
            }
        }
    }

    @Override
    public long factorial(int num) {
        if (num >= 0) {
            long result = 1;
            for (int i = 1; i <= num; i++) {
                result *= i;
            }
            return result;
        }
        return -1;
    }

    @Override
    public long permutation(int a, int b) {
        if (a < b) {
            return -1;
        }
        if (a >= 0 && b >= 0) {
            long result = 1;
            int c = a - b;
            for (int i = c + 1; i <= a; i++) {
                result *= i;
            }
            return result;
        }
        return -1;
    }

    @Override
    public long combination(int a, int b) {
        if (a < b) {
            return -1;
        }
        if (a >= 0 && b >= 0) {
            long result = 1;
            int c = a - b;
            if (c > b) {
                int temp = c;
                c = b;
                b = temp;
            }
            for (int i = b + 1; i <= a; i++) {
                result *= i;
            }
            result /= factorial(c);
            return result;
        }
        return -1;
    }

    @Override
    public double convertToDeg(double num) {
        num = num * 180 / Math.PI;
        return num;
    }

    @Override
    public double convertToRad(double num) {
        num = num * Math.PI / 180;
        return num;
    }

    @Override
    public boolean isNumber(String s) {
        if (radix != 10 && convertNumber.isRadixString(s, radix)) {
            return true;
        }
        if (isVarOrConst(s)) {
            return true;
        }
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isNumber(char c) {
        String numberChar = ".0123456789abcdef";
        int index = numberChar.indexOf(c);
        if (radix == 10 && index >= 0 && index <= 10) {
            System.out.println(c + " is number");
            return true;
        }
        if (radix == 16 && index >= 0) {
            System.out.println(c + " is number");
            return true;
        }
        if (radix == 8 && index >= 0 && index <= 8) {
            System.out.println(c + " is number");
            return true;
        }
        if (radix == 2 && index >= 0 && index <= 2) {
            System.out.println(c + " is number");
            return true;
        }
        System.out.println(c + " isn't number");
        return false;
    }

    @Override
    public double stringToNumber(String s) {
        int index = indexVar(s);
        if (index >= 0) {
            return var[index];
        }
        index = indexConst(s);
        if (radix != 10) {
            if (convertNumber.isRadixString(s, radix)) {
                return convertNumber.stringRadixToDouble(s, radix);
            } else {
                isError = true;
                System.out.println("Error number in radix = " + radix);
            }
        }
        if (index >= 0) {
            return cons[index];
        }
        if (s.charAt(s.length() - 1) == '.') {
            isError = true;
            System.out.println("Error number have '.'");
            return -1;
        }
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            isError = true;
            System.out.println("Error parse number");
        }
        return -1;
    }

    @Override
    public String numberToString(double num, int radix, int size) {
        if (radix != 10) {
            return convertNumber.doubleToStringRadix(num, radix, size);
        }
        return myRound(num, size);
    }

    @Override
    public int indexVar(String s) {
for (int i = 0; i < varString.length; i++) {
			if (s.equals(varString[i])) {
				return i;
			}
		}
		return -1;    }

    @Override
    public int indexConst(String s) {
for (int i = 0; i < constString.length; i++) {
			if (s.equals(constString[i])) {
				return i;
			}
		}
		return -1;    }

    @Override
    public boolean isVarOrConst(String s) {
if (indexConst(s) >= 0 || indexVar(s) >= 0) {
			return true;
		}
		return false;    }

    @Override
    public boolean isOperator(String s) {
String operator[] = { "+", "-", "*", "/", "ℂ", "ℙ", "ncr", "npr", "^",
				"~", "√", "sqrt", "ⁿ√", "n√", "!", "%", ")", "(", "²", "sin",
				"cos", "tan", "arcsin", "arccos", "arctan", "log", "→", "sto",
				"mod", "and", "or", "xor", "not", "∧", "∨", "⊻", "¬", "<<",
				">>", "≫", "≪" };
		Arrays.sort(operator);
		if (Arrays.binarySearch(operator, s) > -1) {
			return true;
		} else {
			return false;
		}    }

    @Override
    public int priority(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOneMath(String c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isPostOperator(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isWord(char c1, char c2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isWord(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String standardize(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] trimString(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String standardizeMath(String[] s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String processInput(String sMath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postFix(String math) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double valueMath(String math) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String primeMulti(double num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
