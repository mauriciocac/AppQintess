package com.mrc.appentrevista.api.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Cliente {
    private String nome;
    private String conta;
    private String saldo;
    private List<Conta> statementList;
    private Throwable error;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public List<Conta> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<Conta> statementList) {
        this.statementList = statementList;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
