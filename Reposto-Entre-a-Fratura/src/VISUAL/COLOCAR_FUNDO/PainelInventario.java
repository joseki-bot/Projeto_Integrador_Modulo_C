
package VISUAL.COLOCAR_FUNDO;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import VISUAL.COLOCAR_FUNDO.*;
import BASE.PERSONAGEM.INVENTARIO;
import BASE.PERSONAGEM.Jogador;


public class PainelInventario extends javax.swing.JPanel {
    
    private int slotSelecionado = -1;
    private Image fundo = new ImageIcon(
        getClass().getResource("/IMAGENS/OUTROS/Mochila_2.png")
    ).getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
    }
    private javax.swing.JButton[] slots;
    private INVENTARIO inventario;
    private Jogador jogador;
    
    public PainelInventario(INVENTARIO inventario, Jogador jogador) {
        initComponents();
        this.inventario = inventario;
        this.jogador = jogador;
        
        slots = new javax.swing.JButton[]{
        BT_SLOT_1,
        BT_SLOT_2,
        BT_SLOT_3,
        BT_SLOT_4,
        BT_SLOT_5,
        BT_SLOT_6,
        BT_SLOT_7,
        BT_SLOT_8,
        BT_SLOT_9,
        BT_SLOT_10
    };
    for (JButton slot : slots) {
        slot.setContentAreaFilled(false);
        slot.setBorderPainted(true);
        slot.setFocusPainted(false);
        slot.setOpaque(false);
        
        
    }
        atualizarInventario();
} 
public void atualizarInventario() {
    for (JButton slot : slots) {
        slot.setIcon(null);
    }
    for (int i = 0; i < inventario.getInventario().size(); i++) {
        String item = inventario.getInventario().get(i);
        
        
        switch (item) {
            case "Banana" -> {
                slots[i].setIcon(new ImageIcon(
                    getClass().getResource("/IMAGENS/ITENS/Banana.png")));
                break;
            }
            case "Bala" -> {
                slots[i].setIcon(new ImageIcon(
                    getClass().getResource("/IMAGENS/ITENS/Bala.png")));
                break;
            }
            case "Erva" -> {
                slots[i].setIcon(new ImageIcon(
                    getClass().getResource("/IMAGENS/ITENS/Erva.png")));
                break;
            }
            case "Maçã" -> {
                slots[i].setIcon(new ImageIcon(
                    getClass().getResource("/IMAGENS/ITENS/Maca.png")));
                break;
            }
            case "Poção" -> {
                slots[i].setIcon(new ImageIcon(
                    getClass().getResource("/IMAGENS/ITENS/Pocao.png")));
                break;
            }

            default -> {
                break;
            }
        }
    }
}
public void selecionarSlot(int indice){

    // Remove a borda de todos os botões
    for (JButton slot : slots) {
        slot.setBorder(null);
    }

    // Salva qual slot foi selecionado
    slotSelecionado = indice;

    // Coloca a borda roxa no botão selecionado
    slots[indice].setBorder(
        javax.swing.BorderFactory.createLineBorder(
            java.awt.Color.MAGENTA, 5
        )
    );
}
/* Mostra um menu popup com as opções USAR / DESCARTAR / CANCELAR
quando o jogador clica em um slot que contém item.  */
public void mostrarOpcoesDoItem(int indice) {
    // Só mostra opções se o slot realmente tiver um item
    if (indice < 0 || indice >= inventario.getInventario().size()) {
        selecionarSlot(indice); // só destaca o slot vazio
        return;
    }

    selecionarSlot(indice); // destaca o slot com a borda roxa

    String nomeItem = inventario.getInventario().get(indice);

    // Cria o menu popup
    JPopupMenu menu = new JPopupMenu();

    JMenuItem usar = new JMenuItem("USAR");
    JMenuItem descartar = new JMenuItem("DESCARTAR");
    JMenuItem cancelar = new JMenuItem("CANCELAR");

    // ===== Opção USAR =====
    usar.addActionListener(e -> {
        try {
            // Os métodos do inventário usam índice começando em 1
            inventario.UsarItemMochila(indice + 1, jogador);
            atualizarInventario(); // atualiza os ícones na tela

            // limpa a seleção visual
            for (JButton slot : slots) {
                slot.setBorder(null);
            }
            slotSelecionado = -1;
        } catch (InterruptedException ex) {
            System.err.println("Erro ao usar item: " + ex.getMessage());
        }
    });
// =============================================================================

    // ===== Opção DESCARTAR =====
    descartar.addActionListener(e -> {
        inventario.RemoverItemMochila(indice + 1);
        atualizarInventario();

        for (JButton slot : slots) {
            slot.setBorder(null);
        }
        slotSelecionado = -1;
    });
// =============================================================================

    // ===== Opção CANCELAR =====
    cancelar.addActionListener(e -> {
        // só fecha o menu (não faz nada)
        menu.setVisible(false);
    });

    // Adiciona as opções no menu
    menu.add(usar);
    menu.add(descartar);
    menu.addSeparator(); // linha separadora
    menu.add(cancelar);

    // Mostra o menu perto do botão que foi clicado
    JButton botaoClicado = slots[indice];
    menu.show(botaoClicado, botaoClicado.getWidth() / 2, botaoClicado.getHeight() / 2);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BT_SLOT_1 = new javax.swing.JButton();
        BT_Voltar = new javax.swing.JButton();
        BT_SLOT_3 = new javax.swing.JButton();
        BT_SLOT_5 = new javax.swing.JButton();
        BT_SLOT_2 = new javax.swing.JButton();
        BT_SLOT_6 = new javax.swing.JButton();
        BT_SLOT_4 = new javax.swing.JButton();
        BT_SLOT_8 = new javax.swing.JButton();
        BT_SLOT_7 = new javax.swing.JButton();
        BT_SLOT_9 = new javax.swing.JButton();
        BT_SLOT_10 = new javax.swing.JButton();

        BT_SLOT_1.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_1ActionPerformed(evt);
            }
        });

        BT_Voltar.setText("VOLTAR");
        BT_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_VoltarActionPerformed(evt);
            }
        });

        BT_SLOT_3.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_3ActionPerformed(evt);
            }
        });

        BT_SLOT_5.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_5ActionPerformed(evt);
            }
        });

        BT_SLOT_2.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_2ActionPerformed(evt);
            }
        });

        BT_SLOT_6.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_6ActionPerformed(evt);
            }
        });

        BT_SLOT_4.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_4ActionPerformed(evt);
            }
        });

        BT_SLOT_8.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_8ActionPerformed(evt);
            }
        });

        BT_SLOT_7.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_7ActionPerformed(evt);
            }
        });

        BT_SLOT_9.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_9ActionPerformed(evt);
            }
        });

        BT_SLOT_10.setBackground(new java.awt.Color(85, 86, 86));
        BT_SLOT_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SLOT_10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BT_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 429, Short.MAX_VALUE)
                .addComponent(BT_SLOT_4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BT_SLOT_5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BT_SLOT_6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BT_SLOT_7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(BT_SLOT_8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_SLOT_9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_SLOT_10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(477, 477, 477)
                        .addComponent(BT_SLOT_1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_SLOT_2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BT_SLOT_3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BT_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_SLOT_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_SLOT_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_SLOT_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BT_SLOT_5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BT_SLOT_4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(BT_SLOT_6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BT_SLOT_7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BT_SLOT_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BT_SLOT_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_SLOT_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );

        BT_SLOT_6.getAccessibleContext().setAccessibleDescription("");
        BT_SLOT_7.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void BT_SLOT_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_1ActionPerformed
        mostrarOpcoesDoItem(0);
    }//GEN-LAST:event_BT_SLOT_1ActionPerformed

    private void BT_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_VoltarActionPerformed
        // Fecha apenas a janela da mochila
        java.awt.Window janela = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (janela != null) {
            janela.dispose();
        }
    }//GEN-LAST:event_BT_VoltarActionPerformed

    private void BT_SLOT_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_3ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(2);
    }//GEN-LAST:event_BT_SLOT_3ActionPerformed

    private void BT_SLOT_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_5ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(4);
    }//GEN-LAST:event_BT_SLOT_5ActionPerformed

    private void BT_SLOT_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_2ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(1);
    }//GEN-LAST:event_BT_SLOT_2ActionPerformed

    private void BT_SLOT_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_6ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(5);
    }//GEN-LAST:event_BT_SLOT_6ActionPerformed

    private void BT_SLOT_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_4ActionPerformed
        // TODO add your handling code here:
       mostrarOpcoesDoItem(3);
    }//GEN-LAST:event_BT_SLOT_4ActionPerformed

    private void BT_SLOT_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_8ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(7);
    }//GEN-LAST:event_BT_SLOT_8ActionPerformed

    private void BT_SLOT_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_7ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(6);
    }//GEN-LAST:event_BT_SLOT_7ActionPerformed

    private void BT_SLOT_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_9ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(8);
    }//GEN-LAST:event_BT_SLOT_9ActionPerformed

    private void BT_SLOT_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SLOT_10ActionPerformed
        // TODO add your handling code here:
        mostrarOpcoesDoItem(9);
    }//GEN-LAST:event_BT_SLOT_10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_SLOT_1;
    private javax.swing.JButton BT_SLOT_10;
    private javax.swing.JButton BT_SLOT_2;
    private javax.swing.JButton BT_SLOT_3;
    private javax.swing.JButton BT_SLOT_4;
    private javax.swing.JButton BT_SLOT_5;
    private javax.swing.JButton BT_SLOT_6;
    private javax.swing.JButton BT_SLOT_7;
    private javax.swing.JButton BT_SLOT_8;
    private javax.swing.JButton BT_SLOT_9;
    private javax.swing.JButton BT_Voltar;
    // End of variables declaration//GEN-END:variables
}
