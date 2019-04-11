package br.com.marcosrafaellsousa.dsp20191.aulas1316.ap.entidades;

import java.util.Date;

public class Lotacao {
    private Long id;
    private String dataInicial;
    private String dataFinal;
    private Cargo cargo;
    private Departamento departamento;
    private Funcionario funcionario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "Lotacao{" +
                "id=" + id +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                ", cargo=" + cargo +
                ", departamento=" + departamento +
                ", funcionario=" + funcionario +
                '}';
    }
}
