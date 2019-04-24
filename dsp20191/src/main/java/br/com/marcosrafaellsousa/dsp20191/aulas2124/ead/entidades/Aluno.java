package br.com.marcosrafaellsousa.dsp20191.aulas2124.ead.entidades;

import java.io.Serializable;

public class Aluno implements Serializable {
    //Nome, matricula, disciplina, frequencia, nota1 e nota2
    private String nome;
    private String matricula;
    private String disciplina;
    private double frequenciaPercentual;
    private double nota1;
    private double nota2;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getFrequencia() {
        return frequenciaPercentual;
    }

    public void setFrequencia(double frequencia) {
        this.frequenciaPercentual = frequencia;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public String avaliar () {
        if (frequenciaPercentual >= 75.0 && (nota1 + nota2 / 2) >= 6.0) {
                return "APROVADO";
        } else return "REPROVADO";
    }

    @Override
    public String toString() {
        return String.format("Aluno: " + nome + "%n" +
                "matricula: " + matricula + "%n" +
                "disciplina: '" + disciplina + "%n" +
                "frequenciaPercentual: " + frequenciaPercentual + "%n" +
                "nota1: " + nota1 + "%n" +
                "nota2: " + nota2 + "%n");
    }
}