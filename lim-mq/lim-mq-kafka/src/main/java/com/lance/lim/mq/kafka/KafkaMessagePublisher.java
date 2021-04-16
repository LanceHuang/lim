package com.lance.lim.mq.kafka;

import com.lance.lim.common.util.JsonUtils;
import com.lance.lim.mq.MessagePublisher;
import com.lance.lim.mq.model.Message;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * kafka消息发布者
 *
 * @author Lance
 * @since 2021/4/13
 */
public class KafkaMessagePublisher extends MessagePublisher {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public void publish(String topic, String key, Message message) {
        ProducerRecord record = new ProducerRecord<>(topic, key, JsonUtils.object2json(message));
        kafkaProducer.send(record);
    }
}
