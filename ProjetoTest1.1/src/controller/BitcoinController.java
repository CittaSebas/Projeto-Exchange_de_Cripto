/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.FrameBitcoin;
/**
 *
 * @author citta
 */
public class BitcoinController {
    
   private FrameBitcoin view;
    private String cpflogado, txt;
    float valorcompra;
    
    public BitcoinController(FrameBitcoin view, String cpflogado) {
        this.view = view;
        this.cpflogado = cpflogado;
    }
    
     
}
