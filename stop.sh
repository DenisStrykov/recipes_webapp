#!/bin/bash

sudo docker kill webapp postgres
sudo docker rm webapp postgres
sudo docker rmi client:0.0.1 recipes_webapp-postgres:latest

cd ~ || exit
rm -rf app/

echo "Thank you for your time"