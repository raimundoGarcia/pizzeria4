package modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

public class precios {

    private Map<String, Double> listaPizzas = new HashMap<>();
    private Map<String, Double> listaMasas = new HashMap<>();
    private Map<String, Double> listaIngredientes = new HashMap<>();
    private Map<String, String> listaDescripcion = new HashMap<>();
    private Map<String, Double> listaTamaños = new HashMap<>();

    public Map<String, Double> getListaPizzas() {
        return listaPizzas;
    }

    public Map<String, Double> getListaMasas() {
        return listaMasas;
    }

    public Map<String, Double> getListaIngredientes() {
        return listaIngredientes;
    }

    public Map<String, String> getListaDescripcion() {
        return listaDescripcion;
    }

    public Map<String, Double> getListaTamaños() {
        return listaTamaños;
    }

    public precios() {
//        cargarListas();
    }

    public double getPrecioTipoPizza(String tipo) {
        return listaPizzas.get(tipo);
    }

    public double getPrecioMasa(String masa) {
        return listaMasas.get(masa);
    }

    public double getPrecioTamaño(String tamaño) {
        return listaTamaños.get(tamaño);
    }

    public double getPrecioIngrediente(String ingrediente) {
        return listaIngredientes.get(ingrediente);
    }

    public String getDescripcionPizza(String tipo) {
        return listaDescripcion.get(tipo);
    }

    public void cargarListas() {

        listaDescripcion.put("Margarita", "Margarita (Salsa de tomate y mozzarella)                                  ");
        listaDescripcion.put("3 Estaciones", "3 Estaciones (Tomate, mozzarella, alcachofas, aceitunas, jamón, champiñon)");
        listaDescripcion.put("BBQ", "BBQ (Tomate, mozzarella, salsa barbacoa, pollo, carne picada, bacon)      ");
        listaDescripcion.put("Bolognesa", "Bolognesa (Tomate,Mozzarella, salsa bolognesa, Carne Picada)              ");
        listaDescripcion.put("4 Quesos", "4 Quesos (tomate, mozzarella, parmesano, queso azul, rulo de cabra)       ");
        listaDescripcion.put("Fattore", "Fattore (Tomate, mozzarella, jamón serrano, mozzarella di buffala, rucula)");
        listaDescripcion.put("Marinera", "Marinera (Salsa marinera, mozzarella, mejillones, gambas, calamares)      ");
        listaDescripcion.put("Prosciutto", "Prosciutto (Tomate, mozzarella, prosciutto, jamón cocido)                 ");

        String primero = "";
        int contador = 1;
        double segundo = -1;

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Archivo");

            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File archivo = fileChooser.showOpenDialog(null);
            if (archivo != null) {
                File pathArchivo = new File(archivo.getAbsolutePath());

                Stream<String> datos = Files.lines(pathArchivo.toPath());
                Iterator<String> it = datos.iterator();
                while (it.hasNext()) {
                    String linea = it.next();
                    if (linea.equals("^^")) {
                        contador++;
                    } else {
                        String[] trozos = linea.split(":");
                        for (String trozo : trozos) {
                            primero = trozos[0];
                            segundo = Double.parseDouble(trozos[1]);
                        }
                    }
                    switch (contador) {
                        case 1:
                            listaPizzas.put(primero, segundo);
                            break;
                        case 2:
                            listaTamaños.put(primero, segundo);
                            break;
                        case 3:
                            listaMasas.put(primero, segundo);
                            break;
                        case 4:
                            listaIngredientes.put(primero, segundo);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (IOException ex) {
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Seleccion de archivos");
            alert.setHeaderText("Formato de archivo no válido");
            alert.setContentText("Selecciona un archivo válido");

            alert.showAndWait();
        }
    }
}


