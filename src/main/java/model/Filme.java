package model;

public class Filme {


		private int idFilme;
		@SuppressWarnings("unused")
		private String titulo;
		private String descricao;
		private String genero;
		private double duracao;
		private double preco;
		private boolean onLine;

		public Filme() {

		}

		public Filme(String titulo,String descricao,String genero, double duracao,double preco, boolean onLine) {
			this.descricao = descricao;
			this.setGenero(genero);
			this.setDuracao(duracao);
			this.preco = preco;
			this.onLine = onLine;
		}

		public Filme(int idFilme,String titulo,String descricao,String genero, double duracao,double preco, boolean onLine)   {
			this.setIdFilme(idFilme);
			this.descricao = descricao;
			this.setGenero(genero);
			this.setDuracao(duracao);
			this.preco = preco;
			this.onLine = onLine;
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

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		public double getDuracao() {
			return duracao;
		}

		public void setDuracao(double duracao) {
			this.duracao = duracao;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public boolean isOnLine() {
			return onLine;
		}

		public void setOnLine(boolean onLine) {
			this.onLine = onLine;
		}

		public static int getdescricao() {
			// TODO Auto-generated method stub
			return 0;
		}

	}
