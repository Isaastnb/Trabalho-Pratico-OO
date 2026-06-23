package br.edu.cafeteria.modelo;

import br.edu.cafeteria.servico.Promocional;

public class Bebida extends Produto implements Promocional {
    
    private TamanhoBebida tamanho;
    private int miligramasCafeina;
    private TemperaturaBebida temperatura;
    
    public Bebida(String codigo, String nome, double precoBase, int quantidadeEstoque,
                  TamanhoBebida tamanho, int miligramasCafeina, TemperaturaBebida temperatura) {
        
        super(codigo, nome, precoBase, quantidadeEstoque);
        
        this.tamanho = tamanho;
        this.miligramasCafeina = miligramasCafeina;
        this.temperatura = temperatura;
    }
    
    @Override
    public double aplicarDesconto(double percentual) {
        double desconto = getPrecoBase() * (percentual / 100.0);
        return getPrecoBase() - desconto;
    }
    
    public TamanhoBebida getTamanho() {
        return tamanho;
    }

    public int getMiligramasCafeina() {
        return miligramasCafeina;
    }

    public TemperaturaBebida getTemperatura() {
        return temperatura;
    }
}