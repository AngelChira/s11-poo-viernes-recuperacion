package Negocio;

import Modelo.Producto;
import java.util.ArrayList;

public class ProductoNegocio {

    ArrayList<Producto> listaProducto = new ArrayList<>();


    public boolean agregarProducto(Producto producto) {
        if (listaProducto.isEmpty()) {
            listaProducto.add(producto);
            return true;
        } else {
            for (int i = 0; i < listaProducto.size(); i++) {
                if (listaProducto.get(i).getCodigo().equalsIgnoreCase(producto.getCodigo())) {
                    return false;
                }
            }
            listaProducto.add(producto);
            return true;
        }
    }

    public boolean modificarProducto(Producto producto) {
        boolean m = false;
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigo().equalsIgnoreCase(producto.getCodigo())) {
                listaProducto.get(i).setNombre(producto.getNombre());
                listaProducto.get(i).setPrecio(producto.getPrecio());
                listaProducto.get(i).setStock(producto.getStock());
                m = true;
            }
        }
        return m;
    }

    public boolean eliminarProducto(String codigo) {
        boolean m = false;
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaProducto.remove(i);
                m = true;
            }
        }
        return m;
    }
    
    public String mostrarInformacion() {
        String r = "";
        for (int i = 0; i < listaProducto.size(); i++) {
            r = r +  listaProducto.get(i).toString();
        }
        return r;
    }
    
    public String buscarProducto(String codigo) {
        String r = "";
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                r = r +  listaProducto.get(i).toString();
                return r;
            }
        }
        return r;
    }
}
