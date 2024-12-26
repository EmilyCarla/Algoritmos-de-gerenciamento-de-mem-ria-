class NextFit implements AlgoritmoAlocacao {
    private int ultimoIndice = 0;

    @Override
    public void alocar(Processo processo, Memoria memoria) {
        int i = ultimoIndice;
        do {
            if (memoria.verificarEspacoLivre(i, processo.tamanho)) {
                memoria.alocarMemoria(i, processo.tamanho, processo.id);
                ultimoIndice = i + processo.tamanho;
                return;
            }
            i = (i + 1) % memoria.getTamanho();
        } while (i != ultimoIndice);
        System.out.println("Erro: Não foi possível alocar o processo " + processo.id);
    }
}
