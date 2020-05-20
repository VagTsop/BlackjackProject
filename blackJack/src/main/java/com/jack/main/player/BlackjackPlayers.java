/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jack.main.player;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vatso
 */
@Entity
@Table(name = "blackjack_players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlackjackPlayers.findAll", query = "SELECT b FROM BlackjackPlayers b"),
    @NamedQuery(name = "BlackjackPlayers.findByPlayerId", query = "SELECT b FROM BlackjackPlayers b WHERE b.playerId = :playerId"),
    @NamedQuery(name = "BlackjackPlayers.findByFirstname", query = "SELECT b FROM BlackjackPlayers b WHERE b.firstname = :firstname"),
    @NamedQuery(name = "BlackjackPlayers.findByLastname", query = "SELECT b FROM BlackjackPlayers b WHERE b.lastname = :lastname"),
    @NamedQuery(name = "BlackjackPlayers.findByUsername", query = "SELECT b FROM BlackjackPlayers b WHERE b.username = :username"),
    @NamedQuery(name = "BlackjackPlayers.findByEmail", query = "SELECT b FROM BlackjackPlayers b WHERE b.email = :email"),
    @NamedQuery(name = "BlackjackPlayers.findByPassword", query = "SELECT b FROM BlackjackPlayers b WHERE b.password = :password"),
    @NamedQuery(name = "BlackjackPlayers.findByProfilePhotoName", query = "SELECT b FROM BlackjackPlayers b WHERE b.profilePhotoName = :profilePhotoName"),
    @NamedQuery(name = "BlackjackPlayers.findByBalance", query = "SELECT b FROM BlackjackPlayers b WHERE b.balance = :balance"),
    @NamedQuery(name = "BlackjackPlayers.findByActive", query = "SELECT b FROM BlackjackPlayers b WHERE b.active = :active")})
public class BlackjackPlayers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "player_id")
    private Integer playerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "profile_photo_name")
    private String profilePhotoName;
    @Lob
    
    @Column(name = "profile_photo_data")
    private byte[] profilePhotoData;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private BigDecimal balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleId;

    public BlackjackPlayers() {
    }

    public BlackjackPlayers(Integer playerId) {
        this.playerId = playerId;
    }

    public BlackjackPlayers(Integer playerId, String firstname, String lastname, String username, String email, String password, boolean active) {
        this.playerId = playerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhotoName() {
        return profilePhotoName;
    }

    public void setProfilePhotoName(String profilePhotoName) {
        this.profilePhotoName = profilePhotoName;
    }

    public byte[] getProfilePhotoData() {
        return profilePhotoData;
    }

    public void setProfilePhotoData(byte[] profilePhotoData) {
        this.profilePhotoData = profilePhotoData;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerId != null ? playerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlackjackPlayers)) {
            return false;
        }
        BlackjackPlayers other = (BlackjackPlayers) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jack.main.player.BlackjackPlayers[ playerId=" + playerId + " ]";
    }
    
}
