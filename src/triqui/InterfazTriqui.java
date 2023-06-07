package triqui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés
 */
public class InterfazTriqui extends javax.swing.JFrame implements ActionListener {

    int tiros_counter = 0; // cuenta los tiros realizados
    JButton[][] matriz_botones = new JButton[3][3];   // se instancia una matriz de 3x3 botones
    boolean esTurnoJugadorX = true; // indica si es el turno del jugador X
    String marcaTirador = "X"; //guarda la marca del tirador {X, O}
    boolean hayGanador = false;

    public InterfazTriqui() {

        initComponents();
        jlJugador2.setVisible(false);

        // se crea un diseno de cuadricula de 3 x 3
        jPanel1.setLayout(new GridLayout(3, 3));

        // se recorre la matriz de botones
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                matriz_botones[x][y] = new JButton();
                jPanel1.add(matriz_botones[x][y]);
                matriz_botones[x][y].addActionListener((ActionListener) this);
            }
        }
    }

    // comprueba el turno del jugador y pone la marca en el boton
    @Override
    public void actionPerformed(ActionEvent e) {

        if (esTurnoJugadorX) {
            marcaTirador = "X";
            esTurnoJugadorX = false;
            jlJugador2.setVisible(true);
            jlJugador1.setVisible(false);
        } else {
            jlJugador2.setVisible(false);
            jlJugador1.setVisible(true);
            marcaTirador = "O";
            esTurnoJugadorX = true;
        }
        JButton botonPress = (JButton) e.getSource();
        botonPress.setText(marcaTirador);
        botonPress.setEnabled(false);
        comprobarTiro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlJugador1 = new javax.swing.JLabel();
        jlJugador2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        jlJugador1.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jlJugador1.setForeground(new java.awt.Color(102, 102, 102));
        jlJugador1.setText("jugador X");

        jlJugador2.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jlJugador2.setForeground(new java.awt.Color(102, 102, 102));
        jlJugador2.setText("jugador O");

        jMenu1.setText("Archivo");
        jMenu1.setToolTipText("");

        jMenuItem1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jMenuItem1.setText("Juego Nuevo");
        jMenuItem1.setAlignmentX(0.0F);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlJugador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jlJugador2)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlJugador1)
                    .addComponent(jlJugador2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JDialog.setDefaultLookAndFeelDecorated(true);
        if (hayGanador || tiros_counter > 8) {
            reiniciar();
            return;
        }
        byte respuesta = (byte) JOptionPane.showConfirmDialog(this, "Quieres abandonar la partida actual?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == 0) {
            reiniciar();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazTriqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazTriqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazTriqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazTriqui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazTriqui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlJugador1;
    private javax.swing.JLabel jlJugador2;
    // End of variables declaration//GEN-END:variables

    public void ganador() {
        JOptionPane.showMessageDialog(this, "Triqi ha Ganado el jugador " + marcaTirador + "\n Felicitaciones!!!");
        hayGanador = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz_botones[i][j].setEnabled(false);
            }
        }
    }

    public boolean verificaMarca(int x, int y, String marca) {
        return matriz_botones[x][y].getText().equals(marca);
    }

    private void comprobarTiro() {
        // hace comprobacion despues de 5 tiros antes es imposible ganar
        if (tiros_counter > 9) {
            return;
        }

        tiros_counter++;
        if (tiros_counter >= 5) {

            // comprueba las columnas
            for (int y = 0; y < 3; y++) {
                if (verificaMarca(0, y, marcaTirador)
                        && verificaMarca(1, y, marcaTirador)
                        && verificaMarca(2, y, marcaTirador)) {
                    ganador();
                }
            }
            // comprueba las filas
            for (int x = 0; x < 3; x++) {
                if (verificaMarca(x, 0, marcaTirador)
                        && verificaMarca(x, 1, marcaTirador)
                        && verificaMarca(x, 2, marcaTirador)) {
                    ganador();
                }
            }
            // comprueba la recta de 135 gados
            if ((verificaMarca(0, 0, marcaTirador)) && (verificaMarca(1, 1, marcaTirador))
                    && (verificaMarca(2, 2, marcaTirador))) {
                ganador();
            }

            // comprueba la recta de 45 grados
            if ((verificaMarca(0, 2, marcaTirador)) && (verificaMarca(1, 1, marcaTirador))
                    && (verificaMarca(2, 0, marcaTirador))) {
                ganador();
            }
        }
    }

    private void reiniciar() {
        tiros_counter = 0;
        hayGanador = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz_botones[i][j].setText("");
                matriz_botones[i][j].setEnabled(true);
            }
        }
    }

}
