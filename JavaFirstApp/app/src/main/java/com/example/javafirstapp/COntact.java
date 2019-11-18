package com.example.javafirstapp;

public class COntact {
   private String nom,prenom;
   private String num_tel;

    public COntact(String nom, String prenom, String num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return "COntact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", num_tel='" + num_tel + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }
}
