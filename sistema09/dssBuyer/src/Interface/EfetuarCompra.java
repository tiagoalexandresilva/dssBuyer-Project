/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.BuyerException;
import Negocio.GestaoNegocios.Negocio;
import Negocio.GestaoProdutos.Produto;
import Negocio.GestaoUtilizadores.Utilizador;
import Negocio.dssBuyer;

/**
 *
 * @author helder
 */
public class EfetuarCompra extends javax.swing.JFrame {
    
    private Negocio negocio;
    private dssBuyer dssBuyer;

    /**
     * Creates new form EfetuarCompra
     */
    public EfetuarCompra(dssBuyer d, Negocio n) {
        this.negocio = n;
        this.dssBuyer = d;
        initComponents();
        this.tabCompra.setEnabledAt(0, false);
        this.tabCompra.setEnabledAt(1, false);
        this.tabCompra.setEnabledAt(2, false);
        this.tabCompra.setSelectedIndex(0);
        this.areaCompraTituloProduto.setText("Produto: "+this.negocio.getProduto().getTitulo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabCompra = new javax.swing.JTabbedPane();
        areaCompra = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        areaCompraQuantidade = new javax.swing.JTextField();
        areaCompraTituloProduto = new javax.swing.JLabel();
        areaMorada = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        areaMoradaMorada = new javax.swing.JTextField();
        areaMoradaCod = new javax.swing.JTextField();
        areaMoradaLocalidade = new javax.swing.JTextField();
        areaConfirmacao = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        areaConfirmacaoProduto = new javax.swing.JLabel();
        areaConfirmacaoQuantidade = new javax.swing.JLabel();
        areaConfirmacaoPreco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton3.setText("Seguinte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade:");

        areaCompraTituloProduto.setText("jLabel2");

        org.jdesktop.layout.GroupLayout areaCompraLayout = new org.jdesktop.layout.GroupLayout(areaCompra);
        areaCompra.setLayout(areaCompraLayout);
        areaCompraLayout.setHorizontalGroup(
            areaCompraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(areaCompraLayout.createSequentialGroup()
                .add(areaCompraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, areaCompraLayout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton3))
                    .add(areaCompraLayout.createSequentialGroup()
                        .add(92, 92, 92)
                        .add(areaCompraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(areaCompraTituloProduto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 351, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(areaCompraLayout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(areaCompraQuantidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        areaCompraLayout.setVerticalGroup(
            areaCompraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, areaCompraLayout.createSequentialGroup()
                .add(27, 27, 27)
                .add(areaCompraTituloProduto)
                .add(24, 24, 24)
                .add(areaCompraLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(areaCompraQuantidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 135, Short.MAX_VALUE)
                .add(jButton3)
                .addContainerGap())
        );

        tabCompra.addTab("Compra", areaCompra);

        jButton2.setText("Seguinte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Anterior");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Morada:");

        jLabel3.setText("Código postal:");

        jLabel4.setText("Localidade:");

        org.jdesktop.layout.GroupLayout areaMoradaLayout = new org.jdesktop.layout.GroupLayout(areaMorada);
        areaMorada.setLayout(areaMoradaLayout);
        areaMoradaLayout.setHorizontalGroup(
            areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, areaMoradaLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2)
                .addContainerGap())
            .add(areaMoradaLayout.createSequentialGroup()
                .add(107, 107, 107)
                .add(areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel4)
                    .add(jLabel3)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(areaMoradaMorada)
                    .add(areaMoradaCod)
                    .add(areaMoradaLocalidade, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        areaMoradaLayout.setVerticalGroup(
            areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, areaMoradaLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(areaMoradaMorada, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(areaMoradaCod, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(areaMoradaLocalidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 78, Short.MAX_VALUE)
                .add(areaMoradaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(jButton4))
                .addContainerGap())
        );

        tabCompra.addTab("Morada", areaMorada);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Anterior");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        areaConfirmacaoProduto.setText("Produto:");

        areaConfirmacaoQuantidade.setText("Quantidade:");

        areaConfirmacaoPreco.setText("Preco:");

        org.jdesktop.layout.GroupLayout areaConfirmacaoLayout = new org.jdesktop.layout.GroupLayout(areaConfirmacao);
        areaConfirmacao.setLayout(areaConfirmacaoLayout);
        areaConfirmacaoLayout.setHorizontalGroup(
            areaConfirmacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, areaConfirmacaoLayout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .add(jButton5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .addContainerGap())
            .add(areaConfirmacaoLayout.createSequentialGroup()
                .add(83, 83, 83)
                .add(areaConfirmacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(areaConfirmacaoPreco)
                    .add(areaConfirmacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(areaConfirmacaoProduto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(areaConfirmacaoQuantidade, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        areaConfirmacaoLayout.setVerticalGroup(
            areaConfirmacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, areaConfirmacaoLayout.createSequentialGroup()
                .add(23, 23, 23)
                .add(areaConfirmacaoProduto)
                .add(18, 18, 18)
                .add(areaConfirmacaoQuantidade)
                .add(18, 18, 18)
                .add(areaConfirmacaoPreco)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 123, Short.MAX_VALUE)
                .add(areaConfirmacaoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton5))
                .addContainerGap())
        );

        tabCompra.addTab("Confirmacao", areaConfirmacao);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabCompra)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabCompra)
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            int quantidade = Integer.parseInt(this.areaCompraQuantidade.getText());
            if (quantidade <= 0) {
                throw new BuyerException("Quantidade inválida...");
            }
            Produto p = this.negocio.getProduto();
            if (p.getStock() < quantidade) {
                throw new BuyerException("Não existe stock suficiente para satisfazer a sua compra...");
            }
            this.negocio.setQuantidade(quantidade);
            this.negocio.setMontantePago(quantidade * p.getPreco());
            this.preencheAreaMorada();
            this.tabCompra.setSelectedIndex(1);
        }
        catch (NumberFormatException e) {javax.swing.JOptionPane.showMessageDialog(this, "Quantidade inválida");
        }
        catch (Exception e) {javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String moradaV = this.areaMoradaMorada.getText();
            String localidadeV = this.areaMoradaLocalidade.getText();
            String codV = this.areaMoradaCod.getText();
            if (moradaV.equals("") || localidadeV.equals("") || codV.equals("")) {
                throw new BuyerException("Tem de preencher todos os campos...");
            }
            Utilizador u = this.negocio.getComprador();
            u.setMorada(moradaV);
            u.setCodPostal(codV);
            u.setLocalidade(localidadeV);
            this.dssBuyer.actualizaUtilizador(u);
            this.preencheAreaConfirmacao();
            this.tabCompra.setSelectedIndex(2);
        }
        catch (Exception e) {javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.tabCompra.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.tabCompra.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Produto p = this.negocio.getProduto();
            p.setStock(p.getStock() - this.negocio.getQuantidade());
            this.dssBuyer.addNegocio(this.negocio);
            this.dssBuyer.actualizaProduto(p);
            new TalaoCompra(this.negocio).setVisible(true);
            this.dispose();
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaCompra;
    private javax.swing.JTextField areaCompraQuantidade;
    private javax.swing.JLabel areaCompraTituloProduto;
    private javax.swing.JPanel areaConfirmacao;
    private javax.swing.JLabel areaConfirmacaoPreco;
    private javax.swing.JLabel areaConfirmacaoProduto;
    private javax.swing.JLabel areaConfirmacaoQuantidade;
    private javax.swing.JPanel areaMorada;
    private javax.swing.JTextField areaMoradaCod;
    private javax.swing.JTextField areaMoradaLocalidade;
    private javax.swing.JTextField areaMoradaMorada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTabbedPane tabCompra;
    // End of variables declaration//GEN-END:variables

    private void preencheAreaMorada() {
        Utilizador u = this.negocio.getComprador();
        this.areaMoradaMorada.setText(u.getMorada());
        this.areaMoradaCod.setText(u.getCodPostal());
        this.areaMoradaLocalidade.setText(u.getLocalidade());
    }

    private void preencheAreaConfirmacao() {
        this.areaConfirmacaoPreco.setText("Preco: "+this.negocio.getMontantePago());
        this.areaConfirmacaoProduto.setText("Produto: "+this.negocio.getProduto().getTitulo());
        this.areaConfirmacaoQuantidade.setText("Quantidade: "+this.negocio.getQuantidade());
    }
}
