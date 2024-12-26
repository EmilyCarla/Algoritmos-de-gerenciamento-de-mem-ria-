class WorstFit implements AlgoritmoAlocacao {
    @Override
    public void alocar(Processo processo, Memoria memoria) {
        int piorInicio = -1;
        int maiorEspaco = -1;

        for (int i = 0; i <= memoria.getTamanho() - processo.tamanho; i++) {
            if (memoria.verificarEspacoLivre(i, processo.tamanho)) {
                int espacoDisponivel = calcularEspacoDisponivel(i, memoria);
                if (espacoDisponivel > maiorEspaco) {
                    piorInicio = i;
                    maiorEspaco = espacoDisponivel;
                }
            }
        }

        if (piorInicio != -1) {
            memoria.alocarMemoria(piorInicio, processo.tamanho, processo.id);
        } else {
            System.out.println("Erro: Não foi possível alocar o processo " + processo.id);
        }
    }

    private int calcularEspacoDisponivel(int inicio, Memoria memoria) {
        int tamanho = 0;
        int[] mem = memoria.getMemoria();
        while (inicio + tamanho < memoria.getTamanho() && mem[inicio + tamanho] == 0) {
            tamanho++;
        }
        return tamanho;
    }
}