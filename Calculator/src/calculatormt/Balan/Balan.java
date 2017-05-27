/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatormt.Balan;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long combination(int a, int b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double convertToDeg(double num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double convertToRad(double num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isNumber(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isNumber(char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double stringToNumber(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String numberToString(double num, int radix, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexVar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexConst(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isVarOrConst(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOperator(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
