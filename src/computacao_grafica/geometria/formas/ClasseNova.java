package computacao_grafica.geometria.formas;

public class ClasseNova {
    /**
     * Indica a situa��o do Projeto
     * @author gabriel.pinheiro
     */
    public enum Situacao {
        CRIADO("Criado"), INICIADO("Iniciado"), CONCLUIDO("Conclu�do"), CANCELADO("Cancelado");

        private String descricao;

        private Situacao(final String descricao) {
            this.setDescricao(descricao);
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(final String descricao) {
            this.descricao = descricao;
        }

    }
    
    public static void main(String[] args) {
    	String teste = "Conclu�do";
    	Object value;
    	value = Enum.valueOf((Class<? extends Enum>)Situacao.class, teste);
    	System.out.println(value);
    }
    
}
