package model;

public class Filme {


		private int idFilme;
		@SuppressWarnings("unused")
		private String titulo;
		private String descricao;
		private static String genero;
		private static double duracao;

		public Filme() {

		}

		public Filme(String titulo,String descricao,String genero, double duracao,double preco, boolean onLine) {
			this.descricao = descricao;
			this.setGenero(genero);
			this.setDuracao(duracao);
		}

		public Filme(int idFilme,String titulo,String descricao,String genero, double duracao,double preco, boolean onLine)   {
			this.setIdFilme(idFilme);
			this.descricao = descricao;
			this.setGenero(genero);
			this.setDuracao(duracao);
		}

		public int getIdFilme() {
			return idFilme;
		}

		public void setIdFilme(int idFilme) {
			this.idFilme = idFilme;
		}
		
		public static String getTitulo() {
			return getTitulo();
		}

		public void setTitulo(String titulo) {
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public static String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			Filme.genero = genero;
		}
		
		public static double getDuracao() {
			return duracao;
		}

		public void setDuracao(double duracao) {
			Filme.duracao = duracao;
		}

		public static int getdescricao() {
			// TODO Auto-generated method stub
			return 0;
		}

		public void setQuantidade(int int1) {
			// TODO Auto-generated method stub
			
		}

		public int getQuantidade() {
			// TODO Auto-generated method stub
			return 0;
		}

	}
