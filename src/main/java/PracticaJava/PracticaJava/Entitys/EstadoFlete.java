package PracticaJava.PracticaJava.Entitys;

public enum EstadoFlete {
    ACTIVO,
    PENDIENTE,
    EN_HORARIO,
    DEMORADO;
    public String obtenerDescripcion() {
        switch (this) {
            case ACTIVO: return "Flete está activo";
            case PENDIENTE: return "Flete está pendiente";
            case EN_HORARIO: return "Flete en horario";
            case DEMORADO: return "Flete demorado";
            default: return "Estado desconocido";
        }
    }
}

