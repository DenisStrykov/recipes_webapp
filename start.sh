#!/bin/bash

cd ~ || exit
mkdir app4testing
cd app4testing/ || exit
git clone https://github.com/DenisStrykov/recipes_webapp
cd recipes_webapp/ || exit

sudo docker compose up -d --build
echo "Please go to link http://localhost:8091/recipes"