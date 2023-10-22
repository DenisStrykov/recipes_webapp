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
- `HTML`
- `Bootstrap`
- `Docker`
- `Docker-compose`
- `Apache Maven`
- `PostgreSQL`

#### To run the project in your own environment:

Please use Ubuntu 22.04... to run the project, to avoid possible complications with file execution rights to prefill
database tables

```shell
cd~
mkdir app
cd app/
git clone https://github.com/DenisStrykov/recipes_webapp;
cd recipes_webapp/
docker compose up -d --build

chmod u+x show_all.sh[start.sh](start.sh)

```

