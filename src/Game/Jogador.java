package Game;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Jogador {

    private int vidaMaxima = 25;
    private double vida = 25;
    private int forca = 1;
    private int resistencia = 1;
    private int nivel = 1;
    private double xp = 0.0;
    private double xpParaUpar = 10.0;
    private String nome = "";
    private String profissao = "";
    private String arma = "Mãos";
    private String armadura = "";

    public Jogador(String nome, String profissao) {

        this.nome = nome;

        switch (profissao) {
            case "MÉDICO":
                this.profissao = "Médico";
                //atribuindoValoresBaseadoNaProfissao(this.profissao);
                setVidaMaxima(5);
                setResistencia(5);
                setVida(vidaMaxima);
                break;

            case "SOLDADO":
                this.profissao = "Soldado";
                //atribuindoValoresBaseadoNaProfissao(this.profissao);
                setVidaMaxima(5);
                setVida(vidaMaxima);
                setForca(5);
                break;

            case "PROFESSOR":
                this.profissao = "Professor";
                //atribuindoValoresBaseadoNaProfissao(this.profissao);
                setVidaMaxima(2.5);
                setVida(vidaMaxima);
                setForca(3);
                setResistencia(3);
                break;
        }
    }

    /*
	private void atribuindoValoresBaseadoNaProfissao(String profissao) {
		
		switch (profissao) {
			case "Médico":  		
				setVidaMaxima(15);
				setResistencia(5);
				setVida(vidaMaxima);
				//getStatus();
				break;
				
			case "Soldado":
				setVidaMaxima(15);
				setVida(vidaMaxima);
				setForca(5);
				//getStatus();
				break;
				
			case "Professor":
				setVidaMaxima(10);
				setVida(vidaMaxima);
				setForca(3);
				setResistencia(3);
				//getStatus();
				break;	
				
			default: System.out.println("Comando Inválido!");
			atribuindoValoresBaseadoNaProfissao("Professor");
		}		
	}
     */
    public String getStatus() {

        String txt = "NOME: " + nome + ""
                + " | PROFISSÃO: " + profissao + "\n"
                //+	"Vida Máxima: " 	+ vidaMaxima					+ "\n"
                + "VIDA: " +  Game.dc.format(vida) + "\n"
                + "FORÇA: " + forca + "\n"
                + "RESISTÊNCIA: " + resistencia + "\n"
                + "NÍVEL: " + nivel + "\n"
                + "XP: " + Game.dc.format(xp) + "\n"
                + "ARMA: " + arma + "\n"
                + "ARMADURA: " + armadura + "\n";
        //+ 	"XP p/ Upar: "  	+ Game.dc.format(xpParaUpar)    + "\n";

        return txt;
    }

    public void passaDeNivel(double experiencia) {

        if (getXp() + experiencia >= getXpParaUpar()) {
            setXp(getXp() + experiencia - getXpParaUpar());
            setXpParaUpar(1.25f);
            setNivel(1);
            melhoraStatus();
        } else {
            setXp(experiencia);
        }
    }

    public void melhoraStatus() {
        
        setVidaMaxima(2.5);
        setForca(3);
        setResistencia(3);
        setVida(vidaMaxima);
        getStatus();

        System.out.println(
                  "||********** SUBIU DE NÍVEL ***********||\n"
                + "|| Suas estatísticas subiram de nível! ||\n"
                + "|| VIDA MÁXIMA:  + 2,5                 ||\n"
                + "|| FORÇA:        + 3                   ||\n"
                + "|| RESISTÊNCIA:  + 3                   ||\n"
                + "||*************************************||\n");
//
//        Scanner scan = new Scanner(System.in);
//        int escolha = scan.nextInt();
//
//        switch (escolha) {
//            case 1:
//                setVidaMaxima(10);
//                setVida(vidaMaxima);
//                getStatus();
//                break;
//            case 2:
//                setForca(1);
//                setVida(vidaMaxima);
//                getStatus();
//                break;
//            case 3:
//                setResistencia(1);
//                setVida(vidaMaxima);
//                getStatus();
//                break;
//
//            default:
//                System.out.println("Comando inválido!");
//                melhoraStatus();
//        }
    }

    public int getDanoArma(String arma) {

        switch (arma) {
            case "Mãos":
                return 5;

            case "Braço do Assento":
                return 10;

            case "Pedaço de Madeira":
                return 10;

            case "Osso Humano", "Faca":
                return 15;

            case "Pinças de Formiga Gigante":
                return 30;

            default:
                System.out.println("Esta arma é inválida!");
                return 0;
        }
    }

    public double getDanoJogador(double defesaInimigo) {
        double danoJogador = (getForca() + getDanoArma(arma)) / defesaInimigo;
        return danoJogador;
    }

    public int getDefesaArmadura(String armadura) {

        switch (armadura) {
            case "":
                return 0;

            case "Boné":
                return 5;

            case "Capacete de Coco", "Capacete de Ossos":
                return 10;

            case "Capacete de Ferro":
                return 15;

            case "Carapaça de Cupim":
                return 30;

            default:
                System.out.println("Esta armadura é inválida!");
                return 0;
        }
    }

    public int getDefesaJogador() {
        return getResistencia() + getDefesaArmadura(armadura);
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(double vidaMaxima) {
        this.vidaMaxima += vidaMaxima;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public void setVidaDano(double dano) {
        this.vida -= dano;
    }

    public void setVidaCura(double vida) {
        this.vida += vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca += forca;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia += resistencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel += nivel;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp += xp;
    }

    public double getXpParaUpar() {
        return xpParaUpar;
    }

    public void setXpParaUpar(double xpParaUpar) {
        this.xpParaUpar *= xpParaUpar;
    }

    public String getNome() {
        return nome;
    }

    /*
	public void setNome(String nome) {
		this.nome = nome;
	}
     */
    public String getProfissao() {
        return profissao;
    }

    /*
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
     */
    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public String getArmadura() {
        return armadura;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

}