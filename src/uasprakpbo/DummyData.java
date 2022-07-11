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
public class DummyData {
    private dataUser userHead;
    
    public dataUser getUserHead(){
        return userHead;
    }
    public void setUserHead(dataUser userHead){
        this.userHead = userHead;
    }
    
    public DummyData(){
        userHead = new dataUser(1, "David Ezer", "david@gmail.com", "david");
        dataUser userBaru1 = new dataUser(2, "David Ezer 2", "david@gmail.com", "david2");
        addLastUser(userBaru1);
    }
    
    public class dataUser{
        int id;
        String nama;
        String email;
        String password;
        
        dataUser next;
        public dataUser(){
            
        }
        public dataUser(int id, String nama, String email, String password){
            this.id = id;
            this.nama = nama;
            this.email = email;
            this.password = password;
            this.next = null;
        }
        
    }
    public void addLastUser(dataUser baru){
        dataUser temp = userHead;
        if(userHead == null){
            userHead = baru;
            return;
        }
        while(temp.next != null)
            temp = temp.next;
        temp.next = baru;
        return;
    }
    public dataUser buatDataUser(){
        dataUser data = new dataUser();
        return data;
    }
}