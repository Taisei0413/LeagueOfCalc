package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class Controller {

    @FXML
    private TextField ad;

    @FXML
    private TextField ar;

    @FXML
    private TextField ap;

    @FXML
    private TextField mr;

    @FXML
    private TextField output;

    @FXML
    private Button calc;


    @FXML
    private CheckBox adBox;

    @FXML
    private CheckBox apBox;

    @FXML
    private TextField arPen;

    @FXML
    private TextField arPenPercent;

    @FXML
    private TextField arReduction;

    @FXML
    private TextField arReductionPercent;

    @FXML
    private TextField adTrueDmg;

    @FXML
    private TextField adTrueDmgPercent;

    @FXML
    private TextField mrPen;

    @FXML
    private TextField mrPenPercent;

    @FXML
    private TextField mrReduction;

    @FXML
    private TextField mrReductionPercent;

    @FXML
    private TextField apTrueDmg;

    @FXML
    private TextField apTrueDmgPercent;

    @FXML
    private CheckBox penBox;

    @FXML
    private CheckBox penPercentBox;

    @FXML
    private CheckBox reductionBox;

    @FXML
    private CheckBox reductionPercentBox;

    @FXML
    private CheckBox trueDmgBox;

    @FXML
    private CheckBox trueDmgPercentBox;

    @FXML
    private CheckBox critical;


    public void start(Stage mainStage){

        ad.setDisable(true);
        ar.setDisable(true);
        ap.setDisable(true);
        mr.setDisable(true);
        arPen.setDisable(true);
        arPenPercent.setDisable(true);
        arReduction.setDisable(true);
        arReductionPercent.setDisable(true);
        adTrueDmg.setDisable(true);
        adTrueDmgPercent.setDisable(true);
        mrPen.setDisable(true);
        mrPenPercent.setDisable(true);
        mrReduction.setDisable(true);
        mrReductionPercent.setDisable(true);
        apTrueDmg.setDisable(true);
        apTrueDmgPercent.setDisable(true);
        critical.setDisable(true);
    }

    public void handleBox(ActionEvent actionEvent){
        if (adBox.isSelected()){
            enable(ar, ad);
            critical.setDisable(false);
        }
        if (apBox.isSelected()){
            enable(mr, ap);
        }
        if (!adBox.isSelected()){
            disableAndResetValue(ad, ar);
            disableAndResetValue(arPen, arPenPercent);
            disableAndResetValue(arReduction, arReductionPercent);
            disableAndResetValue(adTrueDmg, adTrueDmgPercent);
            critical.setDisable(true);
            critical.setSelected(false);
        }
        if (!apBox.isSelected()){
            disableAndResetValue(ap, mr);
            disableAndResetValue(mrPen, mrPenPercent);
            disableAndResetValue(mrReduction, mrReductionPercent);
            disableAndResetValue(apTrueDmg, apTrueDmgPercent);
        }

        togglePen();
        togglePenPercent();
        toggleReductionPen();
        toggleReductionPercent();
        toggleTrueDmg();
        toggleTrueDmgPercent();

    }

    private void togglePen() {
        if (adBox.isSelected() && penBox.isSelected()){
            arPen.setDisable(false);
        }

        if (apBox.isSelected() && penBox.isSelected()){
            mrPen.setDisable(false);
        }

        if (!penBox.isSelected()){
            disableAndResetValue(arPen, mrPen);
        }
    }

    private void togglePenPercent() {
        if (adBox.isSelected() && penPercentBox.isSelected()){
            arPenPercent.setDisable(false);
        }

        if (apBox.isSelected() && penPercentBox.isSelected()){
            mrPenPercent.setDisable(false);
        }

        if (!penPercentBox.isSelected()){
            disableAndResetValue(arPenPercent, mrPenPercent);
        }
    }

    private void toggleReductionPen() {
        if (adBox.isSelected() && reductionBox.isSelected()){
            arReduction.setDisable(false);
        }

        if (apBox.isSelected() && reductionBox.isSelected()){
            mrReduction.setDisable(false);
        }

        if (!reductionBox.isSelected()){
            disableAndResetValue(arReduction, mrReduction);
        }
    }

    private void toggleReductionPercent() {
        if (adBox.isSelected() && reductionPercentBox.isSelected()){
            arReductionPercent.setDisable(false);
        }

        if (apBox.isSelected() && reductionPercentBox.isSelected()){
            mrReductionPercent.setDisable(false);
        }

        if (!reductionPercentBox.isSelected()){
            disableAndResetValue(arReductionPercent, mrReductionPercent);
        }
    }

    private void toggleTrueDmg() {
        if (adBox.isSelected() && trueDmgBox.isSelected()){
            adTrueDmg.setDisable(false);
        }

        if (apBox.isSelected() && trueDmgBox.isSelected()){
            apTrueDmg.setDisable(false);
        }

        if (!trueDmgBox.isSelected()){
            disableAndResetValue(adTrueDmg, apTrueDmg);
        }
    }

    private void toggleTrueDmgPercent() {
        if (adBox.isSelected() && trueDmgPercentBox.isSelected()){
            adTrueDmgPercent.setDisable(false);
        }

        if (apBox.isSelected() && trueDmgPercentBox.isSelected()){
            apTrueDmgPercent.setDisable(false);
        }

        if (!trueDmgPercentBox.isSelected()){
            disableAndResetValue(adTrueDmgPercent, apTrueDmgPercent);
        }
    }

    private void disableAndResetValue(TextField textfield,TextField textfield2) {
        textfield.setDisable(true);
        textfield2.setDisable(true);
        textfield.setText("");
        textfield2.setText("");
    }

    private void enable(TextField textfield,TextField textfield2) {
        textfield.setDisable(false);
        textfield2.setDisable(false);
    }


    public void handleCalc(ActionEvent actionEvent){

        double armor = 0;
        double attackDamage = 0;

        double magicResist = 0;
        double abilityPower = 0;

        double arPenVal = 0;
        double arPenPercentVal = 0;
        double arReductionVal = 0;
        double arReductionPercentVal = 0;
        double adTrueVal = 0;
        double adTruePercentVal = 0;

        double mrPenVal = 0;
        double mrPenPercentVal = 0;
        double mrReductionVal = 0;
        double mrReductionPercentVal = 0;
        double apTrueVal = 0;
        double apTruePercentVal = 0;

        double answer = 0.0;
        double adAnswer = 0.0;
        double apAnswer = 0.0;


        try{
            if(!ad.isDisable()) {
                attackDamage = Double.parseDouble(ad.getText());
                armor = Double.parseDouble(ar.getText());
            }
            if(!ap.isDisable()) {
                abilityPower = Double.parseDouble(ap.getText());
                magicResist = Double.parseDouble(mr.getText());
            }

            if(!arPen.isDisable()){
                arPenVal = Double.parseDouble(arPen.getText());
            }
            if(!mrPen.isDisable()){
                mrPenVal = Double.parseDouble(mrPen.getText());
            }

            if(!arPenPercent.isDisable()){
                arPenPercentVal = Double.parseDouble(arPenPercent.getText());
            }

            if(!mrPenPercent.isDisable()){
                mrPenPercentVal = Double.parseDouble(mrPenPercent.getText());
            }

            if(!arReduction.isDisable()){
                arReductionVal = Double.parseDouble(arReduction.getText());
            }

            if(!mrReduction.isDisable()){
                mrReductionVal = Double.parseDouble(mrReduction.getText());
            }

            if(!arReductionPercent.isDisable()){
                arReductionPercentVal = Double.parseDouble(arReductionPercent.getText());
            }

            if(!mrReductionPercent.isDisable()){
                mrReductionPercentVal = Double.parseDouble(mrReductionPercent.getText());
            }

            if(!adTrueDmg.isDisable()){
                adTrueVal = Double.parseDouble(adTrueDmg.getText());
            }

            if(!apTrueDmg.isDisable()){
                apTrueVal = Double.parseDouble(apTrueDmg.getText());
            }

            if(!adTrueDmgPercent.isDisable()){
                adTruePercentVal = Double.parseDouble(adTrueDmgPercent.getText());
            }

            if(!apTrueDmgPercent.isDisable()){
                apTruePercentVal = Double.parseDouble(apTrueDmgPercent.getText());
            }


        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("数字を入力してください");
            alert.showAndWait();
        }

//        ap.setDisable(true);

        if (critical.isSelected()) attackDamage = attackDamage * 2;

        adTrueVal += attackDamage * adTruePercentVal/100;
        attackDamage = attackDamage * (100 - adTruePercentVal)/100;
        apTrueVal += abilityPower * apTruePercentVal/100;
        abilityPower = abilityPower * (100 - apTruePercentVal)/100;

        armor = armor -(arReductionVal + armor * (arReductionPercentVal/100));
        magicResist = magicResist -(mrReductionVal + magicResist * (mrReductionPercentVal/100));

        if (armor >= 0){
            armor = armor -(arPenVal + armor * (arPenPercentVal/100));
            if (0 > armor) armor = 0;
        }

        if (magicResist >= 0){
            magicResist = magicResist -(mrPenVal + magicResist * (mrPenPercentVal/100));
            if (0 > magicResist) magicResist = 0;
        }



        if (!ad.isDisable()){
            adAnswer = (attackDamage * (100/(100 + armor))) + adTrueVal;
        }
        if (!ap.isDisable()){
            apAnswer = (abilityPower * (100/(100 + magicResist))) + apTrueVal;
        }
        answer = adAnswer + apAnswer;

        output.setText(String.valueOf(answer));

    }
}
