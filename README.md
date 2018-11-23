# SSLSpringbootKafkaProducer


# Kafka

https://kafka.apache.org/quickstart


# Iniciar zookeeper

bin/zookeeper-server-start.sh config/zookeeper.properties


# Iniciar kafka

bin/kafka-server-start.sh config/server.properties


# Crear un tópico (test)

bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test


# Listar los topicos existentes en el servidor

bin/kafka-topics.sh --list --zookeeper localhost:2181


# Ver los mensajes entrarntes al servidoe

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
