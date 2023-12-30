/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appweb.clothes;

import com.appweb.clothes.dto.ClothesDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
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
    public void shouldGetTarifaCase1() throws ParseException {
        ClothesDTO expected = createExpectedDTOCase1();
        ClothesDTO result = executeAndVerifyCase("2020-06-14 10:00:00", 35455L, 1L);
        assertThat(result).isEqualTo(expected);
    }
    private ClothesDTO createExpectedDTOCase1() throws ParseException {
                return new ClothesDTO(
                35455L,
                1L,
                0,
                parseDate("2020-06-14 00:00:00"),
                parseDate("2020-12-31 23:59:59"),
                35.5
                );
        }  

    @Test
    public void shouldGetTarifaCase2() throws ParseException{
        ClothesDTO expected = createExpectedDTOCase2();
        ClothesDTO result = executeAndVerifyCase("2020-06-14 16:00:00", 35455L, 1L);
         assertThat(result).isEqualTo(expected); 
    }
    private ClothesDTO createExpectedDTOCase2() throws ParseException {
                return new ClothesDTO(
                35455L,
                1L,
                1,
                parseDate("2020-06-14 15:00:00"),
                parseDate("2020-06-14 18:30:00"),
                25.45
                );
        }  

    @Test
    public void shouldGetTarifaCase3() throws ParseException {
        ClothesDTO expected = createExpectedDTOCase3();
        ClothesDTO result = executeAndVerifyCase("2020-06-14 21:00:00", 35455L, 1L);
          assertThat(result).isEqualTo(expected);
    }
    private ClothesDTO createExpectedDTOCase3() throws ParseException {
                return new ClothesDTO(
                35455L,
                1L,
                0,
                parseDate("2020-06-14 00:00:00"),
                parseDate("2020-12-31 23:59:59"),
                35.5
                );
        }  
    @Test
    public void shouldGetTarifaCase4() throws ParseException{
        ClothesDTO expected = createExpectedDTOCase4();
        ClothesDTO result = executeAndVerifyCase("2020-06-15 10:00:00", 35455L, 1L);
        assertThat(result).isEqualTo(expected);
    }
    private ClothesDTO createExpectedDTOCase4() throws ParseException {
                return new ClothesDTO(
                35455L,
                1L,
                1,
                parseDate("2020-06-15 00:00:00"),
                parseDate("2020-06-15 11:00:00"),
                30.5
                );
        }  
    @Test
    public void shouldGetTarifaCase5() throws ParseException {
        ClothesDTO expected = createExpectedDTOCase5();
        ClothesDTO result = executeAndVerifyCase("2020-06-15 21:00:00", 35455L, 1L);
        assertThat(result).isEqualTo(expected);
    }
    private ClothesDTO createExpectedDTOCase5() throws ParseException {
                return new ClothesDTO(
                35455L,
                1L,
                1,
                parseDate("2020-06-15 16:00:00"),
                parseDate("2020-12-31 23:59:59"),
                38.95
                );
        }  
    

    private ClothesDTO executeAndVerifyCase(String date, Long idProduct, Long idBrand) {
        Map<String, Object> params = new HashMap<>();
        params.put("date", date);
        params.put("idProduct", idProduct);
        params.put("idBrand", idBrand);

        ResponseEntity<ClothesDTO> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/prices?date={date}&idProduct={idProduct}&idBrand={idBrand}",
                ClothesDTO.class, params);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println("Resultados JSON para el caso " + ": " + response.getBody());
        return response.getBody();
    }
    
    private Date parseDate(String dateString) throws ParseException{
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return dateFormat.parse(dateString);
    }
    
}