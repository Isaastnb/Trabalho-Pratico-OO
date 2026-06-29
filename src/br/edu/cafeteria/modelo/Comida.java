package br.edu.cafeteria.modelo;

import br.edu.cafeteria.servico.Promocional;

public class Comida extends Produto implements Promocional {
    
    private int tempoPreparo;
    private boolean isVegano;
    private boolean isSemGluten;
    
    public Comida(String codigo, String nome, float precoBase, int quantidadeEstoque,
                  int tempoPreparo, boolean isVegano, boolean isSemGluten) {
        
        super(codigo, nome, precoBase, quantidadeEstoque);
        
        this.tempoPreparo = tempoPreparo;
        this.isVegano = isVegano;
        this.isSemGluten = isSemGluten;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public boolean isSemGluten() {
        return isSemGluten;
    }

    public boolean isVegano() {
        return isVegano;
    }

    @Override
    public float aplicarDesconto(float percentual) {
        float desconto = getPrecoBase() * (percentual / 100.0f);
        return getPrecoBase() - desconto;
    }
}