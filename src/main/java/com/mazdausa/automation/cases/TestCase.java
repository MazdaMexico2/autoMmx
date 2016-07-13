package com.mazdausa.automation.cases;

/**
 * Created by gabriela.rojas on 6/29/16.
 */
abstract public class TestCase {

    public abstract void prepare();

    public abstract boolean test();

    public String output(){
       return "";
    }

    public void flush(){

    }

}
