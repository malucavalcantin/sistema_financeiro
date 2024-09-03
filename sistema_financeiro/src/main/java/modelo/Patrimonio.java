import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patrimonios")
public class Patrimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Construtores
    public Patrimonio() {}

    public Patrimonio(String categoria, double valor, Date data, String descricao, Usuario usuario) {
        this.categoria = categoria;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
