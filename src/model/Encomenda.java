
package model;
import java.security.SecureRandom;
import java.util.Date;


public class Encomenda {
    private int id;
    private String origem, destino, posicao, status, chave, motorista;
    private Date dataPostagem,dataEntrega;

    public int getId() {
        return id;
    }
    
    public static String geradorChave() {
        String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int TAMANHO_CHAVE = 6;
        SecureRandom random = new SecureRandom();
        StringBuilder chave = new StringBuilder(TAMANHO_CHAVE);

        for (int i = 0; i < TAMANHO_CHAVE; i++) {
            int indice = random.nextInt(CARACTERES.length());
            char caractere = CARACTERES.charAt(indice);
            chave.append(caractere);
        }
        return chave.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }
    
    
}
