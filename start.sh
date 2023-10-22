#!/bin/bash

cd~
mkdir app4testing
cd appapp4testing/ || exit
git clone https://github.com/DenisStrykov/recipes_webapp
cd recipes_webapp/ || exit
chmod u+x stop.sh

sudo docker compose up -d --build
echo "Please go to link http://localhost:8091/recipes"