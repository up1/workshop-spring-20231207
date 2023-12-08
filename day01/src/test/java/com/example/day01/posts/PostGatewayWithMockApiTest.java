package com.example.day01.posts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class PostGatewayWithMockApiTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    void getById() throws IOException {
        stubFor(get(urlPathEqualTo("/posts/1"))
                .willReturn(aResponse()
                        .withBody(read("classpath:postApiResponse.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)));

        Optional<PostResponse> result = postGateway.getById(1);
        assertTrue(result.isPresent());
        assertEquals(11, result.get().getId());
        assertEquals(11, result.get().getUserId());
        assertEquals("Test Title", result.get().getTitle());
    }

    private static String read(String filePath) throws IOException {
        File file = ResourceUtils.getFile(filePath);
        return new String(Files.readAllBytes(file.toPath()));
    }
}