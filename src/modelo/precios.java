package modelo;

import java.util.HashMap;
import java.util.Map;

public class precios {

    private Map<String, Double> listaPizzas = new HashMap<>();
    private Map<String, Double> listaMasas = new HashMap<>();
    private Map<String, Double> listaIngredientes = new HashMap<>();
    private Map<String, String> listaDescripcion = new HashMap<>();
    private Map<String, Double> listaTamaños = new HashMap<>();

    public precios() {
        cargarListas();
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

    private void cargarListas() {
        listaPizzas.put("Margarita", 5.80);
        listaPizzas.put("3 Estaciones", 7.0);
        listaPizzas.put("BBQ", 8.0);
        listaPizzas.put("Bolognesa", 8.0);
        listaPizzas.put("4 Quesos", 7.5);
        listaPizzas.put("Fattore", 8.5);
        listaPizzas.put("Marinera", 9.0);
        listaPizzas.put("Prosciutto", 6.5);
        listaMasas.put("normal", 0.5);
        listaMasas.put("fina", 1.0);
        listaMasas.put("integral", 1.5);
        listaMasas.put("rellena", 2.5);
        listaIngredientes.put("Jamón york", 1.00);
        listaIngredientes.put("Cebolla", 0.50);
        listaIngredientes.put("Pollo", 1.50);
        listaIngredientes.put("Salsa barbacoa", 0.70);
        listaIngredientes.put("Aceitunas", 0.80);
        listaIngredientes.put("Carne picada", 1.50);
        listaIngredientes.put("Tomate natural", 0.50);
        listaIngredientes.put("Mozzarella", 1.00);
        listaDescripcion.put("Margarita","Margarita (Salsa de tomate y mozzarella)                                  ");
        listaDescripcion.put("3 Estaciones","3 Estaciones (Tomate, mozzarella, alcachofas, aceitunas, jamón, champiñon)");
        listaDescripcion.put("BBQ","BBQ (Tomate, mozzarella, salsa barbacoa, pollo, carne picada, bacon)      ");
        listaDescripcion.put("Bolognesa","Bolognesa (Tomate,Mozzarella, salsa bolognesa, Carne Picada)              ");
        listaDescripcion.put("4 Quesos","4 Quesos (tomate, mozzarella, parmesano, queso azul, rulo de cabra)       ");
        listaDescripcion.put("Fattore","Fattore (Tomate, mozzarella, jamón serrano, mozzarella di buffala, rucula)");
        listaDescripcion.put("Marinera","Marinera (Salsa marinera, mozzarella, mejillones, gambas, calamares)      ");
        listaDescripcion.put("Prosciutto","Prosciutto (Tomate, mozzarella, prosciutto, jamón cocido)                 ");
        listaTamaños.put("infantil", 0.5);
        listaTamaños.put("pequeña", 1.0);
        listaTamaños.put("mediana", 1.3);
        listaTamaños.put("familiar", 1.7);

    }
}

