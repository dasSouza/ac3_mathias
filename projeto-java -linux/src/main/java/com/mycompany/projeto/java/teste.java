package com.mycompany.projeto.java;

//package br.com.banctec.tela.login;
//
///**
// *
// * @author mathias.de.carvalho
// */
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.JOptionPane;
//
//public class teste extends TelaLogin {
//
////start of main method
//    public static void main(String[] args) {
//        //checking for support
//        if (!SystemTray.isSupported()) {
//            System.out.println("sistema não suportado !!!!!!");
//            return;
//        }
//        //get the systemTray of the system
//        SystemTray systemTray = SystemTray.getSystemTray();
//
//        //get default toolkit
//        //Toolkit toolkit = Toolkit.getDefaultToolkit();
//        //get image 
//        //Toolkit.getDefaultToolkit().getImage("src/resources/busylogo.jpg");
//        Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\mathias.de.carvalho\\Desktop\\Git\\KeepCode-Grupo-08\\Tela-Login-Swing\\tela-login\\src\\main\\resoures\\images\\logo.png");
//
//        //popupmenu
//        PopupMenu trayPopupMenu = new PopupMenu();
//
//        //1t menuitem for popupmenu
//        MenuItem action = new MenuItem("Abrir tela");
//        action.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "teste de click");
//            }
//        });
//        trayPopupMenu.add(action);
//
//        //2nd menuitem of popupmenu
//        MenuItem close = new MenuItem("fechar");
//        close.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//        
//        trayPopupMenu.add(close);
//
//        //setting tray icon
//        TrayIcon trayIcon = new TrayIcon(image, "SystemTray Demo", trayPopupMenu);
//        //adjust to default size as per system recommendation 
//        trayIcon.setImageAutoSize(true);
//
//        try {
//            systemTray.add(trayIcon);
//        } catch (AWTException awtException) {
//            awtException.printStackTrace();
//        }
//        System.out.println("end of main");
//
//    }//end of main
//
//}//end of class
