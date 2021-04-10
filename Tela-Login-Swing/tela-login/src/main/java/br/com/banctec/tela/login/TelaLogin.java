package br.com.banctec.tela.login;

import java.awt.Toolkit;
import java.awt.Desktop;
import java.net.URI;
import org.springframework.jdbc.core.JdbcTemplate;
import tabelas.TbUsDados;
import jdbc.Conexao;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author Pinheiro
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        background = new javax.swing.JPanel();
        cardLogin = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        lblValida = new javax.swing.JLabel();
        btnLogo = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        lblTitleLogin = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 102));
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/Pinheiro/Desktop/logo-login.png")
        );

        background.setBackground(new java.awt.Color(206, 228, 217));

        cardLogin.setBackground(new java.awt.Color(110, 150, 146));
        cardLogin.setForeground(new java.awt.Color(255, 102, 102));

        txtEmail.setBackground(new java.awt.Color(237, 230, 221));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(81, 78, 77));
        txtEmail.setText("Informe seu e-mail aqui");
        txtEmail.setToolTipText("EMAIL");
        txtEmail.setCaretPosition(19);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblValida.setBackground(new java.awt.Color(255, 51, 51));
        lblValida.setForeground(new java.awt.Color(255, 102, 102));

        btnLogo.setContentAreaFilled(false);
        btnLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoActionPerformed(evt);
            }
        });

        txtSenha.setBackground(new java.awt.Color(237, 230, 221));
        txtSenha.setForeground(new java.awt.Color(81, 78, 77));
        txtSenha.setText("Senha123");
        txtSenha.setToolTipText("SENHA");
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(136, 169, 167));
        btnEntrar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setBorderPainted(false);
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblTitleLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitleLogin.setForeground(new java.awt.Color(81, 78, 77));
        lblTitleLogin.setText("FAZER LOGIN");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(81, 78, 77));
        lblEmail.setText("E-mail");

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(81, 78, 77));
        lblSenha.setText("Senha");

        javax.swing.GroupLayout cardLoginLayout = new javax.swing.GroupLayout(cardLogin);
        cardLogin.setLayout(cardLoginLayout);
        cardLoginLayout.setHorizontalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogo)
                .addGap(248, 248, 248))
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSenha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lblTitleLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValida, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardLoginLayout.setVerticalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(btnLogo)
                .addGap(7, 7, 7)
                .addComponent(lblTitleLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValida, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txtEmail.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(background, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

//BOTÃO LOGO
    private void btnLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoActionPerformed
        // TODO add your handling code here:
        String[] args;
        try {
            URI link = new URI("https://www.youtube.com/watch?v=UKp2CrfmVfw");
            Desktop.getDesktop().browse(link);
        } catch (Exception erro) {
            System.out.println(erro);
        }
    }//GEN-LAST:event_btnLogoActionPerformed

//    PLACEHOLDER CAMPO EMAIL
    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if (txtEmail.getText().equals("Informe seu e-mail aqui")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("Informe seu e-mail aqui");
        }
    }//GEN-LAST:event_txtEmailFocusLost

//  PLACEHOLDER CAMPO SENHA    
    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        // TODO add your handling code here:
        if (txtSenha.getText().equals("Senha123")) {
            txtSenha.setText("");
        }
    }//GEN-LAST:event_txtSenhaFocusGained

    private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusLost
        // TODO add your handling code here:
        if (txtSenha.getText().equals("")) {
            txtSenha.setText("Senha123");
        }
    }//GEN-LAST:event_txtSenhaFocusLost

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        Conexao con = new Conexao();
        TbUsDados teste = new TbUsDados();

        JdbcTemplate template = new JdbcTemplate(con.getBanco());

        List<TbUsDados> pegandoUser = template.query("SELECT us_login, us_senha FROM tb_us_dados WHERE us_login = ? AND us_senha = ?",
                new BeanPropertyRowMapper<>(TbUsDados.class), txtEmail.getText(), txtSenha.getText());

        System.out.println(pegandoUser);

        String pegandoEmail = txtEmail.getText();
        String pegandoSenha = txtSenha.getText();

        if (pegandoUser.size() > 1) {

            for (TbUsDados tbUsDados : pegandoUser) {
                if (tbUsDados.getUs_login().equals(pegandoEmail) && tbUsDados.getUs_senha().equals(pegandoSenha)) {
                    lblValida.setText("Correto");
                }
            }
        } else {
            lblValida.setText("Email ou senha incorretos");
        }
        txtEmail.setText("");
        txtSenha.setText("");
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnLogo;
    private javax.swing.JPanel cardLogin;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTitleLogin;
    private javax.swing.JLabel lblValida;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables

}
