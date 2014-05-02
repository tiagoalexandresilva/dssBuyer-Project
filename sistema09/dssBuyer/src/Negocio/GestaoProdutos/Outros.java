package Negocio.GestaoProdutos;

import Negocio.GestaoUtilizadores.Utilizador;

public class Outros extends Produto {
    
    public Outros(String t, String d, int s, float p, Utilizador u) {
        super(t, d, s, p, u);
    }
    
    public Outros(String id, String t, String d, int s, float p, boolean b, Utilizador u) {
        super(id, t, d, s, p, b, u);
    }
    
}