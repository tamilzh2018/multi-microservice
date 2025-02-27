const { Kafka } = require('kafkajs');
//const kafka = new Kafka({ clientId: 'my-app', brokers: ['localhost:9092'] });
const kafka = new Kafka({ clientId: 'my-app', brokers: ['kafka:9092'] });
const producer = kafka.producer();

const run = async () => {
    await producer.connect();
    await producer.send({ topic: 'test-topic', messages: [{ value: 'Hello Kafka!' }] });
    await producer.disconnect();
};

run().catch(console.error);
