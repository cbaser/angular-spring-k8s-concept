### STAGE 1: Build ###
FROM node:16 AS build

WORKDIR .

COPY . .

RUN npm install -g @angular/cli @angular-devkit/build-angular && npm install
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build ../static/admin/dist/ /usr/share/nginx/html
