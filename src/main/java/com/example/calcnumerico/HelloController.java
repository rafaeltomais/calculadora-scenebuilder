package com.example.calcnumerico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    private String currentNumber = "";
    private String number1 = "";
    private String number2 = "";
    public String signalMath = "";
    @FXML
    private Label lblOperation;
    @FXML
    private Label lblResult;

    @FXML
    void onClickBtZero(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("0", currentOperation);
    }

    @FXML
    void onClickBtOne(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("1", currentOperation);
    }

    @FXML
    void onClickBtTwo(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("2", currentOperation);
    }

    @FXML
    void onClickBtThree(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("3", currentOperation);
    }

    @FXML
    void onClickBtFour(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("4", currentOperation);
    }

    @FXML
    void onClickBtFive(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("5", currentOperation);
    }

    @FXML
    void onClickBtSix(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("6", currentOperation);
    }

    @FXML
    void onClickBtSeven(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("7", currentOperation);
    }

    @FXML
    void onClickBtEight(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("8", currentOperation);
    }

    @FXML
    void onClickBtNine(ActionEvent event) {
        String currentOperation = getCurrentOperation();
        setLabelOperation("9", currentOperation);
    }

    @FXML
    void onClickBtPoint(ActionEvent event) {

    }

    @FXML
    void onClickBtEqual(ActionEvent event) {
        String currentOperation = getCurrentOperation();

        if(isLastCharASignalMath(currentOperation)) {
            if (thereIsOperation(currentOperation)) {
                number2 = currentOperation.substring(currentNumber.length());
            } else {
                number1 = lblResult.getText();
            }
            doTheOperation();
        }
    }

    @FXML
    void onClickBtPlus(ActionEvent event) {
        String currentOperation = getCurrentOperation();

        if(!thereIsOperation(currentOperation)) {
            signalMath = "plus";

            number1 = currentOperation;
            setLabelOperation(signalMath, currentOperation);
            currentNumber = getCurrentOperation();
        }
    }

    @FXML
    void onClickBtMinus(ActionEvent event) {
        String currentOperation = getCurrentOperation();

        if(!thereIsOperation(currentOperation)) {
            signalMath = "minus";

            number1 = currentOperation;
            setLabelOperation(signalMath, currentOperation);
            currentNumber = getCurrentOperation();
        }
    }

    @FXML
    void onClickBtMultiply(ActionEvent event) {
        String currentOperation = getCurrentOperation();

        if(!thereIsOperation(currentOperation)) {
            signalMath = "multiply";

            number1 = currentOperation;
            setLabelOperation(signalMath, currentOperation);
            currentNumber = getCurrentOperation();
        }
    }

    @FXML
    void onClickBtDivided(ActionEvent event) {
        String currentOperation = getCurrentOperation();

        if(!thereIsOperation(currentOperation)) {
            signalMath = "divided";

            number1 = currentOperation;
            setLabelOperation(signalMath, currentOperation);
            currentNumber = getCurrentOperation();
        }
    }

    @FXML
    void onClickBtPercent(ActionEvent event) {

    }

    @FXML
    void onClickBtSqrt(ActionEvent event) {

    }

    @FXML
    void onClickBtClean(ActionEvent event) {
        lblOperation.setText("0");
        lblResult.setText("0");
        number1 = "";
        number2 = "";
    }

    public String getCurrentOperation() {
        return lblOperation.getText();
    }

    public void setLabelOperation(String signalInput, String currentOperation) {
        if(signalInput.length() == 1){
            lblOperation.setText(currentOperation.equals("0") ? signalInput : currentOperation + signalInput);
        }
        else {
            switch (signalInput) {
                case "plus":
                    signalInput = "+";
                    break;
                case "minus":
                    signalInput = "-";
                    break;
                case "multiply":
                    signalInput = "*";
                    break;
                case "divided":
                    signalInput = "/";
                    break;
            }
            lblOperation.setText(currentOperation + signalInput);
        }
    }

    public boolean thereIsOperation(String currentOperation) {
        return currentOperation.matches(".*[\\+\\-\\*\\/].*");
    }

    public void doTheOperation() {

        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        int result = 0;

        switch (signalMath) {
            case "plus":
                result = num1 + num2;
                break;
            case "minus":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divided":
                result = num1 / num2;
                break;
            default:
                result = num1;
        }

        lblResult.setText(Integer.toString(result));
        lblOperation.setText(Integer.toString(result));
        number1 = lblResult.getText();
    }

    private boolean isLastCharASignalMath(String currentOperation) {
        return !currentOperation.matches(".*[\\+\\-\\*\\/]");
    }
}