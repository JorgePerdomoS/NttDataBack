package com.nttdata.prueba.back.service;

import com.nttdata.prueba.back.dto.ClientDTO;
import com.nttdata.prueba.back.util.exceptions.NoDataFountException;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    ClientDTO getClientInformation(String identificationType, String number) throws NoDataFountException;
}
