package modelo;

import java.util.ArrayList;
import java.util.List;

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
    public double precioTotalIngredientes(){
        double total=0;
        for (int i = 0; i < ingredientes.size(); i++) {
           total += precio.getPrecioIngrediente(ingredientes.get(i));
        }
        return total;
    }
    public double calcularPrecio(){
        double totalfinal;
         totalfinal = (precio.getPrecioTipoPizza(tipo) + precio.getPrecioMasa(masa) + precioTotalIngredientes()) * precio.getPrecioTamaño(tamaño);
         return totalfinal;
    }

}
