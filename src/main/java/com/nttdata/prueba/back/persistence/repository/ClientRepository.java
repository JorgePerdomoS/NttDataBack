package com.nttdata.prueba.back.persistence.repository;

import com.nttdata.prueba.back.persistence.entity.ClientEntity;
import com.nttdata.prueba.back.util.enums.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

    Optional<ClientEntity> findByDocumentTypeAndIdentificationNumber(DocumentType documentType, String identificationNumber);
}
