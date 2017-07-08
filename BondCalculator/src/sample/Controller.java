package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Label output;
    public TextField rate;
    public TextField value;
    public TextField coupon;
    public TextField length;
    public TextField cost;
    public void calculate(ActionEvent actionEvent) {
        try{
            double length = Integer.parseInt(this.length.getText());
            double rate = Double.parseDouble(this.rate.getText());
            double cost = Double.parseDouble(this.cost.getText());
            double value = Double.parseDouble(this.value.getText());
            double coupon = Double.parseDouble(this.coupon.getText());
            double total = value;
            for(int i=0;i<length;i++) { //assumes that coupons are yearly and paid at same date as maturity
                total += Math.pow(1 + (rate / 100), i) * coupon;
            }
            output.setText(Double.toString((Math.pow(1+(total-cost)/cost, 1 /length)-1)*100)+"%");
        }catch (NumberFormatException e){
            output.setText("One or more numbers are invalid");
        }

    }
}
