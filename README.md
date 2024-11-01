# Proyecto de Gestión de Fletes

## Descripción

Este proyecto es un sistema de gestión de fletes que permite actualizar el estado de los fletes, notificar a través de RabbitMQ y realizar un seguimiento eficiente de las operaciones logísticas. El sistema está construido utilizando Java con Spring Boot y RabbitMQ para la comunicación asincrónica.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para desarrollar aplicaciones web y servicios RESTful.
- **RabbitMQ**: Sistema de mensajería utilizado para la comunicación entre servicios.
- **MySQL**: Base de datos relacional utilizada para almacenar la información de los fletes.
- **Docker**: Contenerización de la aplicación para facilitar su despliegue.

## Funcionalidades

- Actualización del estado de fletes basándose en fechas de inicio y fin.
- Notificaciones enviadas a través de RabbitMQ para el seguimiento de estados de fletes.
- Interfaz RESTful para acceder a los servicios del sistema.
- Manejo de errores y reintentos en el procesamiento de mensajes.

## Requisitos

- JDK 11 o superior
- Docker y Docker Compose
- MySQL (opcional, para desarrollo local)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/LauraSMar/PracticaJavaUTN.git
