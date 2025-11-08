package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Column(nullable = false)
    private LocalDate creationDate;

    // If you plan to add Security entity next, keep this list; otherwise it's harmless for now.
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities = new ArrayList<>();

    // No-arg constructor for JPA
    public Portfolio() {}

    // All-args constructor
    public Portfolio(long portfolioId, Client client, LocalDate creationDate, List<Security> securities) {
        this.portfolioId = portfolioId;
        this.client = client;
        this.creationDate = creationDate;
        this.securities = securities == null ? new ArrayList<>() : securities;
    }

    // Getters and setters
    public long getPortfolioId() { return portfolioId; }
    public void setPortfolioId(long portfolioId) { this.portfolioId = portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) {
        this.securities = securities == null ? new ArrayList<>() : securities;
    }
}
