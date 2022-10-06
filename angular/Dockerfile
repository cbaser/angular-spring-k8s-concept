### STAGE 1: Build ###
FROM node:16 AS build

WORKDIR /app

COPY package*.json /app/

RUN npm install
COPY ./ /app/
ARG configuration=production

RUN npm run build -- --output-path=./dist/out --configuration $configuration


### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/out/ /usr/share/nginx/html
