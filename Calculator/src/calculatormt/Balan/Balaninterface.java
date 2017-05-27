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

public interface Balaninterface {
        public boolean isError = false;
	public String varString[] = { "ans", "va", "vb", "vc", "vd", "ve", "vf" };
	public String constString[] = { "pi", "π", "e" }; // mang chuoi cac hang
	public double var[] = new double[varString.length];
	public double cons[] = { Math.PI, Math.PI, Math.E };
	public boolean isDegOrRad = true;
	public int radix = 10, sizeRound = 10;
	public ConvertNumber convertNumber = new ConvertNumber();
    	public boolean isError();
	public void setError(boolean isError);
	public int getSizeRound();
	public void setSizeRound(int sizeRound);
	public int getRadix();
	public void setRadix(int radix) ;
	public boolean isDegOrRad() ;
	public void setDegOrRad(boolean isDegOrRad) ;
	public boolean isIntegerNumber(double num) ;
	public String myRound(double num, int size) ;
	

	// num!
	public long factorial(int num) ;
	

	// chinh hop chap b cua a=a!/(a-b)!=(a-b+1)(a-b+2)...a
	public long permutation(int a, int b) ;
	

	// to hop chap b cua a
	public long combination(int a, int b) ;
	

	public double convertToDeg(double num) ;
	

	public double convertToRad(double num) ;

	// kiem tra chuoi s co la so khong (bien cung la so)
	public boolean isNumber(String s) ;
		
	

	public boolean isNumber(char c) ;
	

	// Chuoi sang so
	public double stringToNumber(String s) ;

	public String numberToString(double num, int radix, int size) ;
	

	public int indexVar(String s) ;
	

	public int indexConst(String s) ;
	

	public boolean isVarOrConst(String s) ;
	

	// kiem tra xem co phai toan tu
	public boolean isOperator(String s) ;
	

	// thiet lap thu tu uu tien
	public int priority(String s) ;
	

	// kiem tra xem co phai la phep toan 1 ngoi
	public boolean isOneMath(String c) ;
	

	// kiem tra xem co phai phep toan dang sau
	public boolean isPostOperator(String s) ;

	// kiem tra xem cac ky tu lien nhau co la 1 tu khong
	public boolean isWord(char c1, char c2) ;

	// kiem tra chuoi s co la 1 tu khong
	public boolean isWord(String s) ;

	// chuan hoa chuoi
	public String standardize(String s) ;
	

	// cat chuoi thanh cac phan tu
	public String[] trimString(String s) ;
	public String standardizeMath(String[] s) ;

	public String processInput(String sMath) ;

	public String postFix(String math) ;

	public Double valueMath(String math) ;
	public String primeMulti(double num) ;

                }