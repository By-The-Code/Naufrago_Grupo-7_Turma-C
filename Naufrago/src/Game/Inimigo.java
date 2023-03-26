package Game;

public class Inimigo {

	private String nomeInimigo;
	private int vidaInicialInimigo;
	private int vidaInimigo;
	private int forcaInimigo;
	private int resistenciaInimigo;
	private int nivelInimigo;
	
	public String getStatusInimigo() {
		String txt = 			"Nome Inimigo: " 		+ getNomeInimigo() 		  + "\n"
							+ 	"Vida Inimigo: " 		+ getVidaInimigo() 		  + "\n"
							+ 	"Força Inimigo: " 		+ getForcaInimigo()		  + "\n"
							+ 	"Resistência Inimigo: " + getResistenciaInimigo() + "\n"
							+ 	"Nível Inimigo: " 		+ getNivelInimigo() 	  + "\n";
		
		return txt;
	}
	
	public float danoInimigo(int resistJogador) {
		float danoInimigo = (getForcaInimigo() * getNivelInimigo()) / resistJogador;
		return danoInimigo;
	}
	
	public float defesaInimigo() {
		float defesaInimigo = getResistenciaInimigo() * getNivelInimigo();
		return defesaInimigo;
	}
	
	public Inimigo (String nome, int vida, int forca, int resistencia, int nivel) {
		this.nomeInimigo = nome;
		this.vidaInimigo = vida;
		this.forcaInimigo = forca;
		this.vidaInicialInimigo = this.vidaInimigo;
		this.resistenciaInimigo = resistencia;
		this.nivelInimigo = nivel;
		
		if (this.nivelInimigo <= 0) this.nivelInimigo = 1;
	}
	
	public Inimigo () {}

	/*
	private Inimigo(String nomeInimigo, int vidaInimigo, int forcaInimigo, int resistenciaInimigo, int nivelInimigo) {
		super();
		this.nomeInimigo = nomeInimigo;
		this.vidaInimigo = vidaInimigo;
		this.forcaInimigo = forcaInimigo;
		this.resistenciaInimigo = resistenciaInimigo;
		this.nivelInimigo = nivelInimigo;
	}
	*/

	public String getNomeInimigo() {
		return nomeInimigo;
	}

	private void setNomeInimigo(String nomeInimigo) {
		this.nomeInimigo = nomeInimigo;
	}
	
	public int getVidaInicialInimigo() {
		return  vidaInicialInimigo;
	}

	public int getVidaInimigo() {
		return vidaInimigo;
	}

	public void setVidaInimigo(float danoLevado) {
		this.vidaInimigo -= danoLevado;
	}

	private int getForcaInimigo() {
		return forcaInimigo;
	}

	private void setForcaInimigo(int forcaInimigo) {
		this.forcaInimigo = forcaInimigo;
	}

	public int getResistenciaInimigo() {
		return resistenciaInimigo;
	}

	private void setResistenciaInimigo(int resistenciaInimigo) {
		this.resistenciaInimigo = resistenciaInimigo;
	}

	public int getNivelInimigo() {
		return nivelInimigo;
	}

	private void setNivelInimigo(int nivelInimigo) {
		this.nivelInimigo = nivelInimigo;
	}

}
