/*  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author mauro
 */
public class pedido {

    private int id;
    private String nome;
    private String processador;
    private String placavideo;
    private String placamae;
    private String ram;
    private String cooler;
    private String hd;
    private String ssd;
    private String gabinete;
    private String estado;

    public pedido() {

    }

    public pedido(int id, String nome, String processador, String placavideo, String placamae, String ram, String cooler, String hd, String ssd, String gabinete, String estado) {
        this.id = id;
        this.nome = nome;
        this.processador = processador;
        this.placavideo = placavideo;
        this.placamae = placamae;
        this.ram = ram;
        this.cooler = cooler;
        this.hd = hd;
        this.ssd = ssd;
        this.gabinete = gabinete;
        this.estado = estado;
    }

    public pedido(String nome, String processador, String placavideo, String placamae, String ram, String cooler, String hd, String ssd, String gabinete, String estado) {
        this.nome = nome;
        this.processador = processador;
        this.placavideo = placavideo;
        this.placamae = placamae;
        this.ram = ram;
        this.cooler = cooler;
        this.hd = hd;
        this.ssd = ssd;
        this.gabinete = gabinete;
        this.estado = estado;
    }

    public pedido(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getPlacavideo() {
        return placavideo;
    }

    public void setPlacavideo(String placavideo) {
        this.placavideo = placavideo;
    }

    public String getPlacamae() {
        return placamae;
    }

    public void setPlacamae(String placamae) {
        this.placamae = placamae;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
