package com.lance.lim.mq.kafka;

import com.lance.lim.mq.MessageSubscriber;
import com.lance.lim.mq.PubSub;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

/**
 * kafka消息订阅者
 *
 * @author Lance
 * @since 2021/4/13
 */
public class KafkaMessageSubscriber extends MessageSubscriber {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Override
    public void subscribe(PubSub pubSub, String... topics) {
//        KafkaConsumer kafkaConsumer = new KafkaConsumer(props);
//
//        kafkaConsumer.subscribe(Arrays.toList(topic));
//        while (true) {
//            ConsumerRecords records = kafkaConsumer.poll(2000L);
//            for (Iterator<ConsumerRecord> recordIterator = records.iterator(); recordIterator.hasNext(); ) {
//                ConsumerRecord record = recordIterator.next();
//                System.out.println(record);
//            }
//        }
    }
}
