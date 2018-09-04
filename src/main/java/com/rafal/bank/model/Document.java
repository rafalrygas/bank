package com.rafal.bank.model;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_documents",
        uniqueConstraints = @UniqueConstraint(
                columnNames = { "documentNumber", "username" }))
public class Document {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "documentId",
            unique = true, nullable = false)
    private Integer documentId;
    @Column(name = "documentNumber", unique = true, nullable = false)
    private String DocumentNumber;
    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
    @Column(name = "documentType", nullable = false)
    private String documentType;
    @Column(name = "documentRelaseDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date documentRelaseDate;
    @Column(name = "documentExpirationDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date documentExpirationDate;

    public Document() {
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getGetDocumentNumber() {
        return DocumentNumber;
    }

    public void setGetDocumentNumber(String getDocumentNumber) {
        this.DocumentNumber = getDocumentNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Date getDocumentRelaseDate() {
        return documentRelaseDate;
    }

    public void setDocumentRelaseDate(Date documentRelaseDate) {
        this.documentRelaseDate = documentRelaseDate;
    }

    public Date getDocumentExpirationDate() {
        return documentExpirationDate;
    }

    public void setDocumentExpirationDate(Date documentExpirationDate) {
        this.documentExpirationDate = documentExpirationDate;
    }
}
