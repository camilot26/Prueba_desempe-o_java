package entity;

public class RelacionContratacion

{
    private int id_contratacion;
    private int id_vacante;
    private int id_coder;
    private String nombre;
    private String apellidos;
    private Double salario;
    private String titulo;
    private String descripcion;
    private String nombre_empresa;
    private String ubicacion;


    public RelacionContratacion(int id_contratacion, int id_vacante, int id_coder, String nombre, String apellidos, Double salario, String titulo, String descripcion, String nombre_empresa, String ubicacion) {
        this.id_contratacion = id_contratacion;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombre_empresa = nombre_empresa;
        this.ubicacion = ubicacion;
    }
    public RelacionContratacion(){


    }

    public int getId_contratacion() {
        return id_contratacion;
    }

    public void setId_contratacion(int id_contratacion) {
        this.id_contratacion = id_contratacion;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public int getId_coder() {
        return id_coder;
    }

    public void setId_coder(int id_coder) {
        this.id_coder = id_coder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    @Override
    public String toString() {
        return "RelacionContratacion{" +
                "id_contratacion=" + id_contratacion +
                ", id_vacante=" + id_vacante +
                ", id_coder=" + id_coder +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", salario=" + salario +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nombre_empresa='" + nombre_empresa + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
