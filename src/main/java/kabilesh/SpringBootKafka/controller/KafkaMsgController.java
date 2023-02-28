package kabilesh.SpringBootKafka.controller;

import kabilesh.SpringBootKafka.service.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaMsgController {
    private KafkaProducer kafkaProducer;

    private KafkaMsgController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("Message") String msg) {
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
