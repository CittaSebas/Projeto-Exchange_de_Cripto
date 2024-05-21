/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author citta
 */
public class Cotacao {
    int id;
    float cotxrp, cotbtc, cot, eth;

    public Cotacao(float cotxrp, float cotbtc, float cot, float eth, int id) {
        this.cotxrp = cotxrp;
        this.cotbtc = cotbtc;
        this.cot = cot;
        this.eth = eth;
        this.id = id;
    }

    public Cotacao(int id) {
        this.id = id;
    }
    

    public float getCotxrp() {
        return cotxrp;
    }

    public void setCotxrp(float cotxrp) {
        this.cotxrp = cotxrp;
    }

    public float getCotbtc() {
        return cotbtc;
    }

    public void setCotbtc(float cotbtc) {
        this.cotbtc = cotbtc;
    }

    public float getCot() {
        return cot;
    }

    public void setCot(float cot) {
        this.cot = cot;
    }

    public float getEth() {
        return eth;
    }

    public void setEth(float eth) {
        this.eth = eth;
    }

    public int getId() {
        return id;
    }
    
    
    
}
