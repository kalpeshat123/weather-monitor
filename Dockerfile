FROM nginx:alpine
COPY dashboard/ /usr/share/nginx/html/
COPY weather.json /usr/share/nginx/html/
