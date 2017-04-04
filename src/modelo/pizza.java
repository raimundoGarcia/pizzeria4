package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class pizza {

    private String masa;
    private String tamaño;
    private String tipo;
    private List<String> ingredientes = new ArrayList<>();
    private precios precio = new precios();

    public pizza(String masa, String tamaño, String tipo) {
        this.masa = masa;
        this.tamaño = tamaño;
        this.tipo = tipo;

    }

    public pizza() {
    }

    public double precioTipoPizza() {
        return precio.getPrecioTipoPizza(this.tipo);
    }

    public String descripcionPizza() {
        return precio.getDescripcionPizza(this.tipo);
    }

    public double precioTipoMasa() {
        return precio.getPrecioMasa(this.masa);
    }

    public double precioTipoTamaño() {
        return precio.getPrecioTamaño(this.tamaño);
    }

    public precios getPrecio() {
        return precio;
    }

    public void setPrecio(precios precio) {
        this.precio = precio;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void limpiarListaIngredientes() {
        ingredientes.clear();
    }

    public void añadirIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public String mostrarPrecioIngredientes() {
        String precios = "";
        String simple;

        for (int i = 0; i < ingredientes.size(); i++) {
            simple = ingredientes.get(i);
            precios += precio.getPrecioIngrediente(simple) + "€\n";

        }
        return precios;
    }

    public String pedido() {//bajo construcción
        String pedido, ingrediente;

        pedido = String.format("%-80s %-5.2f", descripcionPizza(), precioTipoPizza()) + "€\n"
                + String.format("Masa: %-110s %-4.2f", masa, precioTipoMasa()) + "€\n";

        for (int i = 0; i < ingredientes.size(); i++) {
            ingrediente = ingredientes.get(i);
            pedido += String.format("%-80s %-5.2f", ingrediente, precio.getPrecioIngrediente(ingrediente)) + "€\n";
        }
        pedido += String.format("%-110s X %-4.2f", tamaño, precio.getPrecioTamaño(tamaño)) + "\n";
        return pedido;
    }

    public double precioTotalIngredientes() {
        double total = 0;
        for (int i = 0; i < ingredientes.size(); i++) {
            total += precio.getPrecioIngrediente(ingredientes.get(i));
        }
        return total;
    }

    public double calcularPrecio() {
        double totalfinal;
        totalfinal = (precio.getPrecioTipoPizza(tipo) + precio.getPrecioMasa(masa) + precioTotalIngredientes()) * precio.getPrecioTamaño(tamaño);
        return totalfinal;
    }

    private Path rutaGuardado() {
        Path ruta = null;
        Stage stage = new Stage();
        DirectoryChooser fileChooser = new DirectoryChooser();
        fileChooser.setTitle("Guardar ticket en: ");
        File archivo = fileChooser.showDialog(stage);
        if (archivo != null) {
            File pathArchivo = new File(archivo.getAbsolutePath());
            ruta = pathArchivo.toPath();
        }
        return ruta;
    }

    public void generarTicket() {
//        File nuevos;
//        try {
//            nuevos = new File(rutaGuardado() + "\\" + fechaTicket() + ".txt");
//            if (!nuevos.exists()) {
//                nuevos.createNewFile();
//            }
//        } catch (IOException ex) {
//        }
            Path fichero = Paths.get(rutaGuardado() + "\\" + fechaTicket() + ".txt");
            try (BufferedWriter bw = Files.newBufferedWriter(fichero, StandardOpenOption.CREATE)) {

                bw.write(pedido());

            } catch (IOException ex2) {

            }
        }
    

    public String fechaTicket() {
        String fecha;
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd-MM-yyyy--hh-mm-ss");
        fecha = patron.format(ahora);
        return fecha;
    }
}
