package com.example.gestionboletas;

import com.example.gestionboletas.model.*;
import com.example.gestionboletas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioAsiento servicioAsiento;

    @Autowired
    private ServicioLugar servicioLugar;

    @Autowired
    private ServicioFuncion servicioFuncion;

    @Autowired
    private ServicioVenta servicioVenta;

    @Override
    public void run(String... args) throws Exception {
        // Inicialización de usuarios
        List<Usuario> usuarios = Arrays.asList(
                new Usuario(null, "camila", "burtica", "1002664234", 0.30),
                new Usuario(null, "pedro", "diaz", "10986324", 0.30),
                new Usuario(null, "luis", "torres", "2344224", 0.30),
                new Usuario(null, "camilo", "zuarez", "2346533", 0.30),
                new Usuario(null, "juan", "pulgarin", "23786785", 0.30),
                new Usuario(null, "carolina", "cano", "76543212", 0.30),
                new Usuario(null, "ximena", "zapata", "1082654211", 0.30),
                new Usuario(null, "jorge", "giraldo", "1056145600", 0.30),
                new Usuario(null, "lady", "medina", "10987654234", 0.30),
                new Usuario(null, "marcelo", "garcia", "1006344262", 0.30),
                new Usuario(null, "julian", "colorado", "7698200", 0.30),
                new Usuario(null, "andrea", "trujillo", "24322156", 0.30),
                new Usuario(null, "geovany", "aristizabal", "198643221", 0.30),
                new Usuario(null, "steban", "sosa", "87654234", 0.30),
                new Usuario(null, "lorena", "perez", "1006453245", 0.30),
                new Usuario(null, "dulce", "duque", "24536789", 0.30),
                new Usuario(null, "javier", "mosquena", "914323", 0.30),
                new Usuario(null, "esteban", "guzman", "4445678", 0.30),
                new Usuario(null, "sandra", "patino", "32456789", 0.30),
                new Usuario(null, "diego", "ossa", "24301567", 0.30),
                new Usuario(null, "omaira", "jaramillo", "90887532", 0.30),
                new Usuario(null, "sofia", "usma", "1092564324", 0.30),
                new Usuario(null, "gilma", "castro", "1002675432", 0.30)
        );
        for (Usuario usuario : usuarios) {
            servicioUsuario.registrarUsuario(usuario);
        }
        System.out.println("Datos de usuario inicializados.");

        // Inicialización de lugares
        List<Lugar> lugares = Arrays.asList(
                new Lugar(null, "norte barras", 85000.0),
                new Lugar(null, "occidental lateral", 55000.0),
                new Lugar(null, "occidental lateral norte", 43000.0),
                new Lugar(null, "oriental general", 105000.0),
                new Lugar(null, "palco general", 132000.0),
                new Lugar(null, "occidental general", 28000.0),
                new Lugar(null, "palco vip", 176000.0),
                new Lugar(null, "sur general", 156000.0)
        );
        for (Lugar lugar : lugares) {
            servicioLugar.guardarLugar(lugar);
        }
        System.out.println("Datos de lugar inicializados.");

        // Inicialización de funciones
        List<Funcion> funciones = Arrays.asList(
                new Funcion(null, "viernes", 0.00),
                new Funcion(null, "sabado", 0.30)
        );
        for (Funcion funcion : funciones) {
            servicioFuncion.guardarFuncion(funcion);
        }
        System.out.println("Datos de función inicializados.");


        // Inicialización de asientos
        List<Asiento> asientos = Arrays.asList(
                new Asiento("NB001", "norte barras", 85000.0),
                new Asiento("NB002", "norte barras", 85000.0),
                new Asiento("NB003", "norte barras", 85000.0),
                new Asiento("NB004", "norte barras", 85000.0),
                new Asiento("NB005", "norte barras", 85000.0),
                new Asiento("NB006", "norte barras", 85000.0),
                new Asiento("NB007", "norte barras", 85000.0),
                new Asiento("NB008", "norte barras", 85000.0),
                new Asiento("NB009", "norte barras", 85000.0),
                new Asiento("NB010", "norte barras", 85000.0),
                new Asiento("NB011", "norte barras", 85000.0),
                new Asiento("NB012", "norte barras", 85000.0),
                new Asiento("NB013", "norte barras", 85000.0),
                new Asiento("NB014", "norte barras", 85000.0),
                new Asiento("NB015", "norte barras", 85000.0),
                new Asiento("NB016", "norte barras", 85000.0),
                new Asiento("NB017", "norte barras", 85000.0),
                new Asiento("NB018", "norte barras", 85000.0),
                new Asiento("NB019", "norte barras", 85000.0),
                new Asiento("NB020", "norte barras", 85000.0),
                new Asiento("NB021", "norte barras", 85000.0),
                new Asiento("NB022", "norte barras", 85000.0),
                new Asiento("NB023", "norte barras", 85000.0),
                new Asiento("NB024", "norte barras", 85000.0),
                new Asiento("NB025", "norte barras", 85000.0),
                new Asiento("OL001", "occidental lateral", 55000.0),
                new Asiento("OL002", "occidental lateral", 55000.0),
                new Asiento("OL003", "occidental lateral", 55000.0),
                new Asiento("OL004", "occidental lateral", 55000.0),
                new Asiento("OL005", "occidental lateral", 55000.0),
                new Asiento("OL006", "occidental lateral", 55000.0),
                new Asiento("OL007", "occidental lateral", 55000.0),
                new Asiento("OL008", "occidental lateral", 55000.0),
                new Asiento("OL009", "occidental lateral", 55000.0),
                new Asiento("OL010", "occidental lateral", 55000.0),
                new Asiento("OL011", "occidental lateral", 55000.0),
                new Asiento("OL012", "occidental lateral", 55000.0),
                new Asiento("OL013", "occidental lateral", 55000.0),
                new Asiento("OL014", "occidental lateral", 55000.0),
                new Asiento("OL015", "occidental lateral", 55000.0),
                new Asiento("OL016", "occidental lateral", 55000.0),
                new Asiento("OL017", "occidental lateral", 55000.0),
                new Asiento("OL018", "occidental lateral", 55000.0),
                new Asiento("OL019", "occidental lateral", 55000.0),
                new Asiento("OL020", "occidental lateral", 55000.0),
                new Asiento("OL021", "occidental lateral", 55000.0),
                new Asiento("OL022", "occidental lateral", 55000.0),
                new Asiento("OL023", "occidental lateral", 55000.0),
                new Asiento("OL024", "occidental lateral", 55000.0),
                new Asiento("OL025", "occidental lateral", 55000.0),
                new Asiento("OLN001", "occidental lateral norte", 43000.0),
                new Asiento("OLN002", "occidental lateral norte", 43000.0),
                new Asiento("OLN003", "occidental lateral norte", 43000.0),
                new Asiento("OLN004", "occidental lateral norte", 43000.0),
                new Asiento("OLN005", "occidental lateral norte", 43000.0),
                new Asiento("OLN006", "occidental lateral norte", 43000.0),
                new Asiento("OLN007", "occidental lateral norte", 43000.0),
                new Asiento("OLN008", "occidental lateral norte", 43000.0),
                new Asiento("OLN009", "occidental lateral norte", 43000.0),
                new Asiento("OLN010", "occidental lateral norte", 43000.0),
                new Asiento("OLN011", "occidental lateral norte", 43000.0),
                new Asiento("OLN012", "occidental lateral norte", 43000.0),
                new Asiento("OLN013", "occidental lateral norte", 43000.0),
                new Asiento("OLN014", "occidental lateral norte", 43000.0),
                new Asiento("OLN015", "occidental lateral norte", 43000.0),
                new Asiento("OLN016", "occidental lateral norte", 43000.0),
                new Asiento("OLN017", "occidental lateral norte", 43000.0),
                new Asiento("OLN018", "occidental lateral norte", 43000.0),
                new Asiento("OLN019", "occidental lateral norte", 43000.0),
                new Asiento("OLN020", "occidental lateral norte", 43000.0),
                new Asiento("OLN021", "occidental lateral norte", 43000.0),
                new Asiento("OLN022", "occidental lateral norte", 43000.0),
                new Asiento("OLN023", "occidental lateral norte", 43000.0),
                new Asiento("OLN024", "occidental lateral norte", 43000.0),
                new Asiento("OLN025", "occidental lateral norte", 43000.0),
                new Asiento("OLN026", "occidental lateral norte", 43000.0),
                new Asiento("OLN027", "occidental lateral norte", 43000.0),
                new Asiento("OLN028", "occidental lateral norte", 43000.0),
                new Asiento("OLN029", "occidental lateral norte", 43000.0),
                new Asiento("OG001", "oriental general", 105000.0),
                new Asiento("OG002", "oriental general", 105000.0),
                new Asiento("OG003", "oriental general", 105000.0),
                new Asiento("OG004", "oriental general", 105000.0),
                new Asiento("OG005", "oriental general", 105000.0),
                new Asiento("OG006", "oriental general", 105000.0),
                new Asiento("OG007", "oriental general", 105000.0),
                new Asiento("OG008", "oriental general", 105000.0),
                new Asiento("OG009", "oriental general", 105000.0),
                new Asiento("OG010", "oriental general", 105000.0),
                new Asiento("OG011", "oriental general", 105000.0),
                new Asiento("OG012", "oriental general", 105000.0),
                new Asiento("OG013", "oriental general", 105000.)
        );
        for (Asiento asiento : asientos) {
            servicioAsiento.registrarAsiento(asiento);
        }
        System.out.println("Datos de asiento inicializados.");

        List<Venta> ventas = Arrays.asList(
                crearVenta("NB001", 1L, null, 85000.0),
                crearVenta("OL005", 2L, 1L, 55000.0)
                // Agrega más ventas según necesites
        );
        for (Venta venta : ventas) {
            servicioVenta.realizarVenta(venta.getAsiento().getIdAsiento(), venta.getFuncion().getId(), venta.getUsuario() != null ? venta.getUsuario().getId() : null);
        }
        System.out.println("Datos de venta inicializados.");
    }

    private Venta crearVenta(String asientoId, Long funcionId, Long usuarioId, Double precioFinal) {
        Asiento asiento = servicioAsiento.obtenerAsientoPorId(asientoId);
        Funcion funcion = servicioFuncion.obtenerFuncionPorId(funcionId);
        Usuario usuario = (usuarioId != null) ? servicioUsuario.obtenerUsuarioPorId(usuarioId) : null;
        return new Venta(null, asiento, funcion, usuario, precioFinal);
    }
}

