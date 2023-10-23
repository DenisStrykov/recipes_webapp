<p align="center">
      <img src="https://i.ibb.co/Cmhcc1T/view-gif.gif">
</p>

## About Prescriber

**Prescriber** is a simple web application for storing, creating and familiarizing yourself with recipes and events
related to them

## Documentation

Documentation for **Prescriber** project.

#### Technology Stack

The following technologies were utilized in this project:

- `Spring-Boot`
- `Spring-Security`
- `Hibernate`
- `Lombok`
- `Thymeleaf`
- `Tomcat`
- `HTML`
- `Bootstrap`
- `Docker`
- `Docker-compose`
- `Apache Maven`
- `PostgreSQL`

#### To run the project in your own environment:

Please use Ubuntu 22.04... to run the project, to avoid possible complications with file execution rights to prefill
database tables

Execute the following commands to start the test run:

```shell
wget https://raw.githubusercontent.com/DenisStrykov/recipes_webapp/main/start.sh
chmod u+x start.sh
sh start.sh
```

After starting the containers in docker, follow the link: "http://localhost:8091/recipes"

For a test run use:
- `user: "admin"`
- `password: "admin"`

To stop the application, remove downloaded packages, and clean up docker, use the following command in the directory you
are in now:

```shell
wget https://raw.githubusercontent.com/DenisStrykov/recipes_webapp/main/stop.sh
chmod u+x start.sh
sh stop.sh
```

#### Data structure:

<p align="center">
      <img src="https://i.ibb.co/HVbnSYb/image.png">
</p>




