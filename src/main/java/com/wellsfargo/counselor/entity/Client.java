package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "advisorId", nullable = false)
    private Advisor advisor;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios = new ArrayList<>();

    // No-arg constructor required by JPA
    public Client() {}

    // All-args constructor (initializes all instance variables)
    public Client(long clientId, Advisor advisor, String firstName, String lastName,
                  String address, String phone, String email, List<Portfolio> portfolios) {
        this.clientId = clientId;
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.portfolios = portfolios == null ? new ArrayList<>() : portfolios;
    }

    // Getters and setters
    public long getClientId() { return clientId; }
    public void setClientId(long clientId) { this.clientId = clientId; }

    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios == null ? new ArrayList<>() : portfolios;
    }
}
