package VISUAL.TESTE_DE_IMAGENS;

import BASE.COMBATE.DanoArmas;
import BASE.COMBATE.EscolhaArma;
import BASE.HOTEL.Quarto;
import BASE.ITEM.DefinindoItem;
import BASE.ITEM.EfeitoItem;
import BASE.PERSONAGEM.INVENTARIO;
import BASE.PERSONAGEM.Jogador;
import VISUAL.COLOCAR_FUNDO.JanelaInventario;
import VISUAL.COMBATE.Combate_Corredor;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TelaQuarto extends javax.swing.JFrame {

    private INVENTARIO I;
    private Jogador jogador;
    private DefinindoItem sorteador = new DefinindoItem(null);
    private DanoArmas danoArmas;
    private EscolhaArma escolhaArma;

    private boolean olhouCama = false;
    private boolean olhouCriado = false;
    private boolean olhouGuarda = false;
    private boolean olhouQuadro = false;

    // "quarto" | "porta" | "corredor"
    private String telaAtual = "quarto";

    public TelaQuarto(INVENTARIO I, Jogador jogador,
                  DanoArmas danoArmas, EscolhaArma escolhaArma) {
        
        this.I = I;
        this.jogador = jogador;
        this.danoArmas = danoArmas;
        this.escolhaArma = escolhaArma;
        initComponents();

        lblImagem.setIcon(new ImageIcon(
            getClass().getResource("/IMAGENS/COMODOS/QUART_2.png")
        ));
        telaAtual = "quarto";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        BT_VOLTAR = new javax.swing.JButton();
        Abrir_Inventario = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENS/COMODOS/QUART_2.png"))); // NOI18N
        lblImagem.setText("jLabel2");
        lblImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagemMouseClicked(evt);
            }
        });

        BT_VOLTAR.setText("VOLTAR");
        BT_VOLTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_VOLTARActionPerformed(evt);
            }
        });

        Abrir_Inventario.setText("INVENTARIO");
        Abrir_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_InventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 1319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Abrir_Inventario))
                    .addComponent(BT_VOLTAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BT_VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(Abrir_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_VOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_VOLTARActionPerformed
        // Sempre volta para o quarto principal
        lblImagem.setIcon(new ImageIcon(
            getClass().getResource("/IMAGENS/COMODOS/QUART_2.png")
        ));
        telaAtual = "quarto";
    }//GEN-LAST:event_BT_VOLTARActionPerformed

    private void lblImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagemMouseClicked
        int x = evt.getX();
        int y = evt.getY();

        // Descomente para medir hitbox:
        // System.out.println("X = " + x + "  Y = " + y + "  tela=" + telaAtual);

        if (telaAtual.equals("porta")) {
            // Hitbox da porta
            if (x >= 535 && x <= 785 && y >= 96 && y <= 503) {
                String[] opcoes = {"Sim", "Não"};
                int opcao = JOptionPane.showOptionDialog(
                    this,
                    "Abrir a porta e sair do quarto?",
                    "Porta",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
                );

                if (opcao == 0) { // Sim → corredor
                    telaAtual = "corredor";
                    JOptionPane.showMessageDialog(this, "Você abre a porta e entra no corredor...");
                    
                    Combate_Corredor combate = new Combate_Corredor(jogador, I, danoArmas, escolhaArma);
                    combate.setVisible(true);
                    this.dispose();
                } 
                else {
                    // Não → volta ao quarto
                    lblImagem.setIcon(new ImageIcon(
                        getClass().getResource("/IMAGENS/COMODOS/QUART_2.png")
                    ));
                    telaAtual = "quarto";
                }
            }
            return; // na porta não processa móveis
        }

        // ========== TELA DO CORREDOR ==========
        if (telaAtual.equals("corredor")) {
            // Por enquanto só VOLTAR funciona; depois você coloca hitboxes do corredor
            return;
        }

        // ========== TELA DO QUARTO ==========
        if (x >= 30 && x <= 314 && y >= 449 && y <= 714) {
            // Cama
            lblImagem.setIcon(new ImageIcon(getClass().getResource("/IMAGENS/CAMA.png")));
            investigarMovel("cama");

        } else if (x >= 320 && x <= 460 && y >= 400 && y <= 556) {
            // Criado-mudo
            lblImagem.setIcon(new ImageIcon(getClass().getResource("/IMAGENS/CRIADO_MUDO.png")));
            investigarMovel("criado");

        } else if (x >= 219 && x <= 377 && y >= 220 && y <= 318) {
            // Quadro
            lblImagem.setIcon(new ImageIcon(getClass().getResource("/IMAGENS/QUADRO.png")));
            investigarMovel("quadro");

        } else if (x >= 1010 && x <= 1213 && y >= 234 && y <= 555) {
            // Guarda-roupa
            lblImagem.setIcon(new ImageIcon(getClass().getResource("/IMAGENS/GUARDA_ROUPA.png")));
            investigarMovel("guarda");

        } else if (x >= 655 && x <= 745 && y >= 600 && y <= 725) {
            // Seta → imagem de frente para a porta
            lblImagem.setIcon(new ImageIcon(
                getClass().getResource("/IMAGENS/COMODOS/QUARTO_PORTA.png")
            ));
            telaAtual = "porta";
        }
    }//GEN-LAST:event_lblImagemMouseClicked

    private void Abrir_InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_InventarioActionPerformed
        JanelaInventario janela = new JanelaInventario(I, jogador);
        janela.setVisible(true);
    }//GEN-LAST:event_Abrir_InventarioActionPerformed

    // -------------------------------------------------------------------------
    private void aoAcharItem(String item) {
        String caminho = switch (item) {
            case "Banana" -> "/IMAGENS/ITENS/Banana.png";
            case "Bala"   -> "/IMAGENS/ITENS/Bala.png";
            case "Erva"   -> "/IMAGENS/ITENS/Erva.png";
            case "Maçã"   -> "/IMAGENS/ITENS/Maca.png";
            case "Poção"  -> "/IMAGENS/ITENS/Pocao.png";
            default -> null;
        };

        ImageIcon icone = null;
        if (caminho != null) {
            java.net.URL url = getClass().getResource(caminho);
            if (url != null) {
                ImageIcon original = new ImageIcon(url);
                java.awt.Image img = original.getImage()
                    .getScaledInstance(96, 96, java.awt.Image.SCALE_SMOOTH);
                icone = new ImageIcon(img);
            }
        }

        String[] opcoes = {"USAR", "GUARDAR", "DEIXAR"};
        int escolha = JOptionPane.showOptionDialog(
            this,
            "Você achou: " + item + "!",
            "Item encontrado",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            icone,
            opcoes,
            opcoes[0]
        );

        switch (escolha) {
            case 0 -> new EfeitoItem().Efeito(item, jogador);
            case 1 -> I.AdicionarItem(item);
            default -> { }
        }
    }

    // -------------------------------------------------------------------------
    private void investigarMovel(String nomeMovel) {
        boolean jaOlhou = switch (nomeMovel) {
            case "cama"   -> olhouCama;
            case "criado" -> olhouCriado;
            case "guarda" -> olhouGuarda;
            case "quadro" -> olhouQuadro;
            default -> true;
        };

        if (jaOlhou) {
            JOptionPane.showMessageDialog(this, "Você já olhou isso.");
            return;
        }

        switch (nomeMovel) {
            case "cama"   -> olhouCama = true;
            case "criado" -> olhouCriado = true;
            case "guarda" -> olhouGuarda = true;
            case "quadro" -> olhouQuadro = true;
        }

        String descricao = switch (nomeMovel) {
            case "cama" ->
                "Você revira a cama velha.\nEla está empoeirada e parece abandonada há tempos.";
            case "criado" ->
                "Você abre o criado-mudo.\nA porta está caída e há muita poeira dentro.";
            case "guarda" ->
                "Você olha o guarda-roupa.\nAs portas estão quebradas e falta um pé.";
            case "quadro" ->
                "Você observa o quadro na parede.\nA moldura está torta e a pintura está gasta.";
            default -> "Você investiga...";
        };

        JOptionPane.showMessageDialog(
            this, descricao, "Investigando", JOptionPane.PLAIN_MESSAGE
        );

        if (Quarto.TemItem()) {
            aoAcharItem(sorteador.SortarItem());
        } else {
            JOptionPane.showMessageDialog(this, "Você não achou nada.");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaQuarto.class.getName())
                .log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir_Inventario;
    private javax.swing.JButton BT_VOLTAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImagem;
    // End of variables declaration//GEN-END:variables
}
