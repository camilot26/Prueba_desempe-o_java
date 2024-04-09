package entity;

public class Coder {
    private int id_coder;
    private String nombre;
    private String apellidos;
    private String documento;
    private String clan;
    private int cohorte;
    private String cv;
   private String tecnologia_coder;
    public Coder(int id_coder, String nombre, String apellidos, String documento, String clan, int cohorte, String cv, String tecnologia_coder) {
        this.id_coder = id_coder;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.clan = clan;
        this.cohorte = cohorte;
        this.cv = cv;
        this.tecnologia_coder = tecnologia_coder;
    }
    public Coder(){



    }

    public String getTecnologia_coder() {
        return tecnologia_coder;
    }

    public void setTecnologia_coder(String tecnologia_coder) {
        this.tecnologia_coder = tecnologia_coder;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getCohorte() {
        return cohorte;
    }

    public void setCohorte(int cohorte) {
        this.cohorte = cohorte;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return "Coder{" +
                "id_coder=" + id_coder +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", documento='" + documento + '\'' +
                ", clan='" + clan + '\'' +
                ", cohorte=" + cohorte +
                ", cv='" + cv + '\'' +
                ", tecnologia_coder='" + tecnologia_coder + '\'' +
                '}';
    }
}
