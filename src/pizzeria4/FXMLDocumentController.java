package pizzeria4;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import modelo.pizza;

public class FXMLDocumentController implements Initializable {

    @FXML
    private ToggleButton pMargarita;
    @FXML
    private ToggleButton iAceitunas;
    @FXML
    private ToggleButton iTomate;
    @FXML
    private ToggleButton p4estaciones;
    @FXML
    private ToggleButton pCuatroQuesos;
    @FXML
    private ToggleButton mRellena;
    @FXML
    private ToggleButton iBBQ;
    @FXML
    private ToggleButton iPollo;
    @FXML
    private ToggleButton pEmpresa;
    @FXML
    private ToggleButton pBBQ;
    @FXML
    private ToggleButton mIntegral;
    @FXML
    private ToggleButton iQueso;
    @FXML
    private ToggleButton iJamon;
    @FXML
    private ToggleButton iCarnePicada;
    @FXML
    private ToggleButton iCebolla;
    @FXML
    private ToggleButton pMarinera;
    @FXML
    private ToggleButton pProscuto;
    @FXML
    private ToggleButton mNormal;
    @FXML
    private ToggleButton pBoloñesa;
    @FXML
    private ToggleButton mFina;
    @FXML
    private ToggleGroup grupoPizza;
    @FXML
    private ToggleGroup masa;
    @FXML
    private Label textPizza;
    @FXML
    private Label textMasa;
    @FXML
    private Label textTamaño;
    @FXML
    private TextArea textIngredientes;
    @FXML
    private Label precioPizza;
    @FXML
    private Label precioMasa;
    @FXML
    private Label precioTamaño;
    @FXML
    private TextArea precioIngredientes;
    @FXML
    private Label precioFinal;
    @FXML
    private SplitPane panelPizzas;
    @FXML
    private Pane panelMasas;
    @FXML
    private Pane panelTamaño;
    @FXML
    private RadioButton rbInfantil;
    @FXML
    private ToggleGroup rbTamaños;
    @FXML
    private RadioButton rbPequeña;
    @FXML
    private RadioButton rbMediana;
    @FXML
    private RadioButton rbFamiliar;
    @FXML
    private SplitPane panelIngredientes;
    @FXML
    private TitledPane panelDetalles;
    @FXML
    private Label labError;
    @FXML
    private Pane logo;
    @FXML
    private Pane logo2;
    @FXML
    private AnchorPane paneBase;

    private pizza nuevaPizza = new pizza();
    @FXML
    private Button ticket;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectArranque();

    }

    @FXML
    private void seleccion(ActionEvent event) {
        clearBoard();
        bordePizza();
        bordeIngredientes();
        bordeMasa();
        tipoPizza();
        tipoMasa();
        tipoTamaño();
        preciosBases();
        verSelec();
        verIngrExtra();
        precioIngreExtra();
        mostrarPrecioPizza();
    }

    private void selectArranque() {
        pMargarita.setSelected(true);
        mNormal.setSelected(true);
        rbMediana.setSelected(true);
        pMargarita.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        mNormal.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        paneBase.setStyle("-fx-background-color: white");
    }

    private void tipoPizza() {

        if (pMargarita.isSelected()) {
            nuevaPizza.setTipo("Margarita");
        }
        if (p4estaciones.isSelected()) {
            nuevaPizza.setTipo("3 Estaciones");
        }
        if (pBBQ.isSelected()) {
            nuevaPizza.setTipo("BBQ");
        }
        if (pBoloñesa.isSelected()) {
            nuevaPizza.setTipo("Bolognesa");
        }
        if (pCuatroQuesos.isSelected()) {
            nuevaPizza.setTipo("4 Quesos");
        }
        if (pEmpresa.isSelected()) {
            nuevaPizza.setTipo("Fattore");
        }
        if (pMarinera.isSelected()) {
            nuevaPizza.setTipo("Marinera");
        }
        if (pProscuto.isSelected()) {
            nuevaPizza.setTipo("Prosciutto");
        }

    }

    private void tipoMasa() {

        if (mFina.isSelected()) {
            nuevaPizza.setMasa("fina");
        }
        if (mIntegral.isSelected()) {
            nuevaPizza.setMasa("integral");
        }
        if (mNormal.isSelected()) {
            nuevaPizza.setMasa("normal");
        }
        if (mRellena.isSelected()) {
            nuevaPizza.setMasa("rellena");
        }

    }

    private void tipoTamaño() {

        if (rbFamiliar.isSelected()) {
            nuevaPizza.setTamaño("familiar");
        }
        if (rbMediana.isSelected()) {
            nuevaPizza.setTamaño("mediana");
        }
        if (rbInfantil.isSelected()) {
            nuevaPizza.setTamaño("infantil");
        }
        if (rbPequeña.isSelected()) {
            nuevaPizza.setTamaño("pequeña");
        }

    }

    private void bordePizza() {
        if (pMargarita.isSelected()) {
            pMargarita.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pMargarita.setStyle("");
        }
        if (p4estaciones.isSelected()) {
            p4estaciones.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            p4estaciones.setStyle("");
        }
        if (pBBQ.isSelected()) {
            pBBQ.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pBBQ.setStyle("");
        }
        if (pBoloñesa.isSelected()) {
            pBoloñesa.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pBoloñesa.setStyle("");
        }
        if (pCuatroQuesos.isSelected()) {
            pCuatroQuesos.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pCuatroQuesos.setStyle("");
        }
        if (pEmpresa.isSelected()) {
            pEmpresa.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pEmpresa.setStyle("");
        }
        if (pMarinera.isSelected()) {
            pMarinera.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pMarinera.setStyle("");
        }
        if (pProscuto.isSelected()) {
            pProscuto.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            pProscuto.setStyle("");
        }
    }

    private void bordeMasa() {

        if (mFina.isSelected()) {
            mFina.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mFina.setStyle("");
        }
        if (mNormal.isSelected()) {
            mNormal.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mNormal.setStyle("");
        }
        if (mIntegral.isSelected()) {
            mIntegral.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mIntegral.setStyle("");
        }
        if (mRellena.isSelected()) {
            mRellena.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            mRellena.setStyle("");
        }
    }

    private void bordeIngredientes() {

        if (iAceitunas.isSelected()) {
            iAceitunas.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iAceitunas.setStyle("");
        }
        if (iBBQ.isSelected()) {
            iBBQ.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iBBQ.setStyle("");
        }
        if (iCarnePicada.isSelected()) {
            iCarnePicada.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iCarnePicada.setStyle("");
        }
        if (iCebolla.isSelected()) {
            iCebolla.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iCebolla.setStyle("");
        }
        if (iJamon.isSelected()) {
            iJamon.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iJamon.setStyle("");
        }
        if (iPollo.isSelected()) {
            iPollo.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iPollo.setStyle("");
        }
        if (iQueso.isSelected()) {
            iQueso.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iQueso.setStyle("");
        }
        if (iTomate.isSelected()) {
            iTomate.setStyle("-fx-border-width:3px;-fx-border-color:red;");
        } else {
            iTomate.setStyle("");
        }

    }

    private void verSelec() {
        String verpizza, vertamaño, vermasa;
        verpizza = nuevaPizza.getTipo();
        if (verpizza != null) {
            textPizza.setText(nuevaPizza.descripcionPizza());
        }
        vertamaño = nuevaPizza.getTamaño();
        if (vertamaño != null) {
            textTamaño.setText("Tamaño " + vertamaño);
        } else {
            textTamaño.setText("");
        }
        vermasa = nuevaPizza.getMasa();
        if (vermasa != null) {
            textMasa.setText("Masa " + vermasa);
        } else {
            textMasa.setText("");
        }
    }

    private void verIngrExtra() {
        textIngredientes.setText("");
        nuevaPizza.limpiarListaIngredientes();

        if (iAceitunas.isSelected()) {
            textIngredientes.appendText("Aceitunas \n");
            nuevaPizza.añadirIngrediente("Aceitunas");
        }
        if (iBBQ.isSelected()) {
            textIngredientes.appendText("Salsa barbacoa \n");
            nuevaPizza.añadirIngrediente("Salsa barbacoa");
        }
        if (iCarnePicada.isSelected()) {
            textIngredientes.appendText("Carne picada\n");
            nuevaPizza.añadirIngrediente("Carne picada");
        }
        if (iCebolla.isSelected()) {
            textIngredientes.appendText("Cebolla \n");
            nuevaPizza.añadirIngrediente("Cebolla");
        }
        if (iJamon.isSelected()) {
            textIngredientes.appendText("Jamón york \n");
            nuevaPizza.añadirIngrediente("Jamón york");
        }
        if (iPollo.isSelected()) {
            textIngredientes.appendText("Pollo \n");
            nuevaPizza.añadirIngrediente("Pollo");
        }
        if (iQueso.isSelected()) {
            textIngredientes.appendText("Mozzarella \n");
            nuevaPizza.añadirIngrediente("Mozzarella");
        }
        if (iTomate.isSelected()) {
            textIngredientes.appendText("Tomate natural\n");
            nuevaPizza.añadirIngrediente("Tomate natural");
        }
//         textIngredientes.setText(nuevaPizza.pedido());//prueba
    }

    private void precioIngreExtra() {
        precioIngredientes.setText("");
        precioIngredientes.setText(nuevaPizza.mostrarPrecioIngredientes());

    }

    private void preciosBases() {

        if (nuevaPizza.getTipo() != null) {
            precioPizza.setText(String.valueOf(nuevaPizza.precioTipoPizza()) + "€");
        } else {
            precioPizza.setText("");
        }
        if (nuevaPizza.getMasa() != null) {
            precioMasa.setText(String.valueOf(nuevaPizza.precioTipoMasa()) + "€");
        } else {
            precioMasa.setText("");
        }
        if (nuevaPizza.getTamaño() != null) {
            precioTamaño.setText("X " + String.valueOf(nuevaPizza.precioTipoTamaño()));
        } else {
            precioTamaño.setText("");
        }

    }

    private void mostrarPrecioPizza() {
        DecimalFormat df = new DecimalFormat("0.00");
        String formateado, tipoP, tipoM;
        tipoP = nuevaPizza.getTipo();
        tipoM = nuevaPizza.getMasa();
        if (tipoM == null && tipoP == null) {
            labError.setText("Selecciona una pizza y un tipo de masa");
        } else if (tipoP == null) {
            labError.setText("Selecciona una pizza");
        } else if (tipoM == null) {
            labError.setText("Selecciona un tipo de masa");
        } else {
            labError.setText("");

            formateado = df.format(nuevaPizza.calcularPrecio());
            precioFinal.setText(String.valueOf(formateado) + "€");
        }
    }

    private void clearBoard() {
        textIngredientes.setText("");
        textMasa.setText("");
        textPizza.setText("");
        textTamaño.setText("");
        precioFinal.setText("");
        precioIngredientes.setText("");
        precioMasa.setText("");
        precioPizza.setText("");
        precioTamaño.setText("");
        nuevaPizza.setMasa(null);
        nuevaPizza.setTamaño(null);
        nuevaPizza.setTipo(null);

    }

    @FXML
    private void imprimirTicket(ActionEvent event) {

        nuevaPizza.generarTicket();
    }
}
