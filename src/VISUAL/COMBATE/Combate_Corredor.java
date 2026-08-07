
package VISUAL.COMBATE;

import BASE.COMBATE.DanoArmas;
import BASE.COMBATE.EscolhaArma;
import BASE.COMBATE.Monstro;
import BASE.COMBATE.Pontuação;
import BASE.PERSONAGEM.INVENTARIO;
import BASE.PERSONAGEM.Jogador;
import java.util.Random;


public class Combate_Corredor extends javax.swing.JFrame {
    private Jogador jogador;
    private INVENTARIO inventario;
    private DanoArmas danoArmas;
    private EscolhaArma escolhaArma;
    private Monstro monstro;
    
    private Pontuação pontuacao = new Pontuação();
    private int monstrosDerrotados = 0;
    private final int TOTAL_MONSTROS = 5;
    
        Random ale = new Random();

//==============================================================================
    public Combate_Corredor(Jogador jogador, INVENTARIO inventario,
                            DanoArmas danoArmas, EscolhaArma escolhaArma) {
        
        this.jogador = jogador;
        this.inventario = inventario;
        this.danoArmas = danoArmas;
        this.escolhaArma = escolhaArma;

        this.monstro = new Monstro(null, 0, 0);
        this.monstro.SortearMonstro(); // monstro aleatório

        initComponents();
        lblErvaAtiva.setVisible(false);

        // Tamanho real da imagem Corredor.png = 1320 x 746
        final int LARGURA = 1300;
        final int ALTURA = 726;

        // Área útil da janela = mesmo tamanho da imagem
        getContentPane().setPreferredSize(new java.awt.Dimension(LARGURA, ALTURA));
        setResizable(false);
        pack(); // ajusta a janela (com barra de título) em volta dos 1320x746
        setLocationRelativeTo(null);

        // Fundo ocupa 100% da área útil, sem distorcer
        lblFundo.setOpaque(false);
        lblFundo.setText("");
        lblFundo.setBounds(0, 0, LARGURA, ALTURA);

        java.net.URL url = getClass().getResource("/IMAGENS/COMODOS/Corredor.png");
        if (url != null) {
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(url);
            java.awt.Image img = icon.getImage()
                .getScaledInstance(LARGURA, ALTURA, java.awt.Image.SCALE_SMOOTH);
            lblFundo.setIcon(new javax.swing.ImageIcon(img));
        }

        // Garante fundo atrás de tudo
        getContentPane().setComponentZOrder(lblFundo, getContentPane().getComponentCount() - 1);

        mostrarMonstro();
        atualizarHUD();
        setLog("Um " + monstro.getNomeMostro() + " aparece no corredor!");
    }
//==============================================================================

    
//==============================================================================
    private void setLog(String mensagem) {
        lblLog.setText(
            "<html><body style='width:100%; text-align:center; padding:8px;'>"
            + mensagem.replace("\n", "<br>")
            + "</body></html>"
        );
    }
//==============================================================================

    
//==============================================================================
    private void atualizarHUD() {
        lblNumVidaJogador.setText(String.valueOf(jogador.getVida()));
        lblNumVidaMonstro.setText(String.valueOf(monstro.getVidaMostro()));
        lblMunicao.setText(danoArmas.getBala() + "/" + danoArmas.getBalaMaxima());
    
        if (jogador.getTurnosErva() > 0) {
            lblErvaAtiva.setVisible(true);
            lblErvaAtiva.setText(String.valueOf(jogador.getTurnosErva()));
        } 
        else {
            lblErvaAtiva.setVisible(false);
        }
    
    }
//==============================================================================


//==============================================================================
private void mostrarMonstro() {
    String caminho = switch (monstro.getNomeMostro()) {
        case "Zumbi"     -> "/IMAGENS/MOSTROS/Zumbi/Zumbi.png";
        case "Esqueleto" -> "/IMAGENS/MOSTROS/Esqueleto/Esqueleto.png";
        case "Goblin"    -> "/IMAGENS/MOSTROS/Goblin/Goblin.png";
        case "Lobo"      -> "/IMAGENS/MOSTROS/Lobo/Lobo.png";
        case "Aranha"    -> "/IMAGENS/MOSTROS/Aranha/Aranha.png";
        default -> null;
    };
    if (caminho == null) return;

    java.net.URL url = getClass().getResource(caminho);
    if (url == null) return;

    javax.swing.ImageIcon icon = new javax.swing.ImageIcon(url);
    java.awt.Image img = icon.getImage()
        .getScaledInstance(280, 300, java.awt.Image.SCALE_SMOOTH);
    
    lblMonstro.setIcon(new javax.swing.ImageIcon(img));
    lblMonstro.setText("");
}
//==============================================================================


//==============================================================================
private void turnoDoMonstro(String msgJogador) {
    int sorte = ale.nextInt(1, 11); // 1 a 10
    String msgMonstro;
    
    if (sorte <= 6) {
        int dano = monstro.getDanoMostro();
        jogador.LevarDano(dano);
        pontuacao.Dimuir_Pontos(dano);
        msgMonstro = monstro.getNomeMostro() + " atacou e causou " + dano + " de dano!";
    } 
    else {
        msgMonstro = monstro.getNomeMostro() + " errou o ataque!";
    }
    
    // mostra os dois na área cinza
    setLog(msgJogador + "\n" + msgMonstro);
    atualizarHUD();

    if (jogador.getVida() <= 0) {
        setLog(msgJogador + "\n" + msgMonstro + "\nVocê morreu...");
        javax.swing.JOptionPane.showMessageDialog(this, "Game Over");
        dispose();
    }
    jogador.passarTurnoErva();
}
//==============================================================================


//==============================================================================
private void proximoMonstro() {
    monstro = new Monstro(null, 0, 0);
    monstro.SortearMonstro();   // ← novo monstro de verdade
    mostrarMonstro();
    atualizarHUD();
    setLog("Monstro " + (monstrosDerrotados + 1) + "/5\n"
         + "Uma nova criatura aparece: " + monstro.getNomeMostro() + "!");
}
//==============================================================================

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLog = new javax.swing.JLabel();
        lblErvaAtiva = new javax.swing.JLabel();
        lblNumVidaMonstro = new javax.swing.JLabel();
        btnSoco = new javax.swing.JButton();
        lblMunicao = new javax.swing.JLabel();
        lblNumVidaJogador = new javax.swing.JLabel();
        lblIconeMunicao = new javax.swing.JLabel();
        lblMonstro = new javax.swing.JLabel();
        lblVidaMonstro = new javax.swing.JLabel();
        lblVidaJogador = new javax.swing.JLabel();
        btnMirar = new javax.swing.JButton();
        btnAtacar = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnRecarregar = new javax.swing.JButton();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblLog.setBackground(new java.awt.Color(153, 153, 153));
        lblLog.setFont(new java.awt.Font("Sitka Display", 2, 36)); // NOI18N
        lblLog.setForeground(new java.awt.Color(0, 0, 0));
        lblLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLog.setText("jLabel1");
        lblLog.setOpaque(true);
        getContentPane().add(lblLog);
        lblLog.setBounds(660, 540, 620, 134);

        lblErvaAtiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENS/ITENS/Erva.png"))); // NOI18N
        lblErvaAtiva.setText("5");
        getContentPane().add(lblErvaAtiva);
        lblErvaAtiva.setBounds(1180, 120, 79, 69);

        lblNumVidaMonstro.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        lblNumVidaMonstro.setForeground(new java.awt.Color(255, 153, 0));
        lblNumVidaMonstro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumVidaMonstro.setText("50");
        getContentPane().add(lblNumVidaMonstro);
        lblNumVidaMonstro.setBounds(580, 110, 90, 60);

        btnSoco.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        btnSoco.setForeground(new java.awt.Color(0, 0, 0));
        btnSoco.setText("SOCO");
        btnSoco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSocoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSoco);
        btnSoco.setBounds(0, 480, 220, 60);

        lblMunicao.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblMunicao.setForeground(new java.awt.Color(255, 102, 0));
        lblMunicao.setText("10/10");
        getContentPane().add(lblMunicao);
        lblMunicao.setBounds(1070, 20, 130, 40);

        lblNumVidaJogador.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        lblNumVidaJogador.setForeground(new java.awt.Color(255, 255, 255));
        lblNumVidaJogador.setText("100");
        getContentPane().add(lblNumVidaJogador);
        lblNumVidaJogador.setBounds(10, 30, 70, 50);

        lblIconeMunicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENS/ARMAS/MUNICAO.png"))); // NOI18N
        lblIconeMunicao.setText("6/6");
        getContentPane().add(lblIconeMunicao);
        lblIconeMunicao.setBounds(1220, 0, 50, 108);

        lblMonstro.setBackground(new java.awt.Color(0, 0, 0));
        lblMonstro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENS/OUTROS/T_POSE.png"))); // NOI18N
        getContentPane().add(lblMonstro);
        lblMonstro.setBounds(490, 210, 310, 270);

        lblVidaMonstro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENS/OUTROS/Coracao_Roxo.png"))); // NOI18N
        getContentPane().add(lblVidaMonstro);
        lblVidaMonstro.setBounds(580, 90, 110, 100);

        lblVidaJogador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENS/OUTROS/Coracao_Vermelho.png"))); // NOI18N
        getContentPane().add(lblVidaJogador);
        lblVidaJogador.setBounds(0, 0, 120, 110);

        btnMirar.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnMirar.setForeground(new java.awt.Color(0, 0, 0));
        btnMirar.setText("MIRAR");
        btnMirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMirarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMirar);
        btnMirar.setBounds(270, 540, 240, 60);

        btnAtacar.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnAtacar.setForeground(new java.awt.Color(0, 0, 0));
        btnAtacar.setText("ATACAR");
        btnAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtacarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtacar);
        btnAtacar.setBounds(0, 550, 220, 60);

        btnInventario.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(0, 0, 0));
        btnInventario.setText("INVENTÀRIO");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnInventario);
        btnInventario.setBounds(270, 620, 240, 61);

        btnRecarregar.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnRecarregar.setForeground(new java.awt.Color(0, 0, 0));
        btnRecarregar.setText("RECARREGAR");
        btnRecarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecarregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecarregar);
        btnRecarregar.setBounds(0, 620, 220, 60);

        lblFundo.setBackground(new java.awt.Color(102, 102, 102));
        lblFundo.setText("jLabel1");
        lblFundo.setOpaque(true);
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, 0, 1290, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        // TODO add your handling code here:
        VISUAL.COLOCAR_FUNDO.JanelaInventario janela =
        new VISUAL.COLOCAR_FUNDO.JanelaInventario(inventario, jogador);
        janela.setVisible(true);

        // Atualiza vida/munição caso tenha usado item
        janela.setVisible(true);
        atualizarHUD();
        setLog("Você fechou a mochila.");
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnRecarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecarregarActionPerformed
        // TODO add your handling code here:
        String arma = escolhaArma.getArma();

        if (arma == null) {
            setLog("Você não tem arma equipada!");
            return;
        }

        // Faca / Soco não recarregam
        if (arma.equals("Faca") || arma.equals("Soco")) {
            setLog("Essa arma não usa munição.");
            return;
        }

        // Já está cheio?
        if (danoArmas.getBala() >= danoArmas.getBalaMaxima()) {
            setLog("A arma já está carregada.");
            return;
        }

        // Tem Bala na mochila?
        if (inventario.VerSeTemBala()) {
            inventario.REMOVER("Bala");
            danoArmas.recarregarArma(arma);
            atualizarHUD();
            setLog("Você recarregou a " + arma + " (" 
             + danoArmas.getBala() + "/" + danoArmas.getBalaMaxima() + ").");
        } 
        else {
            setLog("Você não tem Bala na mochila!");
        }
    }//GEN-LAST:event_btnRecarregarActionPerformed

    private void btnAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtacarActionPerformed
        // TODO add your handling code here:
        String arma = escolhaArma.getArma();
        int sorte = ale.nextInt(1, 11);
        

        if (arma == null) {
            setLog("Você não tem arma equipada!");
            return;
        }

        if (!danoArmas.TemBala(arma)) {
            setLog("Você está sem munição! Recarregue.");
            turnoDoMonstro(arma);
            return;
        }
        
        String msg = "";
        if (sorte <= 8) {
            int dano = escolhaArma.ATAQUE();
            monstro.MonstroLevaDano(dano);
            pontuacao.Ponto_Dano_Causado(dano);
            danoArmas.MininuirBala();
            msg = "Você atacou e causou " + dano + " de dano!";
            atualizarHUD();
        }
        else {
            msg = "Você Errou o tiro";
            danoArmas.MininuirBala();
            atualizarHUD();
        }

        
        if (monstro.getVidaMostro() <= 0) {
            setLog(msg + "\nVocê derrotou o " + monstro.getNomeMostro() + "!");
            pontuacao.porMonstroDerrotado(monstro.getNomeMostro());
            monstrosDerrotados++;

            if (monstrosDerrotados >= TOTAL_MONSTROS) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Você sobreviveu ao corredor!\nPontuação: " + pontuacao.getPontos()
                );
                dispose();
                return;
            }

            proximoMonstro();
            return;  // ← NÃO chama turnoDoMonstro
        }
        turnoDoMonstro(msg);
    }//GEN-LAST:event_btnAtacarActionPerformed

    private void btnMirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMirarActionPerformed
        // TODO add your handling code here:
        String arma = escolhaArma.getArma();

        if (arma == null) {
            setLog("Você não tem arma equipada!");
            return;
        }

        if (!danoArmas.TemBala(arma)) {
            setLog("Você está sem munição! Recarregue.");
            return;
        }

        int sorte = new java.util.Random().nextInt(1, 11); // 1 a 10
        int danoBase = escolhaArma.ATAQUE();
        String msg;

        if (sorte <= 7) {
            // Acertou a mira → dano x2
            int dano = danoBase * 2;
            monstro.MonstroLevaDano(dano);
            pontuacao.Ponto_Dano_Causado(dano);
            msg = "Você mirou e acertou! Dano: " + dano;
        }
        else {
            // Errou a mira
            msg = "Você mirou, mas errou o ataque!";
        }

        danoArmas.MininuirBala();
        atualizarHUD();

        if (monstro.getVidaMostro() <= 0) {
            setLog(msg + "\nVocê derrotou o " + monstro.getNomeMostro() + "!");
            pontuacao.porMonstroDerrotado(monstro.getNomeMostro());
            monstrosDerrotados++;

            if (monstrosDerrotados >= TOTAL_MONSTROS) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Você sobreviveu ao corredor!\nPontuação: " + pontuacao.getPontos()
                );
                dispose();
                return;
            }
            proximoMonstro();
            return;  // ← NÃO chama turnoDoMonstro
        }

        turnoDoMonstro(msg);
    }//GEN-LAST:event_btnMirarActionPerformed

    private void btnSocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSocoActionPerformed
        String armaAntes = escolhaArma.getArma();

        // Equipa soco só neste ataque
        escolhaArma.SOCO();  // se o método tiver outro nome, veja no EscolhaArma.java

        String msg;

        int dano = escolhaArma.ATAQUE(); // dano do soco
        monstro.MonstroLevaDano(dano);
        pontuacao.Ponto_Dano_Causado(dano);
        msg = "Você deu um soco e causou " + dano + " de dano!";

        atualizarHUD();

        // Devolve a arma que estava equipada (Pistola, etc.)
        if (armaAntes != null) {
            switch (armaAntes) {
                case "Pistola"    -> escolhaArma.PISTOLA();
                case "Desert"     -> escolhaArma.DESERT();
                case "Espingarda" -> escolhaArma.ESPINGARDA();
                case "Faca"       -> escolhaArma.FACA();
                default -> escolhaArma.PISTOLA();
            }
        }

        if (monstro.getVidaMostro() <= 0) {
            setLog(msg + "\nVocê derrotou o " + monstro.getNomeMostro() + "!");
            pontuacao.porMonstroDerrotado(monstro.getNomeMostro());
            monstrosDerrotados++;

            if (monstrosDerrotados >= TOTAL_MONSTROS) {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Você sobreviveu ao corredor!\nPontuação: " + pontuacao.getPontos()
                );
                dispose();
                return;
            }
            proximoMonstro();
            return;  // ← NÃO chama turnoDoMonstro
        }

        turnoDoMonstro(msg);
    }//GEN-LAST:event_btnSocoActionPerformed
//==============================================================================
    
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtacar;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnMirar;
    private javax.swing.JButton btnRecarregar;
    private javax.swing.JButton btnSoco;
    private javax.swing.JLabel lblErvaAtiva;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblIconeMunicao;
    private javax.swing.JLabel lblLog;
    private javax.swing.JLabel lblMonstro;
    private javax.swing.JLabel lblMunicao;
    private javax.swing.JLabel lblNumVidaJogador;
    private javax.swing.JLabel lblNumVidaMonstro;
    private javax.swing.JLabel lblVidaJogador;
    private javax.swing.JLabel lblVidaMonstro;
    // End of variables declaration//GEN-END:variables
}
