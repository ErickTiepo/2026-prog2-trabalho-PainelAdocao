/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bsi.prog2.paineladocao.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

/**
 *
 * @author victor
 */
public class CardAnimal extends javax.swing.JPanel {
   // Construtor recebe os dados e a referência da TelaPrincipal para poder abrir o JDialog
    public CardAnimal(String nome, Icon foto, TelaPrincipal telaPrincipal) {
        // Usa BorderLayout com 10px de espaçamento vertical entre a foto e o nome
        setLayout(new BorderLayout(0, 10)); 
        setBackground(Color.WHITE); // Fundo do card branco
        setPreferredSize(new Dimension(160, 200)); // Tamanho fixo e agradável para o card
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de "mãozinha" clicável

        // Cria uma borda arredondada cinza claro, com um "padding" interno (EmptyBorder) para a foto não colar na borda
        setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // --- Configuração da Imagem ---
        JLabel lblFoto = new JLabel();
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        
        if (foto != null) {
            // Lógica de redimensionamento de alta qualidade (SCALE_SMOOTH)
            Image img = ((ImageIcon) foto).getImage();
            Image imgRedimensionada = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
            lblFoto.setIcon(new ImageIcon(imgRedimensionada));
        } else {
            lblFoto.setText("Sem foto");
            lblFoto.setForeground(Color.GRAY);
        }

        // --- Configuração do Nome ---
        JLabel lblNome = new JLabel(nome);
        lblNome.setHorizontalAlignment(SwingConstants.CENTER);
        lblNome.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Fonte moderna e em negrito
        lblNome.setForeground(new Color(50, 50, 50)); // Cinza escuro para melhor leitura

        // Adiciona os componentes nas posições corretas do Card
        add(lblFoto, BorderLayout.CENTER);
        add(lblNome, BorderLayout.SOUTH);

        // --- Lógica de Interação (Hover e Clique) ---
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Escurece levemente o fundo e a borda quando o mouse passa por cima
                setBackground(new Color(245, 245, 245)); 
                setBorder(new CompoundBorder(
                    BorderFactory.createLineBorder(new Color(150, 150, 150), 1, true),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Retorna ao estado original quando o mouse sai
                setBackground(Color.WHITE);
                setBorder(new CompoundBorder(
                    BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Dispara o método na Tela Principal para abrir a ficha completa!
                telaPrincipal.abrirFichaDoAnimal(nome);
            }
        });
    } 
}
