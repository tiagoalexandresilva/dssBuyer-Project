/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.GestaoUtilizadores.Administrador;

/**
 *
 * @author helder
 */
public class Preenche implements Runnable {
    
    private EcraPrincipal ecra;
    
    public Preenche(EcraPrincipal e) {
        this.ecra = e;
    }

    @Override
    public void run() {
        this.ecra.procuraProdutos();
        this.ecra.preencheAreaCompras();
        this.ecra.preencheAreaVendas();
        this.ecra.preencheAreaStock();
        this.ecra.preencheAreaPropostas();
        if (this.ecra.getUtilizador() instanceof Administrador) {
            this.ecra.preencheAreaAdmin();
        }
    }
    
}
