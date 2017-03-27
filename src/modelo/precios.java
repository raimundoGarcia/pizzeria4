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
        listaPizzas.put("margarita", 5.80);
        listaPizzas.put("estaciones", 7.0);
        listaPizzas.put("BBQ", 8.0);
        listaPizzas.put("boloñesa", 8.0);
        listaPizzas.put("quesos", 7.5);
        listaPizzas.put("empresa", 8.5);
        listaPizzas.put("marinera", 9.0);
        listaPizzas.put("proscuto", 6.5);
        listaMasas.put("normal", 0.5);
        listaMasas.put("fina", 1.0);
        listaMasas.put("integral", 1.5);
        listaMasas.put("rellena", 2.5);
        listaIngredientes.put("jamon", 1.00);
        listaIngredientes.put("cebolla", 0.50);
        listaIngredientes.put("pollo", 1.50);
        listaIngredientes.put("BBQ", 0.70);
        listaIngredientes.put("aceitunas", 0.80);
        listaIngredientes.put("carnePicada", 1.50);
        listaIngredientes.put("tomateNatural", 0.50);
        listaIngredientes.put("queso", 1.00);
        listaDescripcion.put("margarita", "Margarita (Salsa de tomate y mozzarella)");
        listaDescripcion.put("estaciones", "3 Estaciones (Tomate, mozzarella, alcachofas, aceitunas, jamón, champiñon)");
        listaDescripcion.put("BBQ", "BBQ (Tomate, mozzarella, BBQ, pollo, carne picada, bacon)");
        listaDescripcion.put("boloñesa", "Bolognesa (Tomate,Mozzarella, Salsa Bolognesa, Carne Picada)");
        listaDescripcion.put("quesos", "4 Quesos (tomate, mozzarella, parmesano, queso azul, rulo de cabra)");
        listaDescripcion.put("empresa", "Fattore (Tomate, mozzarella, jamón serrano, mozzarella di buffala, rucula)");
        listaDescripcion.put("marinera", "Marinera (Salsa marinera, mozzarella, mejillones, gambas, calamares)");
        listaDescripcion.put("proscuto", "Prosciutto (Tomate, mozzarella, prosciutto (jamón cocido");
        listaTamaños.put("infantil", 0.5);
        listaTamaños.put("pequeña", 1.0);
        listaTamaños.put("mediana", 1.3);
        listaTamaños.put("familiar", 1.7);

    }
}
