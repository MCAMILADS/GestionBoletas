package com.example.gestionboletas.service;

import com.example.gestionboletas.model.Asiento;
import com.example.gestionboletas.model.Funcion;
import com.example.gestionboletas.model.Usuario;
import com.example.gestionboletas.model.Venta;
import com.example.gestionboletas.repository.AsientoRepositorio;
import com.example.gestionboletas.repository.FuncionRepositorio;
import com.example.gestionboletas.repository.UsuarioRepositorio;
import com.example.gestionboletas.repository.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioVentaImpl implements ServicioVenta {

    @Autowired
    private AsientoRepositorio asientoRepositorio;

    @Autowired
    private FuncionRepositorio funcionRepositorio;

    @Autowired(required = false) // El usuario no siempre estará presente
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Autowired
    private ServicioCentralizado servicioCentralizado;

    @Transactional
    @Override
    public Venta realizarVenta(String idAsiento, Long idFuncion, Long idUsuario) {
        Asiento asiento = asientoRepositorio.findById(idAsiento).orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        Funcion funcion = funcionRepositorio.findById(idFuncion).orElseThrow(() -> new RuntimeException("Función no encontrada"));
        Usuario usuario = (idUsuario != null) ? usuarioRepositorio.findById(idUsuario).orElse(null) : null;

        // Validar disponibilidad con el sistema centralizado
        servicioCentralizado.validarDisponibilidadAsiento(asiento.getIdAsiento(), funcion.getId());

        // Calcular el precio final
        Double precioFinal = calcularPrecioFinal(asiento, funcion, usuario);

        // Crear la venta
        Venta venta = new Venta();
        venta.setAsiento(asiento);
        venta.setFuncion(funcion);
        venta.setUsuario(usuario);
        venta.setPrecioFinal(precioFinal);
        Venta ventaGuardada = ventaRepositorio.save(venta);


        asiento.setEstado(asiento.getEstado().VENDIDO);
        asientoRepositorio.save(asiento);

        servicioCentralizado.enviarInformacionVenta(ventaGuardada);

        return ventaGuardada;
    }

    @Override
    public Venta obtenerVentaPorId(Long idVenta) {
        return ventaRepositorio.findById(idVenta).orElse(null);
    }

    private Double calcularPrecioFinal(Asiento asiento, Funcion funcion, Usuario usuario) {
        Double precioBase = asiento.getLugar().getPrecio(); // Usamos el precio del lugar asociado al asiento
        Double precioFinal = precioBase;

        if (funcion.getDia().equalsIgnoreCase("Segundo día") && !asiento.getLugar().getNombre().equalsIgnoreCase("VIP")) {
            if (funcion.getDescuentoSegundoDia() != null) {
                precioFinal -= precioBase * funcion.getDescuentoSegundoDia();
            }
        }

        if (usuario != null && usuario.getDescuento() != null) {
            precioFinal -= precioFinal * usuario.getDescuento();
        }

        return precioFinal;
    }
}