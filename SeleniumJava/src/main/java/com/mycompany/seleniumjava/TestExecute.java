/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seleniumjava;

/**
 *
 * @author Ginger
 */
public class TestExecute {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.setProperty("webdriver.chrome.driver", "C:/distribs/chromedriver.exe");
        MyFirstTest myFirstTest = new MyFirstTest();
        System.out.println("RunTests");
        myFirstTest.start();
        myFirstTest.Test001();
        myFirstTest.stop();
    }
}
