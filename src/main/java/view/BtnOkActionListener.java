package view;

import Service.PratosService;
import Utils.Utils;
import model.Pratos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnOkActionListener implements ActionListener {

    private PratosService pratosService = new PratosService();
    private Pratos pratoSelecionado = null;
    private int YesNoOptMain;
    private int YesNoOptSecondary;
    private int YesNoOptCake;
    private int YesNoOptNew;
    private int contadorPratos = 0;

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
                  //Percorre a lista de pratos buscando o último prato digitado no campo
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

        //Tratamento de erros no caso do campo não ser preenchido, o mesmo se aplica para o tipo
        if(nome == null) {
            return;
        }else if(nome.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nome inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tipo = JOptionPane.showInputDialog(nome.concat(Utils.TIPO_PRATO_LINHA).concat(this.pratoSelecionado.getNome()).concat(" não"));

        if(tipo == null) {
            return;
        }else if(tipo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Tipo inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

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