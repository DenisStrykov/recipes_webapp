#!/bin/bash

cd~;
mkdir app
cd app/
git clone https://github.com/DenisStrykov/recipes_webapp
cd recipes_webapp/
sudo docker compose up -d --build
echo "Please go to link http://localhost:8091/recipes"