package kr.or.ddit.lectureContents.videoLecture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
public class VideoController {
	
    @GetMapping(path = "/video")
    public ResponseEntity<StreamingResponseBody> video(String cours) {
        File file = new File(cours);
        if (!file.isFile()) {
            return ResponseEntity.notFound().build();
        }

        StreamingResponseBody streamingResponseBody = new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
            	try (InputStream inputStream = new FileInputStream(file)) {
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = inputStream.read(bytes)) >= 0) {
                        outputStream.write(bytes, 0, length);
                    }
                    outputStream.flush();
                } catch (IOException e) {
                	throw new RuntimeException(e);
                }
            }
        };

        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "video/mp4");
        responseHeaders.add("Content-Length", Long.toString(file.length()));

        return ResponseEntity.ok().headers(responseHeaders).body(streamingResponseBody);
    }

}