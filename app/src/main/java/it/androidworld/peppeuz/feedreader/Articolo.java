package it.androidworld.peppeuz.feedreader;

import java.util.Date;

/**
 * Created by peppeuz on 12/08/14.
 */
public class Articolo {
    private String titolo;
    private String autore;
    private String link;
    private Date dataPubblicazione;
    private String intro;
    private String contenuto;

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getLink() {
        return link;
    }

    public Date getDataPubblicazione() {
        return dataPubblicazione;
    }

    public String getIntro() {
        return intro;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
