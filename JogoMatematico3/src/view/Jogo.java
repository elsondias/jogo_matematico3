package view;

import main.Calculos;

import javax.swing.JOptionPane;

public class Jogo {
    static int pontos = 0;
    static Calculos calculos;

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        int nivel = obterNivel();

        calculos = new Calculos(nivel);

        int operacao = calculos.getOperacao();
        String pergunta = criarPergunta(calculos);

        int resposta = Integer.parseInt(JOptionPane.showInputDialog(pergunta));
        boolean respostaCorreta = verificarResposta(operacao, resposta);

        if (respostaCorreta) {
            pontos++;
            JOptionPane.showMessageDialog(null, "Você tem " + pontos + " ponto(s).");
        } else {
            String respostaCerta = calcularRespostaCorreta(calculos);
            JOptionPane.showMessageDialog(null, "Resposta incorreta. A resposta correta é: " + respostaCerta);
        }

        int continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar? [1 - SIM, 0 - NÃO]"));

        if (continuar == 1) {
            play();
        } else {
            encerrarJogo();
        }
    }

    private static int obterNivel() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe o nivel de dificuldade desejado [1 ou 2]:"));
    }

    private static String criarPergunta(Calculos calculos) {
        String operador = calculos.obterOperador();
        return calculos.getValor1() + operador + calculos.getValor2();
    }

    private static boolean verificarResposta(int operacao, int resposta) {
        return switch (operacao) {
            case 0 -> calculos.somar(resposta);
            case 1 -> calculos.subtrair(resposta);
            case 2 -> calculos.multiplicar(resposta);
            default -> throw new IllegalArgumentException("Operação Inválida");
        };
    }

    private static String calcularRespostaCorreta(Calculos calculos) {
        return calculos.getValor1() + calculos.obterOperador() + calculos.getValor2() + " = " + calculos.realizarOperacao();
    }

    private static void encerrarJogo() {
        JOptionPane.showMessageDialog(null, "Você fez " + pontos + " ponto(s).\nAté a próxima!");
        System.exit(0);
    }
}
