/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatormt;

/**
 *
 * @author HM
 */
import Info.Info;
import calculatormt.Balan.Balan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class Giaodien  extends JFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private int frameWidth = 300;
	private int frameHeight = 400;
	private int xframeShow = 400;
	private int yframeShow = 100;
	private JTextField tfDisplay;
	private JLabel lbAns, lbStats, lbDOH, lbB;
	private int mode = 0;
	private JFrame frame;

	private JPanel mainPanel;
	private JPanel disPlayPanel;
	private JPanel buttonPanel;

	private JButton btnArr[];
	private JButton btnArrSub[];
	private JRadioButton radDeg, radRad;
	private JRadioButton radBin, radOct, radDec, radHex;

	private String lbButton[];
	private String mathElement[];
	private String varElement[];
	private double ans = 0;

	private Color colorDisableStats = Color.lightGray,
			colorEnnabaleStar = Color.black;

	private boolean isSTO = false;
	private Balan balan;	
	private Info help, about;

	public Giaodien() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(xframeShow, yframeShow, frameWidth, frameHeight);
		frame.setJMenuBar(createMenuBar());
		resetValue(); // dat lai cac gia tri
		changeMode(); // che do hien thi
	}
        // dat lai gia tri cho balan
	private void resetValue() {
		balan = new Balan();
		balan.setError(false);
		if (mode == 2) {
			setRadix();
		}
		if (mode == 1) {
			setDegOrRad();
		}
	}

    // cho phep chen ky tu vao vi tri con tro
	private void insertMathString(String str) {
		int index = tfDisplay.getCaretPosition();
		StringBuilder s = new StringBuilder(tfDisplay.getText() + ""); // copy
		s.insert(index, str); // insert text at index control
		String s1 = new String(s); // convert to string
		tfDisplay.setText(s1); // set text for jtextField
		tfDisplay.requestFocus(); // focus jtextFiedl
		tfDisplay.setCaretPosition(index + str.length());
	}

	// tra ve ket qua
	private void result() {
		balan.setError(false);
		ans = balan.valueMath(tfDisplay.getText());
		if (!balan.isError()) {
			balan.var[0] = ans;
			lbAns.setText(balan.numberToString(ans, balan.getRadix(),
					balan.getSizeRound()));
		} else {
			lbAns.setText("Math error!");
		}
		// hien thi ket qua trong che do Program
		setLabelProgram();
	}

	// hien thi ket qua trong che do Program
	private void setLabelProgram() {
		if (mode == 2) {
			long num = 0;
			if (balan.isIntegerNumber(ans) && ans >= 0 && !balan.isError()) {
				num = (int) ans;
				lbDOH.setText(num + "₁₀ = "
						+ Long.toHexString(num).toUpperCase() + "₁₆ = "
						+ Long.toOctalString(num) + "₈");

				String bi = Long.toBinaryString(num);
				StringBuilder s = new StringBuilder(bi);
				int i = s.length();
				while (i < 32) {
					s.insert(0, "0");
					i++;
				}
				bi = "";
				for (i = 1; i <= s.length(); i++) {
					bi += s.charAt(i - 1);
					if (i % 4 == 0 && i < s.length()) {
						bi += "  ";
					}
				}
				bi += "₂";

				lbB.setText(bi);

				enabaleLabelProgram(true);
			} else {
				enabaleLabelProgram(false);
			}
		}
	}

	// dat che do hien thi hay khong hient thi cho Label Program
	private void enabaleLabelProgram(boolean is) {
		if (mode == 2) {
			lbDOH.setEnabled(is);
			lbB.setEnabled(is);
		}
	}

	private void actionCE() {
		balan.setError(false);
		isSTO = false;
		if (mode == 1) {
			lbStats.setForeground(colorDisableStats);
		}
		tfDisplay.setText("");
		tfDisplay.requestFocus();
		enabaleLabelProgram(true);
		lbAns.setText("0");
		if (mode == 2) {
			lbDOH.setText("0₁₀ = 0₁₆ = 0₈");
			lbB.setText("0000  0000  0000  0000  0000  0000  0000  0000₂");
		}

	}

	private void actionDel() {
		int index = tfDisplay.getCaretPosition();
		StringBuilder s = new StringBuilder(tfDisplay.getText() + ""); // copy
		if (index > 0) {
			s.deleteCharAt(index - 1);
			String s1 = new String(s); // convert to string
			tfDisplay.setText(s1); // set text for jtextField
			tfDisplay.setCaretPosition(index - 1);
		}
		tfDisplay.requestFocus(); // focus jtextFiedl
	}

	private void setDegOrRad() {
		if (radRad.isSelected()) {
			balan.setDegOrRad(false);
		}
		if (radDeg.isSelected()) {
			balan.setDegOrRad(true);
		}
		tfDisplay.requestFocus();
	}

	private void setRadix() {
		if (radBin.isSelected()) {
			balan.setRadix(2);
		}
		if (radOct.isSelected()) {
			balan.setRadix(8);
		}
		if (radDec.isSelected()) {
			balan.setRadix(10);
		}
		if (radHex.isSelected()) {
			balan.setRadix(16);
		}
		tfDisplay.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();

		// action on menu
		if (command == "Basic") {
			mode = 0;
			changeMode();
			return;
		}
		if (command == "Advanced") {
			mode = 1;
			changeMode();
			setDegOrRad();
			return;
		}
		if (command == "Program") {
			mode = 2;
			changeMode();
			setRadix();
			return;
		}
		if (command == "Exit") {
			System.exit(0);
		}

		if (command == "Help") {
			if (help == null) {
				help = new HelpAndAbout(0, "Calculator - Help");
			}
			help.setVisible(true);
		}

		if (command == "About") {
			if (about == null) {
				about = new HelpAndAbout(1, "Calculator - About");
			}
			about.setVisible(true);
		}

		// action on radioButton
		if (evt.getSource() == radRad || evt.getSource() == radDeg) {
			setDegOrRad();
			return;
		}

		// button dac biet
		if (evt.getSource() == btnArr[0]) {
			resetValue();
			actionCE();
			return;
		}
		if (evt.getSource() == btnArr[1]) {
			actionCE();
			return;
		}

		if (evt.getSource() == btnArr[2]) {
			actionDel();
			return;
		}

		// neu trong che do Advanced
		if (mode == 1) {
			if (evt.getSource() == btnArrSub[0]) {
				if (!isSTO) {
					isSTO = true;
					lbStats.setForeground(colorEnnabaleStar);
				} else {
					isSTO = false;
					lbStats.setForeground(colorDisableStats);
				}
			} else {

				for (int i = 1; i < btnArrSub.length; i++) {
					if (evt.getSource() == btnArrSub[i]) {
						if (isSTO) {
							result();
							tfDisplay.setCaretPosition(tfDisplay.getText()
									.length());
							insertMathString("→" + varElement[i]);
							balan.var[i] = ans;
							isSTO = false;
						} else {
							insertMathString(varElement[i]);
						}
					}
				}
				isSTO = false;
				lbStats.setForeground(colorDisableStats);
			}
		}

		if (mode == 2) {
			if (evt.getSource() == radBin || evt.getSource() == radOct
					|| evt.getSource() == radDec || evt.getSource() == radHex) {
				setRadix();
				return;
			}
		}

		for (int i = 0; i < btnArr.length; i++) {
			if (evt.getSource() == btnArr[i] && !mathElement[i].equals("")) {
				insertMathString(mathElement[i]);
				return;
			}
		}
		if (command == "=") {
			result();
			return;
		}
		if (command == "a*b") {
			result();
			if (!balan.isError()) {
				lbAns.setText(balan.primeMulti(ans));
			}
			return;
		}
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			result();
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {

	}

	@Override
	public void keyTyped(KeyEvent ke) {

	}
}

}
