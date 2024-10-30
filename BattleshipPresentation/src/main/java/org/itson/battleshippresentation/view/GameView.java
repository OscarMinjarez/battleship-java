
package org.itson.battleshippresentation.view;


import javax.swing.JLabel;
import org.itson.battleshippresentation.modelView.GameModelView;

/**
 *
 * @author PabloCeasxr
 */
public class GameView extends javax.swing.JFrame {
    private static GameView instance;
    private GameModelView gameModelView;
    /**
     * Creates new form GameView
     */
    private GameView() {
        initComponents();
        loadTables(10,10);
        setLocationRelativeTo(this);
    }
    public static GameView getInstance(){
        if(instance ==null){
            instance = new GameView();
        }
        return instance;
    }
     public void clickShoot() {
       
         
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlYourShips = new javax.swing.JPanel();
        pnlEnemyShips = new javax.swing.JPanel();
        pnlRow = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        pnlColumn = new javax.swing.JPanel();
        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblE = new javax.swing.JLabel();
        lblF = new javax.swing.JLabel();
        lblG = new javax.swing.JLabel();
        lblH = new javax.swing.JLabel();
        lblI = new javax.swing.JLabel();
        lblJ = new javax.swing.JLabel();
        pnlEnemyRow = new javax.swing.JPanel();
        lblEnemy1 = new javax.swing.JLabel();
        lblEnemy2 = new javax.swing.JLabel();
        lblEnemy3 = new javax.swing.JLabel();
        lblEnemy4 = new javax.swing.JLabel();
        lblEnemy5 = new javax.swing.JLabel();
        lblEnemy6 = new javax.swing.JLabel();
        lblEnemy7 = new javax.swing.JLabel();
        lblEnemy8 = new javax.swing.JLabel();
        lblEnemy9 = new javax.swing.JLabel();
        lblEnemy10 = new javax.swing.JLabel();
        pnlEnemyColumn = new javax.swing.JPanel();
        lblEnemyA = new javax.swing.JLabel();
        lblEnemyB = new javax.swing.JLabel();
        lblEnemyC = new javax.swing.JLabel();
        lblEnemyD = new javax.swing.JLabel();
        lblEnemyE = new javax.swing.JLabel();
        lblEnemyF = new javax.swing.JLabel();
        lblEnemyG = new javax.swing.JLabel();
        lblEnemyH = new javax.swing.JLabel();
        lblEnemyI = new javax.swing.JLabel();
        lblEnemyJ = new javax.swing.JLabel();
        scrlHistory = new javax.swing.JScrollPane();
        txtHistory = new javax.swing.JTextArea();
        lblHisotry = new javax.swing.JLabel();
        btnShoot = new javax.swing.JButton();
        lblTurn = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        lblYourShips = new javax.swing.JLabel();
        lblEnemyShips = new javax.swing.JLabel();
        lblTimerTxt = new javax.swing.JLabel();
        lblTurnTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlYourShips.setLayout(new java.awt.GridLayout(10, 10, 2, 2));

        pnlEnemyShips.setLayout(new java.awt.GridLayout(10, 10, 2, 2));

        pnlRow.setLayout(new java.awt.GridLayout(10, 1));

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("1");
        pnlRow.add(lbl1);

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("2");
        pnlRow.add(lbl2);

        lbl3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("3");
        pnlRow.add(lbl3);

        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("4");
        pnlRow.add(lbl4);

        lbl5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("5");
        pnlRow.add(lbl5);

        lbl6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setText("6");
        pnlRow.add(lbl6);

        lbl7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setText("7");
        pnlRow.add(lbl7);

        lbl8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setText("8");
        pnlRow.add(lbl8);

        lbl9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setText("9");
        pnlRow.add(lbl9);

        lbl10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setText("10");
        pnlRow.add(lbl10);

        pnlColumn.setLayout(new java.awt.GridLayout(1, 10));

        lblA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblA.setText("A");
        pnlColumn.add(lblA);

        lblB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB.setText("B");
        pnlColumn.add(lblB);

        lblC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC.setText("C");
        pnlColumn.add(lblC);

        lblD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD.setText("D");
        pnlColumn.add(lblD);

        lblE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblE.setText("E");
        pnlColumn.add(lblE);

        lblF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF.setText("F");
        pnlColumn.add(lblF);

        lblG.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblG.setText("G");
        pnlColumn.add(lblG);

        lblH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH.setText("H");
        pnlColumn.add(lblH);

        lblI.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblI.setText("I");
        pnlColumn.add(lblI);

        lblJ.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJ.setText("J");
        pnlColumn.add(lblJ);

        pnlEnemyRow.setLayout(new java.awt.GridLayout(10, 1));

        lblEnemy1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy1.setText("1");
        pnlEnemyRow.add(lblEnemy1);

        lblEnemy2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy2.setText("2");
        pnlEnemyRow.add(lblEnemy2);

        lblEnemy3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy3.setText("3");
        pnlEnemyRow.add(lblEnemy3);

        lblEnemy4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy4.setText("4");
        pnlEnemyRow.add(lblEnemy4);

        lblEnemy5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy5.setText("5");
        pnlEnemyRow.add(lblEnemy5);

        lblEnemy6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy6.setText("6");
        pnlEnemyRow.add(lblEnemy6);

        lblEnemy7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy7.setText("7");
        pnlEnemyRow.add(lblEnemy7);

        lblEnemy8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy8.setText("8");
        pnlEnemyRow.add(lblEnemy8);

        lblEnemy9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy9.setText("9");
        pnlEnemyRow.add(lblEnemy9);

        lblEnemy10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemy10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemy10.setText("10");
        pnlEnemyRow.add(lblEnemy10);

        pnlEnemyColumn.setLayout(new java.awt.GridLayout(1, 10, 1, 0));

        lblEnemyA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyA.setText("A");
        pnlEnemyColumn.add(lblEnemyA);

        lblEnemyB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyB.setText("B");
        pnlEnemyColumn.add(lblEnemyB);

        lblEnemyC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyC.setText("C");
        pnlEnemyColumn.add(lblEnemyC);

        lblEnemyD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyD.setText("D");
        pnlEnemyColumn.add(lblEnemyD);

        lblEnemyE.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyE.setText("E");
        pnlEnemyColumn.add(lblEnemyE);

        lblEnemyF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyF.setText("F");
        pnlEnemyColumn.add(lblEnemyF);

        lblEnemyG.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyG.setText("G");
        pnlEnemyColumn.add(lblEnemyG);

        lblEnemyH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyH.setText("H");
        pnlEnemyColumn.add(lblEnemyH);

        lblEnemyI.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyI.setText("I");
        pnlEnemyColumn.add(lblEnemyI);

        lblEnemyJ.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEnemyJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyJ.setText("J");
        pnlEnemyColumn.add(lblEnemyJ);

        txtHistory.setEditable(false);
        txtHistory.setColumns(20);
        txtHistory.setRows(5);
        txtHistory.setText("El oskr failed shoot ....\nEl otro jugador hits  the el Oskr's ships in G3\nEl otro jugador failed the shot 4I");
        scrlHistory.setViewportView(txtHistory);

        lblHisotry.setText("history...");

        btnShoot.setText("shoot!");

        lblTurn.setFont(new java.awt.Font("Miriam Mono CLM", 1, 14)); // NOI18N
        lblTurn.setText("Turn:");

        lblTimer.setFont(new java.awt.Font("Miriam Mono CLM", 1, 14)); // NOI18N
        lblTimer.setText("Timer:");

        lblYourShips.setFont(new java.awt.Font("Miriam Mono CLM", 1, 24)); // NOI18N
        lblYourShips.setText("Your Ships");

        lblEnemyShips.setFont(new java.awt.Font("Miriam Mono CLM", 1, 24)); // NOI18N
        lblEnemyShips.setText("Enemy Ships");

        lblTimerTxt.setFont(new java.awt.Font("Miriam Mono CLM", 1, 14)); // NOI18N
        lblTimerTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimerTxt.setText("0");

        lblTurnTxt.setFont(new java.awt.Font("Miriam Mono CLM", 1, 14)); // NOI18N
        lblTurnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurnTxt.setText("<User>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTimer)
                            .addComponent(lblTurn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTimerTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTurnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(777, 777, 777))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pnlRow, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlYourShips, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66)
                                .addComponent(pnlEnemyRow, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlEnemyColumn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlEnemyShips, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblYourShips)
                                .addGap(307, 307, 307)
                                .addComponent(lblEnemyShips)
                                .addGap(113, 113, 113)))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblHisotry, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnShoot)
                                .addGap(18, 18, 18))
                            .addComponent(scrlHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTurn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTurnTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimerTxt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblYourShips, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEnemyShips, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlYourShips, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlEnemyShips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlEnemyRow, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlEnemyColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShoot)
                    .addComponent(lblHisotry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTables(int row,int column){
        int totalElements = row*column;
        for(int i=0;i<totalElements;i++){
                JLabel lblYourShip = new JLabel();
                lblYourShip.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                JLabel lblForEnemy = new JLabel();
                lblForEnemy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
                this.pnlYourShips.add(lblYourShip);
                this.pnlEnemyShips.add(lblForEnemy);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getInstance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShoot;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblE;
    private javax.swing.JLabel lblEnemy1;
    private javax.swing.JLabel lblEnemy10;
    private javax.swing.JLabel lblEnemy2;
    private javax.swing.JLabel lblEnemy3;
    private javax.swing.JLabel lblEnemy4;
    private javax.swing.JLabel lblEnemy5;
    private javax.swing.JLabel lblEnemy6;
    private javax.swing.JLabel lblEnemy7;
    private javax.swing.JLabel lblEnemy8;
    private javax.swing.JLabel lblEnemy9;
    private javax.swing.JLabel lblEnemyA;
    private javax.swing.JLabel lblEnemyB;
    private javax.swing.JLabel lblEnemyC;
    private javax.swing.JLabel lblEnemyD;
    private javax.swing.JLabel lblEnemyE;
    private javax.swing.JLabel lblEnemyF;
    private javax.swing.JLabel lblEnemyG;
    private javax.swing.JLabel lblEnemyH;
    private javax.swing.JLabel lblEnemyI;
    private javax.swing.JLabel lblEnemyJ;
    private javax.swing.JLabel lblEnemyShips;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblG;
    private javax.swing.JLabel lblH;
    private javax.swing.JLabel lblHisotry;
    private javax.swing.JLabel lblI;
    private javax.swing.JLabel lblJ;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JLabel lblTimerTxt;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JLabel lblTurnTxt;
    private javax.swing.JLabel lblYourShips;
    private javax.swing.JPanel pnlColumn;
    private javax.swing.JPanel pnlEnemyColumn;
    private javax.swing.JPanel pnlEnemyRow;
    private javax.swing.JPanel pnlEnemyShips;
    private javax.swing.JPanel pnlRow;
    private javax.swing.JPanel pnlYourShips;
    private javax.swing.JScrollPane scrlHistory;
    private javax.swing.JTextArea txtHistory;
    // End of variables declaration//GEN-END:variables
}
