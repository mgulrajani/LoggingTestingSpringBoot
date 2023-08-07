package com.training.loggingtesting;

import com.training.loggingtesting.training.entities.MyMusic;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerSpec {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getAllMusicSpec(){

        ResponseEntity<List<MyMusic>> rEntity = template.exchange("/api/music",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MyMusic>>() {
                });

        List<MyMusic> resp = rEntity.getBody();
        assertEquals(HttpStatus.OK,rEntity.getStatusCode());
        assertEquals(2,resp.size());



    }

    @Test
    public void addMusicSpec() throws URISyntaxException {
        TestRestTemplate template1 = new TestRestTemplate();
      //  URI uri =  new URI("http://localhost:8080/api/music");

        MyMusic music1 = new MyMusic("music1", Arrays.asList("ARRehman"),"Indian");

        ResponseEntity<MyMusic> musicAdded = template.postForEntity("/api/music",music1, MyMusic.class);

        assertEquals("Indian",musicAdded.getBody().getGenre());



    }


}
