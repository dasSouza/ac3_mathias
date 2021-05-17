//package br.com.banctec.tela.login;
//
//import java.awt.AWTException;
//import java.awt.Image;
//import java.awt.SystemTray;
//import java.awt.TrayIcon;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import javax.swing.ImageIcon;
//
///**
// *
// * @author mathias.de.carvalho
// */
//
//public class Janela extends JFrame{
//     /**
//     * Construtor da classe.
//     * @param nome
//     */
//    
//   
// 
//    public Janela(String nome) {
//        super(nome);
//    }
//
//    private Object getClass() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//    
//    public static void main(String[] args) {
//        // Instancia nova janela
//        final Janela main = new Janela("Janela de Testes");
// 
//        // Instancia um novo SystemTray
//        SystemTray tray = SystemTray.getSystemTray();
// 
//        /**
//         *  Pega uma imagem para definir como ícone.
//         *
//         *  main.getClass().getClassLoader().getResource("icone.jpg")
//         *  pega a imagem do pacote onde a Classe se encontra.
//         *  Será bem útil na hora de exportar a aplicação.
//         */
//        
//        Image imageIcon = new ImageIcon((main.getClass()
//                .getClassLoader()
//                .getResource("icone.jpg")))
//                .getImage();
//        
//        // Instancia e Define o icone do TrayIcon
//        TrayIcon trayIcon = new TrayIcon(imageIcon);
// 
//        // Define o auto-ajuste da imagem
//        trayIcon.setImageAutoSize(true);
// 
//        /**
//         * Instancia um mouse listener para ser usado no TrayIcon
//         */
//        MouseListener mlOpcoes = new MouseListener(){
//            
//            public void mouseClicked(MouseEvent e) {}
//            
//            public void mousePressed(MouseEvent e) {}
//            
//            public void mouseReleased(MouseEvent e) {
//                /**
//                 *  Se o mouse for clicado com a roda do mouse ou com
//                 *  o botão direito fechará a aplicação.
//                 */
//                if(e.getButton() == 2 || e.getButton() == 3){
//                    System.exit(0);
//                }
//            }
//            
//            public void mouseEntered(MouseEvent e) {}
//            
//            public void mouseExited(MouseEvent e) {}
//        };
//        // adiciona o mouseListener no TrayIcon
//        trayIcon.addMouseListener(mlOpcoes);
// 
//        try {
//            // Adiciona o Ícone no SystemTray
//            tray.add(trayIcon);
//        } catch (AWTException e) {}
//    }
//
//    
//}
