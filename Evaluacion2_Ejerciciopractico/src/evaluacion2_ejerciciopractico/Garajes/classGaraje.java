package evaluacion2_ejerciciopractico.Garajes;


//! Crear la classe Garaje con los atributos COMMIT OPEN#1      
public class classGaraje {
    private String departamento;
    private String ciudad;
    private String direccion;
    private int numero;
    private String email;
    private String nameAdmin;

    public classGaraje() {
    }


    //! crear constructores COMMIT OPEN#2
    public classGaraje(String departamento, String ciudad, String direccion, int numero, String email,
            String nameAdmin) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.numero = numero;
        this.email = email;
        this.nameAdmin = nameAdmin;
    }
}