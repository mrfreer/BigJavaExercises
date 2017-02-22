import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by dfreer on 2/22/2017.
 */
public class BankAccount {
    private JTextField textFieldDeposit;
    private JLabel jLabelRemainingDep;
    private JLabel jLabelRemainingWith;
    private JTextField textFieldWithdrawal;
    private JButton makeDepositButton;
    private JButton makeWithdrawalButton;
    private JLabel jLabelTotalFees;
    private JPanel jPanel;
    private JLabel jLabelBalance;
    private double totalFees = 0.0;
    private double totalBalance = 0.0;
    private int numFreeDeposits = 5, numFreeWithdrawls = 5;
    private final double charge = 2.5;
    private double curAmt = 0.0;
    NumberFormat nf = DecimalFormat.getCurrencyInstance();
    public BankAccount() {
        makeDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isGood = true;
                try{
                    curAmt = Double.parseDouble(textFieldDeposit.getText());
                }catch (NumberFormatException exc){
                    JOptionPane.showConfirmDialog(null, "Must be a number.");
                    isGood = false;
                }
                if(isGood){
                    totalBalance += curAmt;
                    numFreeDeposits--;
                    if(numFreeDeposits <= 0){
                        totalFees += charge;

                        jLabelTotalFees.setText(nf.format(totalFees));
                    }

                }
                System.out.println(totalBalance);
                textFieldDeposit.setText("");
            jLabelBalance.setText("Balance " + nf.format(totalBalance));
            jLabelRemainingDep.setText("Remaining deposits: " + numFreeDeposits);
            }
        });

        makeWithdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isGood = true;
                try{
                    curAmt = Double.parseDouble(textFieldWithdrawal.getText());
                }catch (NumberFormatException exc){
                    JOptionPane.showConfirmDialog(null, "Must be a number.");
                    isGood = false;
                }
                if(isGood){
                    totalBalance -= curAmt;
                    numFreeWithdrawls--;
                    if(numFreeWithdrawls <= 0){
                        totalFees += charge;
                        NumberFormat nf = DecimalFormat.getCurrencyInstance();
                        jLabelTotalFees.setText(nf.format(totalFees));
                    }
                }

            System.out.println(totalBalance);
                textFieldDeposit.setText("");
            jLabelBalance.setText("Balance " + nf.format(totalBalance));
            jLabelRemainingWith.setText("Remaining withdrawals: " + numFreeWithdrawls);
            }
        });
    }

    public static void main(String[] args) {
        JFrame j = new JFrame("Bank Account");
        j.setContentPane(new BankAccount().jPanel);
        j.pack();
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
