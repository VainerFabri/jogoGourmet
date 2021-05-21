package view;

import Service.PratosService;
import Utils.Utils;
import model.Pratos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BtnOkActionListener implements ActionListener {

    private PratosService pratosService = new PratosService();
    private Pratos pratoSelecionado = null;
    private int YesNoOptMain;
    private int YesNoOptSecondary;
    private int YesNoOptCake;
    private int YesNoOptNew;
    private int contadorPratos = 0;

    private List<Pratos> listaPratos = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {

      YesNoOptMain = JOptionPane.showConfirmDialog(null, Utils.PERGUNTA.concat(Utils.TIPO_PRATO).concat("?"), Utils.TITULO_PERGUNTA ,JOptionPane.YES_NO_OPTION);

      if(YesNoOptMain == 0){
          YesNoOptSecondary = JOptionPane.showConfirmDialog(null, Utils.PERGUNTA.concat(Utils.PRIMEIRO_PRATO).concat("?"), Utils.TITULO_PERGUNTA ,JOptionPane.YES_NO_OPTION);

          if(YesNoOptSecondary == 0){
              mensagemAcerto();
          }else if(YesNoOptSecondary == 1){
              if(contadorPratos == 0){
                  perguntaLasanha();
                  novoPrato();
              }else{
                  perguntaInfoPrato(pratosService.getPratos().stream().skip(pratosService.getPratos().size() - 1).findFirst().get().getNome());
              }
          }
      }else if(YesNoOptMain == 1){
          YesNoOptCake = JOptionPane.showConfirmDialog(null, Utils.PERGUNTA.concat(Utils.ULTIMO_PRATO).concat("?"), Utils.TITULO_PERGUNTA ,JOptionPane.YES_NO_OPTION);
          if(YesNoOptCake == 0){
              mensagemAcerto();
          }else if(YesNoOptCake == 1){
              if (contadorPratos == 0){
                  perguntaBolo();
                  novoPrato();
              }else{
                  perguntaInfoPrato(pratosService.getPratos().stream().skip(pratosService.getPratos().size() - 1).findFirst().get().getNome());
              }

          }
      }
    }

    private void mensagemAcerto() {
        JOptionPane.showMessageDialog(null, Utils.MSG_ACERTO);
    }

    private void novoPrato() {

        String nome = JOptionPane.showInputDialog(Utils.PERGUNTA_PRATO_NOVO);

        String tipo = JOptionPane.showInputDialog(nome.concat(Utils.TIPO_PRATO_LINHA).concat(this.pratoSelecionado.getNome()).concat(" não"));

        contadorPratos++;
        pratosService.Salvar(new Pratos(nome, tipo));
    }

    private void perguntaBolo() {

        Pratos boloDeChocolate = new Pratos(Utils.ULTIMO_PRATO);

        this.pratoSelecionado = boloDeChocolate;
    }

    private void perguntaLasanha() {

        Pratos lasanha = new Pratos(Utils.PRIMEIRO_PRATO);
        this.pratoSelecionado = lasanha;
    }

    private void perguntaInfoPrato(String infoPrato){
        YesNoOptNew = JOptionPane.showConfirmDialog(null, Utils.PERGUNTA.concat(infoPrato).concat("?"), Utils.TITULO_PERGUNTA ,JOptionPane.YES_NO_OPTION);
        if (YesNoOptNew == 0){
            mensagemAcerto();
        }else if(YesNoOptNew == 1){
            novoPrato();
        }
    }
}