package sample.errappear;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.UdpService.UdpService;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrFormControoler implements Initializable {
    @FXML
    ImageView imageview_err;
    @FXML
    Label Editterr_text_id;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(getClass().getResourceAsStream("not1.png"));
        imageview_err.setImage(new Image(getClass().getResourceAsStream("not1.png")));
        Editterr_text_id.setText("shdjhsajdhadsdkjahdkjhdhuebjsbjdjsadjkasdjkhakjsdjkahdjkhdkhakdakjmncxbjcjdfhsdiuh");
    }
}
