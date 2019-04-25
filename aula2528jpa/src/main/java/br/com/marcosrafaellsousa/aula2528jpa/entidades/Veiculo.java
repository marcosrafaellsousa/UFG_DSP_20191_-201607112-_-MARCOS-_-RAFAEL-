package br.com.marcosrafaellsousa.aula2528jpa.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="VEICULO")
public class Veiculo implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Integer potenciaMotor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public String toString() {
        return String.format("Veiculo: " +id + "%n" +
                "Marca: " + marca + "%n" +
                "Modelo: " + modelo + "%n" +
                "AnoFabricacao: " + anoFabricacao + "%n" +
                "AnoModelo: " + anoModelo + "%n" +
                "PotenciaMotor:" + potenciaMotor + "%n");
    }
}
