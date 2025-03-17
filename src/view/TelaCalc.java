package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TelaCalc extends javax.swing.JFrame {
    private int operation = 0;
    private double firstNumber = 0D;

    public TelaCalc() {
        initComponents();
        actions();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDisplay = new javax.swing.JPanel();
        jtfDisplay = new javax.swing.JTextField();
        jpButtons = new javax.swing.JPanel();
        jpNumbers = new javax.swing.JPanel();
        jbButton9 = new javax.swing.JButton();
        jbButton8 = new javax.swing.JButton();
        jbButton7 = new javax.swing.JButton();
        jbButton6 = new javax.swing.JButton();
        jbButton5 = new javax.swing.JButton();
        jbButton4 = new javax.swing.JButton();
        jbButton3 = new javax.swing.JButton();
        jbButton2 = new javax.swing.JButton();
        jbButton1 = new javax.swing.JButton();
        jbComma = new javax.swing.JButton();
        jbButton0 = new javax.swing.JButton();
        jbEquals = new javax.swing.JButton();
        jpOperators = new javax.swing.JPanel();
        jbClear = new javax.swing.JButton();
        jbPlus = new javax.swing.JButton();
        jbMinus = new javax.swing.JButton();
        jbMultiply = new javax.swing.JButton();
        jbDivide = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setResizable(false);
        setSize(new java.awt.Dimension(400, 600));

        this.pack();
        this.setLocationRelativeTo(null);

        jtfDisplay.setEditable(false);
        jtfDisplay.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jtfDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDisplay.setText("0");
        jtfDisplay.setPreferredSize(new java.awt.Dimension(360, 40));

        javax.swing.GroupLayout jpDisplayLayout = new javax.swing.GroupLayout(jpDisplay);
        jpDisplay.setLayout(jpDisplayLayout);
        jpDisplayLayout.setHorizontalGroup(
            jpDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDisplayLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jtfDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jpDisplayLayout.setVerticalGroup(
            jpDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDisplayLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jtfDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jpDisplay, java.awt.BorderLayout.NORTH);

        jpNumbers.setLayout(new java.awt.GridLayout(4, 3));

        jbButton9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton9.setText("9");
        jbButton9.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton9);

        jbButton8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton8.setText("8");
        jbButton8.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton8);

        jbButton7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton7.setText("7");
        jbButton7.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton7);

        jbButton6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton6.setText("6");
        jbButton6.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton6);

        jbButton5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton5.setText("5");
        jbButton5.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton5);

        jbButton4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton4.setText("4");
        jbButton4.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton4);

        jbButton3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton3.setText("3");
        jbButton3.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton3);

        jbButton2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton2.setText("2");
        jbButton2.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton2);

        jbButton1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton1.setText("1");
        jbButton1.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton1);

        jbComma.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbComma.setText(",");
        jbComma.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbComma);

        jbButton0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbButton0.setText("0");
        jbButton0.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbButton0);

        jbEquals.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbEquals.setText("=");
        jbEquals.setPreferredSize(new java.awt.Dimension(50, 50));
        jpNumbers.add(jbEquals);

        jpOperators.setLayout(new java.awt.GridLayout(5, 1));

        jbClear.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbClear.setText("C");
        jbClear.setPreferredSize(new java.awt.Dimension(50, 50));
        jpOperators.add(jbClear);

        jbPlus.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbPlus.setText("+");
        jbPlus.setPreferredSize(new java.awt.Dimension(50, 50));
        jpOperators.add(jbPlus);

        jbMinus.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbMinus.setText("-");
        jbMinus.setPreferredSize(new java.awt.Dimension(50, 50));
        jpOperators.add(jbMinus);

        jbMultiply.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbMultiply.setText("*");
        jbMultiply.setPreferredSize(new java.awt.Dimension(50, 50));
        jpOperators.add(jbMultiply);

        jbDivide.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jbDivide.setText("/");
        jbDivide.setPreferredSize(new java.awt.Dimension(50, 50));
        jpOperators.add(jbDivide);

        javax.swing.GroupLayout jpButtonsLayout = new javax.swing.GroupLayout(jpButtons);
        jpButtons.setLayout(jpButtonsLayout);
        jpButtonsLayout.setHorizontalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jpNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jpOperators, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jpButtonsLayout.setVerticalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOperators, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jpButtons, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actions() {        
        jbClear.addActionListener((e) -> {
           jtfDisplay.setText("0");
           firstNumber = 0D;
           operation = 0;
        });
        
        
        jbComma.addActionListener((e) -> {
           if(!jtfDisplay.getText().contains(",")) {
               jtfDisplay.setText(jtfDisplay.getText() + ".");
           } 
        });
        
        jbEquals.addActionListener((e) -> {
            runPrevOperation();
            operation = 0;
        });
        
        jbPlus.addActionListener((e) -> {
            runPrevOperation();
            operation = 1;
            jtfDisplay.setText("0");
        });
        
        jbMinus.addActionListener((e) -> {
            runPrevOperation();
            operation = 2;
            jtfDisplay.setText("0");
        });
        
        jbMultiply.addActionListener((e) -> {
            runPrevOperation();
            operation = 3;
            jtfDisplay.setText("0");
        });
        
        jbDivide.addActionListener((e) -> {
            runPrevOperation();
            operation = 4;
            jtfDisplay.setText("0");
        });
        
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton buttonClicked = (JButton) e.getSource();
                String buttonText = buttonClicked.getText();
                
                String currentText = jtfDisplay.getText();
                if (currentText.equals("0")) {
                    jtfDisplay.setText(buttonText);
                } else {
                    jtfDisplay.setText(currentText + buttonText);
                }
            }
        };
        
        jbButton0.addActionListener(numberListener);
        jbButton1.addActionListener(numberListener);
        jbButton2.addActionListener(numberListener);
        jbButton3.addActionListener(numberListener);
        jbButton4.addActionListener(numberListener);
        jbButton5.addActionListener(numberListener);
        jbButton6.addActionListener(numberListener);
        jbButton7.addActionListener(numberListener);
        jbButton8.addActionListener(numberListener);
        jbButton9.addActionListener(numberListener);
    }
    
    private void runPrevOperation() {
        Double currentNumber = Double.valueOf(jtfDisplay.getText());
        
        switch (operation) {
            case 0:
                firstNumber = currentNumber;
                break;
            case 1:
                firstNumber += currentNumber;
                break;
            case 2:
                firstNumber -= currentNumber;
                break;
            case 3:
                firstNumber *= currentNumber;
                break;
            case 4:
                firstNumber /= currentNumber;
                break;
            default:
                throw new AssertionError();
        }
        jtfDisplay.setText(String.valueOf(firstNumber));
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbButton0;
    private javax.swing.JButton jbButton1;
    private javax.swing.JButton jbButton2;
    private javax.swing.JButton jbButton3;
    private javax.swing.JButton jbButton4;
    private javax.swing.JButton jbButton5;
    private javax.swing.JButton jbButton6;
    private javax.swing.JButton jbButton7;
    private javax.swing.JButton jbButton8;
    private javax.swing.JButton jbButton9;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbComma;
    private javax.swing.JButton jbDivide;
    private javax.swing.JButton jbEquals;
    private javax.swing.JButton jbMinus;
    private javax.swing.JButton jbMultiply;
    private javax.swing.JButton jbPlus;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JPanel jpDisplay;
    private javax.swing.JPanel jpNumbers;
    private javax.swing.JPanel jpOperators;
    private javax.swing.JTextField jtfDisplay;
    // End of variables declaration//GEN-END:variables
}
