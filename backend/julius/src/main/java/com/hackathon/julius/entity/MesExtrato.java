package com.hackathon.julius.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class MesExtrato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private LocalDate mesAno;

    @Column(nullable = false)
    private BigDecimal gastoTotal;

    @Column(nullable = false)
    private BigDecimal saldo;

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Usuario.class)
    private Usuario usuario;

    @JoinColumn(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ItemMesExtrato.class)
    private List<ItemMesExtrato> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getMesAno() {
        return mesAno;
    }

    public void setMesAno(LocalDate mesAno) {
        this.mesAno = mesAno;
    }

    public BigDecimal getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(BigDecimal gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemMesExtrato> getItems() {
        return items;
    }

    public void setItems(List<ItemMesExtrato> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("mesAno", mesAno)
                .append("gastoTotal", gastoTotal)
                .append("saldo", saldo)
                .append("usuario", usuario)
                .append("items", items)
                .toString();
    }
}
