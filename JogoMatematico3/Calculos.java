import java.util.Random;

public class Calculos {
    private int nivel;
    private int valor1;
    private int valor2;
    private int operacao;

    public Calculos(int nivel) {
        Random random = new Random();
        operacao = random.nextInt(3);
        this.nivel = nivel;

        if (nivel == 1) {
            valor1 = random.nextInt(10);
            valor2 = random.nextInt(50);
        } else {
            valor1 = random.nextInt(100);
            valor2 = random.nextInt(150);
        }
    }

    public int getNivel() {
        return nivel;
    }

    public int getValor1() {
        return valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public String obterOperador() {
        switch (operacao) {
            case 0:
                return " + ";
            case 1:
                return " - ";
            case 2:
                return " x ";
            default:
                throw new IllegalArgumentException("Operação Inválida");
        }
    }

    public int realizarOperacao() {
        switch (operacao) {
            case 0:
                return valor1 + valor2;
            case 1:
                return valor1 - valor2;
            case 2:
                return valor1 * valor2;
            default:
                throw new IllegalArgumentException("Operação Inválida");
        }
    }

    public boolean somar(int resposta) {
        return resposta == realizarOperacao();
    }

    public boolean subtrair(int resposta) {
        return resposta == realizarOperacao();
    }

    public boolean multiplicar(int resposta) {
        return resposta == realizarOperacao();
    }

    public int getOperacao() {
        return operacao;
    }
}
