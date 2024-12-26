class BestFit implements AlgoritmoAlocacao {
    @Override
    public void alocar(Processo processo, Memoria memoria) {
        int melhorInicio = -1;
        int menorEspaco = Integer.MAX_VALUE;

        for (int i = 0; i <= memoria.getTamanho() - processo.tamanho; i++) {
            if (memoria.verificarEspacoLivre(i, processo.tamanho)) {
                int espacoDisponivel = calcularEspacoDisponivel(i, memoria);
                if (espacoDisponivel < menorEspaco) {
                    melhorInicio = i;
                    menorEspaco = espacoDisponivel;
                }
            }
        }

        if (melhorInicio != -1) {
            memoria.alocarMemoria(melhorInicio, processo.tamanho, processo.id);
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