# Prueba Cibernos

La prueba contempla consumir dos apis, las cuales obtienen registros de productos similares, según id recibido por esta APP


## Installation

Construir una imagen a partir del Dockerfile

```bash
  docker build -t cibernos . -f cibernos/Dockerfile
```
Correr un contenedor a partir de la imagen generada: 
```bash
    docker run -d -p 5000:5000 cibernos 
```


## Authors

- [@Duquemon](https://github.com/Duquemon)
