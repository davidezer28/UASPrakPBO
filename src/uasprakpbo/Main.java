/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uasprakpbo;

/**
 *
 * @author davidezer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DummyData data = new DummyData();
        DummyDataManager.getInstance().setDummyData(data);
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
    }
    
}
