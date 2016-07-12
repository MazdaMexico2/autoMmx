package com.mazdausa.automation.panels;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
abstract public class Panel {

    public abstract void prepare();

    public String output(){
        return "";
    }

    public void flush(){

    }
}
