class FirstFit implements AlgoritmoAlocacao {
    @Override
    public void alocar(Processo processo, Memoria memoria) {
        for (int i = 0; i <= memoria.getTamanho() - processo.tamanho; i++) {
            if (memoria.verificarEspacoLivre(i, processo.tamanho)) {
                memoria.alocarMemoria(i, processo.tamanho, processo.id);
                return;
            }
        }
        System.out.println("Erro: Não foi possível alocar o processo " + processo.id);
    }
}
