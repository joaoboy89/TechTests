/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestE2eTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetTarifaCase1() {
        executeAndVerifyCase("2020-06-14 10:00:00", 35455L, 1L, 1);
    }

    @Test
    public void shouldGetTarifaCase2() {
        executeAndVerifyCase("2020-06-14 16:00:00", 35455L, 1L, 2);
    }

    @Test
    public void shouldGetTarifaCase3() {
        executeAndVerifyCase("2020-06-14 21:00:00", 35455L, 1L, 3);
    }

    @Test
    public void shouldGetTarifaCase4() {
        executeAndVerifyCase("2020-06-15 10:00:00", 35455L, 1L, 4);
    }

    @Test
    public void shouldGetTarifaCase5() {
        executeAndVerifyCase("2020-06-15 21:00:00", 35455L, 1L, 5);
    }

    private void executeAndVerifyCase(String fecha, Long idProducto, Long idCadena, int caso) {
        Map<String, Object> params = new HashMap<>();
        params.put("fecha", fecha);
        params.put("idProducto", idProducto);
        params.put("idCadena", idCadena);

        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?fecha={fecha}&idProducto={idProducto}&idCadena={idCadena}",
                String.class, params);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println("Resultados JSON para el caso " + caso + ": " + response.getBody());
        
    }
}