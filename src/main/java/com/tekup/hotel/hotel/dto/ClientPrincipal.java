package com.tekup.hotel.hotel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tekup.hotel.hotel.model.Client;
import com.tekup.hotel.hotel.model.Facture;
import com.tekup.hotel.hotel.model.Reservation;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class ClientPrincipal implements UserDetails {
	
	    private Long id;

	    private String nom;
	    
	    private String prenom;
	    
	    private String courriel;
	    
	    private String telephone;
	    
	    private LocalDate dateDeNaissance;
	    
	    private Long enfant;
	    @JsonIgnore
	    private String password;

	    private List<Reservation> reservations;
	  
	    private Facture factures;
	    private Collection<? extends GrantedAuthority> authorities;
    /*public UserPrincipal(Long id, String name, String lastName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }*/
    public ClientPrincipal(Long id, String nom, String prenom, String courriel, String telephone, LocalDate dateDeNaissance, Long enfant, String mot_de_passe, List<Reservation> reservations, Facture factures) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
        this.telephone = telephone;
        this.dateDeNaissance = dateDeNaissance;
        this.enfant = enfant;
        this.password = mot_de_passe;
        this.reservations = reservations;
        this.factures = factures;
    }
    public static ClientPrincipal create(Client l) {

        return new ClientPrincipal(
                l.getId(),
                l.getNom(),
                l.getPrenom(),
                l.getCourriel(),
                l.getTelephone(),
                l.getDateDeNaissance(),
                l.getEnfant(),
                l.getMot_de_passe(),
                l.getReservations(),
                l.getFactures()
        );
    }

    public Long getId() {
        return id;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Long getEnfant() {
		return enfant;
	}

	public void setEnfant(Long enfant) {
		this.enfant = enfant;
	}

	public String getMot_de_passe() {
		return password;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.password = mot_de_passe;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Facture getFactures() {
		return factures;
	}

	public void setFactures(Facture factures) {
		this.factures = factures;
	}



	public void setId(Long id) {
		this.id = id;
	}
	   @Override
	    public String getUsername() {
	        return courriel;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ClientPrincipal that = (ClientPrincipal) o;
	        return Objects.equals(id, that.id);
	    }

	    @Override
	    public int hashCode() {

	        return Objects.hash(id);
	    }
   
}