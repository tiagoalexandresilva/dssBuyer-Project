/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.BuyerException;
import Negocio.GestaoNegocios.Negocio;
import Negocio.GestaoUtilizadores.Utilizador;
import Negocio.dssBuyer;

/**
 *
 * @author helder
 */
public class FeedbackComprador extends javax.swing.JFrame {
    
    private dssBuyer dssBuyer;
    private Negocio negocio;

    /**
     * Creates new form FeedbackComprador
     */
    public FeedbackComprador(dssBuyer d, Negocio n) {
        this.dssBuyer = d;
        this.negocio = n;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        positivo = new javax.swing.JRadioButton();
        negativo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Vendedor:");

        positivo.setText("Positivo");

        negativo.setText("Negativo");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Comentarios:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(positivo)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(negativo)))
                        .add(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(negativo)
                    .add(positivo))
                .add(18, 18, 18)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(17, 17, 17)
                .add(jButton1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (this.positivo.isSelected() == this.negativo.isSelected()) {
                throw new BuyerException("Tem de selecionar positivo ou negativo");
            }
            if (this.jTextArea1.getText().equals("")) {
                throw new BuyerException("Tem de inserir um comentário");
            }
            Utilizador vendedor = this.negocio.getVendedor();
            if (this.positivo.isSelected()) {
                vendedor.incrementaFeed();
            }
            else {
                vendedor.decrementaFeed();
            }
            this.negocio.setFeedComprador(this.jTextArea1.getText());
            this.dssBuyer.atualizaNegocio(this.negocio);
            this.dssBuyer.actualizaUtilizador(vendedor);
            javax.swing.JOptionPane.showMessageDialog(this, "Feedback inserido com sucesso...");
            this.dispose();
        }
        catch (Exception e) {javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton negativo;
    private javax.swing.JRadioButton positivo;
    // End of variables declaration//GEN-END:variables
}
