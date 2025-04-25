package com.nttdata.prueba.back.controller;

import com.nttdata.prueba.back.dto.ClientDTO;
import com.nttdata.prueba.back.service.ClientService;
import com.nttdata.prueba.back.util.enums.DocumentType;
import com.nttdata.prueba.back.util.exceptions.NoDataFountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@Slf4j
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/getInfo")
    public ResponseEntity<ClientDTO> getClientInfo(@RequestParam  String identificationType, @RequestParam String number) {

        try {
            log.info("Execute getClientInfo with identificationType: {} and number: {}", identificationType, number);

            if (identificationType.equalsIgnoreCase(DocumentType.C.toString()) ||
                   identificationType.equalsIgnoreCase(DocumentType.P.toString())) {
                ClientDTO response = clientService.getClientInformation(identificationType, number);
                return ResponseEntity.ok(response);
            } else {
                log.error("Invalid identification type");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }catch (NoDataFountException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
