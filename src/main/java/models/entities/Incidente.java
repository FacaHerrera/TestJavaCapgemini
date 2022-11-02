package models.entities;

import java.time.LocalDate;
import java.util.List;

public class Incidente {
    private LocalDate fechaInicio;
    private LocalDate fechaEstimadaResolucion;
    private LocalDate fechaRealResolucion;
    private List<Estado> historialEstados;
    private Estado estadoActual;
    private List<Problema> problemas;
    private Cliente cliente;
    private String consideraciones;
    private Servicio servicio;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEstimadaResolucion() {
        return fechaEstimadaResolucion;
    }

    public void setFechaEstimadaResolucion(LocalDate fechaEstimadaResolucion) {
        this.fechaEstimadaResolucion = fechaEstimadaResolucion;
    }

    public LocalDate getFechaRealResolucion() {
        return fechaRealResolucion;
    }

    public void setFechaRealResolucion(LocalDate fechaRealResolucion) {
        this.fechaRealResolucion = fechaRealResolucion;
    }

    public List<Estado> getHistorialEstados() {
        return historialEstados;
    }

    public void setHistorialEstados(List<Estado> historialEstados) {
        this.historialEstados = historialEstados;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getConsideraciones() {
        return consideraciones;
    }

    public void setConsideraciones(String consideraciones) {
        this.consideraciones = consideraciones;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
