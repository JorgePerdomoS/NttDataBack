package com.nttdata.prueba.back.service.impl;

import com.nttdata.prueba.back.dto.ClientDTO;
import com.nttdata.prueba.back.persistence.entity.ClientEntity;
import com.nttdata.prueba.back.persistence.repository.ClientRepository;
import com.nttdata.prueba.back.service.ClientService;
import com.nttdata.prueba.back.util.enums.DocumentType;
import com.nttdata.prueba.back.util.exceptions.NoDataFountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO getClientInformation(String identificationType, String number) throws NoDataFountException {

       DocumentType documentTypeEnum = DocumentType.valueOf(identificationType.toUpperCase());

       ClientEntity clientEntity = clientRepository.
               findByDocumentTypeAndIdentificationNumber(documentTypeEnum, number).orElse(null);

        if (clientEntity != null) {
            return getClientDTO(clientEntity);
        } else {
            throw new NoDataFountException("Client doesn't exist in db.");
        }
    }

    private static ClientDTO getClientDTO(ClientEntity clientEntity) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setFirstName(clientEntity.getFirstName());
        clientDTO.setSecondName(clientEntity.getSecondName());
        clientDTO.setFirstLastName(clientEntity.getFirstLastName());
        clientDTO.setSecondLastName(clientEntity.getSecondLastName());
        clientDTO.setPhoneNumber(clientEntity.getPhoneNumber());
        clientDTO.setAddress(clientEntity.getAddress());
        clientDTO.setCityOfResidence(clientEntity.getCityOfResidence());
        return clientDTO;
    }
}
