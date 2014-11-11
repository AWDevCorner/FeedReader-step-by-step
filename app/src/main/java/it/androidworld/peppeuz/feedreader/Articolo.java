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
    private String immagine;

    public boolean isLetto() {
        return letto;
    }

    public void setLetto(boolean letto) {
        this.letto = letto;
    }

    private boolean letto;

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

    @Override
    public String toString() {
        return "Articolo{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", link='" + link + '\'' +
                ", dataPubblicazione=" + dataPubblicazione +
                ", intro='" + intro + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", immagine='" + immagine + '\'' +
                '}';
    }

    public void setDataPubblicazione(Date dataPubblicazione) {
        this.dataPubblicazione = dataPubblicazione;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getImmagine() {

        return immagine;
    }

    public Articolo(String titolo, String autore, String link, Date dataPubblicazione, String intro, String contenuto, String immagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.link = link;
        this.dataPubblicazione = dataPubblicazione;
        this.intro = intro;
        this.contenuto = contenuto;
        this.immagine = immagine;
        this.letto = false;
    }

    public Articolo (){};

    public void setIntro(String intro) {
        this.intro = intro;

    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
