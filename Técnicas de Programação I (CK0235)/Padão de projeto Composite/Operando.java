//Leaf
public class Operando extends Expressao {
    float valor;

    public Operando(float valor) {
        this.valor = valor;
    }

    @Override
    float operation() {
        return valor;
    }

    @Override
    void add(Expressao esq, Expressao dir) {
    }

    @Override
    void remove(Expressao e) {
    }

    @Override
    void getChild() {
    }

    
}
